public class CSVProcessor extends DataProcessor {

    @Override
    protected void readFile() {
        System.out.println("Reading CSV file...");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing CSV using commas...");
    }

    @Override
    protected void saveResults() {
        System.out.println("Saving CSV results...");
    }
}
