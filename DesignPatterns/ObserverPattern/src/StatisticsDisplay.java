public class StatisticsDisplay implements Observer {
    private float totalTemperature;
    private int count;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        totalTemperature += temperature;
        count++;

        System.out.println("Statistics Display:");
        System.out.println("Average Temperature: " + (totalTemperature / count));
        System.out.println("-------------------");
    }
}
