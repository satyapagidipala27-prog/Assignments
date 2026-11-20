/** Defines the fixed steps used to process a data file. */
public abstract class DataProcessor {

    /** Template method: subclasses provide the details for each file type. */
    public final void processFile() {
        readFile();
        parseData();
        processData();
        saveResults();
    }

    protected abstract void readFile();

    protected abstract void parseData();

    /** Shared processing step; subclasses may customize it. */
    protected void processData() {
        System.out.println("Processing the data...");
    }

    protected abstract void saveResults();
}
