class AppSettings {
    private static AppSettings instance;
    private String theme;
    private int volume;

    private AppSettings() {
        this.theme = "Light Mode";
        this.volume = 50;
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public void displaySettings() {
        System.out.println("Current Theme: " + theme + " | Volume: " + volume);
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Get the single instance for the first time
        AppSettings settingsRef1 = AppSettings.getInstance();
        
        System.out.println("--- Initial State ---");
        settingsRef1.displaySettings();

        // Change the setting using the first reference
        settingsRef1.setTheme("Dark Mode");

        // Get the instance again (it returns the existing object)
        AppSettings settingsRef2 = AppSettings.getInstance();

        System.out.println("\n--- After Change ---");
        // Notice settingsRef2 already sees the change made by settingsRef1
        settingsRef2.displaySettings();
        
        System.out.println("\nAre they the same object? " + (settingsRef1 == settingsRef2));
    }
}