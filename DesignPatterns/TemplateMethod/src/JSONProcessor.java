public class JSONProcessor extends DataProcessor {

    @Override
    protected void readFile() {
        System.out.println("Reading JSON file...");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing JSON structure...");
    }

    @Override
    protected void saveResults() {
        System.out.println("Saving JSON results...");
    }
}
