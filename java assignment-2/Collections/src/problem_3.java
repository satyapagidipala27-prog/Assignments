import java.util.Arrays;

class problem_3 {
    private int[] arr;
    private int size;
    public problem_3() {
        arr = new int[5];
        size=0;

    }
    public void add(int value) {
        ensureCapacity();
        arr[size]=value;
        size++;
    }

    public int indexOf(int value) {
        for(int i=0;i<size;i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(int value) {
        return indexOf(value)!=-1;
    }
    public void addAll(int[] values){
        for(int value: values){
            add(value);
        }
    }
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = value;
        size++;
    }
    private void ensureCapacity() {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        problem_3 list = new problem_3();

        list.add(10);
        list.add(20);
        list.add(30);
        list.display(); // 10 20 30

        System.out.println(list.indexOf(20));
        System.out.println(list.contains(40));

        list.addAll(new int[]{40, 50});
        list.display();

        list.add(2, 25);
        list.display();
    }
}



