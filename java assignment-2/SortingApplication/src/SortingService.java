
public class SortingService {

    private final SortingAlgorithms algorithms = new SortingAlgorithms();

    public void sort(int[] arr, String algorithm) {

        switch (algorithm) {

            case "BUBBLE":
                algorithms.bubbleSort(arr);
                break;

            case "SELECTION":
                algorithms.selectionSort(arr);
                break;

            case "INSERTION":
                algorithms.insertionSort(arr);
                break;

            case "MERGE":
                algorithms.mergeSort(arr);
                break;

            case "QUICK":
                algorithms.quickSort(arr);
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported algorithm: " + algorithm
                );
        }
    }
}
