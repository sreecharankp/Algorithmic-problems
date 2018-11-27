import java.util.Random;

public class QuickSelect {

    static int array[] = {1, 5, 4, 8, -2};

    public static void main(String[] args) {
        System.out.println(QuickSelect.select(1));
    }

    public static int select(int k) {
        return select(0, array.length - 1, k - 1);
    }

    private static int select(int firstIndex, int lastIndex, int k) {
        int pivot = partition(firstIndex, lastIndex);
        if (pivot > k) {
            return select(firstIndex, pivot - 1, k);
        } else if (pivot > k) {
            return select(pivot + 1, lastIndex, k);
        }

        return array[k];
    }

    public static int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
        swap(lastIndex, pivot);
        for (int i = firstIndex; i < lastIndex; ++i) {
            if (array[i] > array[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }
        swap(firstIndex, lastIndex);
        return firstIndex;
    }

    public static void swap(int lastIndex, int pivot) {
        int temp = array[lastIndex];
        array[lastIndex] = array[pivot];
        array[pivot] = temp;
    }
}
