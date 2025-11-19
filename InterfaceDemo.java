// 1. The Interface
// This is the CONTRACT. Any class that implements this MUST 
// provide the body for 'shareContent'.
interface SocialMediaPlatform {
    void shareContent(String message);
}

// 2. Implementation A: Twitter (X)
class Twitter implements SocialMediaPlatform {
    @Override
    public void shareContent(String message) {
        // Twitter specific logic: Check character limit
        if (message.length() > 280) {
            System.out.println("[Twitter] Error: Tweet is too long!");
        } else {
            System.out.println("[Twitter] Tweeting: " + message + " #Trending");
        }
    }
}

// 3. Implementation B: Instagram
class Instagram implements SocialMediaPlatform {
    @Override
    public void shareContent(String message) {
        // Instagram specific logic: It treats text as a caption
        System.out.println("[Instagram] Posting photo with caption: " + message + " 📸 (Filter Applied)");
    }
}

// 4. Implementation C: WhatsApp
class WhatsApp implements SocialMediaPlatform {
    @Override
    public void shareContent(String message) {
        // WhatsApp specific logic: Encrypts the message
        System.out.println("[WhatsApp] Sending encrypted message to contact: " + message + " 🔒");
    }
}

// 5. The "Phone" / Client Code
public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("--- Universal Social Media Sharer ---\n");

        // POLYMORPHISM:
        // We use the Interface type (SocialMediaPlatform) to hold different objects.
        // This is like a "Universal Remote" controlling different TVs.
        
        SocialMediaPlatform app1 = new Twitter();
        SocialMediaPlatform app2 = new Instagram();
        SocialMediaPlatform app3 = new WhatsApp();

        // The user types one message...
        String myStatus = "Learning Java Interfaces is fun!";

        // ...and the code works the same way for all apps, 
        // even though the internal behavior is completely different.
        
        app1.shareContent(myStatus);
        app2.shareContent(myStatus);
        app3.shareContent(myStatus);
        
        System.out.println("\n--- Testing Twitter Limit ---");
        app1.shareContent("This is a very very very very very long tweet that might arguably exceed the character limit if I keep typing random words just to prove a point about how the implementation logic works inside the class....");
    }
}