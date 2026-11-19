public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer current = new CurrentConditionsDisplay();
        Observer statistics = new StatisticsDisplay();
        Observer forecast = new ForecastDisplay();

        station.registerObserver(current);
        station.registerObserver(statistics);
        station.registerObserver(forecast);

        System.out.println("First Weather Update");
        station.setWeatherData(30, 65, 1018);

        System.out.println("Second Weather Update");
        station.setWeatherData(32, 70, 995);

        station.removeObserver(forecast);

        System.out.println("Third Weather Update");
        station.setWeatherData(28, 60, 1012);


    }
}
