import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class       MergeSortTask extends RecursiveAction {

    private static final int THRESHOLD = 2;

    private final int[] arr;
    private final int[] temp;
    private final int left;
    private final int right;

    MergeSortTask(int[] arr, int[] temp, int left, int right) {
        this.arr = arr;
        this.temp = temp;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left >= right) {
            return;
        }

        if (right - left + 1 <= THRESHOLD) {
            Arrays.sort(arr, left, right + 1);
            return;
        }

        int mid = left + (right - left) / 2;
        MergeSortTask leftTask = new MergeSortTask(arr, temp, left, mid);
        MergeSortTask rightTask = new MergeSortTask(arr, temp, mid + 1, right);

        leftTask.fork();
        rightTask.compute();
        leftTask.join();

        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, left, arr, left, right - left + 1);
    }
}

public class problem_3 {

    public static void main(String[] args) {
        int[] arr = {38, 12, 27, 43, 9, 31, 18, 25};
        int[] temp = new int[arr.length];

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        ForkJoinPool pool = new ForkJoinPool();
        try {
            pool.invoke(new MergeSortTask(arr, temp, 0, arr.length - 1));
        } finally {
            pool.shutdown();
        }

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("\nParallelism: " + pool.getParallelism());
    }
}
