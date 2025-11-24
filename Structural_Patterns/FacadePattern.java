class Light {
    public void on() {
        System.out.println("Lights are ON");
    }
    public void off() {
        System.out.println("Lights are OFF");
    }
}

class Thermostat {
    public void setTemperature(int temp) {
        System.out.println("Thermostat set to " + temp + " degrees");
    }
}

class SecurityCamera {
    public void startRecording() {
        System.out.println("Security Camera is RECORDING");
    }
    public void stopRecording() {
        System.out.println("Security Camera is STOPPED");
    }
}

class DoorLock {
    public void lock() {
        System.out.println("Doors are LOCKED");
    }
    public void unlock() {
        System.out.println("Doors are UNLOCKED");
    }
}

class SmartHomeFacade {
    private Light light;
    private Thermostat thermostat;
    private SecurityCamera camera;
    private DoorLock lock;

    public SmartHomeFacade() {
        this.light = new Light();
        this.thermostat = new Thermostat();
        this.camera = new SecurityCamera();
        this.lock = new DoorLock();
    }

    public void arriveHome() {
        System.out.println("\n--- Arriving Home Mode ---");
        lock.unlock();
        light.on();
        thermostat.setTemperature(24);
        camera.stopRecording();
    }

    public void leaveHome() {
        System.out.println("\n--- Leaving Home Mode ---");
        light.off();
        thermostat.setTemperature(18);
        lock.lock();
        camera.startRecording();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        
        smartHome.arriveHome();
        smartHome.leaveHome();
    }
}