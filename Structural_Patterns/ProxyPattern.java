// 1. The Interface
// Defines the common behavior for both the Real Image and the Proxy.
interface Image {
    void display();
}

// 2. The Real Subject (The "Heavy" Object)
// This represents the actual high-resolution image that takes time to load.
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName); // Expensive operation happens on creation
    }

    // Simulating a heavy/expensive operation
    private void loadFromDisk(String fileName) {
        System.out.println("  [RealImage] Loading " + fileName + " from disk... (This takes time)");
        try {
            Thread.sleep(1000); // Simulate network/disk delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("  [RealImage] Displaying " + fileName);
    }
}

// 3. The Proxy Subject (The "Lightweight" Wrapper)
// Controls access to the RealImage. It handles "Lazy Loading".
class ProxyImage implements Image {
    private RealImage realImage; // Reference to the heavy object
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // LAZY INITIALIZATION:
        // Only create the expensive object when it is absolutely needed.
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// 4. Client Code
public class ProxyPattern {
    public static void main(String[] args) {
        System.out.println("--- Client: Creating Image Object (Proxy) ---");
        // The image is NOT loaded from disk yet. It's just a lightweight filename holder.
        Image image = new ProxyImage("high_res_photo.jpg");
        
        System.out.println("\n--- Client: Calling display() for the 1st time ---");
        // The proxy sees the real object is null, so it loads it now.
        image.display();

        System.out.println("\n--- Client: Calling display() for the 2nd time ---");
        // The proxy sees the real object already exists, so it skips loading.
        image.display();
    }
}