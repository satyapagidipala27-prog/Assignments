public class Main {
    public static void main(String[] args) {
        HomeAutomationFacade home =
                new HomeAutomationFacade();

        home.leaveHome();

        System.out.println();

        home.arriveHome();

        System.out.println();

        home.turnEverythingOff();
    }
}