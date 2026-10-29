public class HomeAutomationFacade {
    private Lighting lighting;
    private Heating heating;
    private Security security;

    public HomeAutomationFacade() {
        lighting = new Lighting();
        heating = new Heating();
        security = new Security();
    }

    public void leaveHome() {
        System.out.println("Leaving Home...");
        lighting.turnOff();
        heating.turnOff();
        security.activate();
    }

    public void arriveHome() {
        System.out.println("Arriving Home...");
        security.deactivate();
        lighting.turnOn();
        heating.turnOn();
    }

    public void turnEverythingOff() {
        lighting.turnOff();
        heating.turnOff();
        security.activate();
    }
}