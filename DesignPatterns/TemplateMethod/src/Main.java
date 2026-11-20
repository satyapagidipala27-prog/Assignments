public class Main {

    public static void main(String[] args) {
        DataProcessor csv = new CSVProcessor();
        System.out.println("CSV PROCESSING");
        csv.processFile();

        System.out.println("\nJSON PROCESSING");
        DataProcessor json = new JSONProcessor();
        json.processFile();
    }
}
