
// Interface
 interface Notification 
{
    void notifyUser();
}

// Concrete Implementations
class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS...");
    }
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email...");
    }
}

// Factory Class
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) return null;
        
        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification n1 = factory.createNotification("SMS");
        n1.notifyUser();

        Notification n2 = factory.createNotification("EMAIL");
        n2.notifyUser();
    }
}