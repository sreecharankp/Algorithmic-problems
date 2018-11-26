public class LinierAndBinarySearch {

    static int[] array = new int[]{2, 5, 7, 8, 9, 12, 14};

    public static void main(String[] args) {
        System.out.println(linerSearch(14));
        System.out.println(binarySearch(14));
    }

    private static int binarySearch(int item) {
        return binarySearch(0, array.length, item);
    }

    private static int binarySearch(int startIndex, int endIndex, int item) {
        if (endIndex < startIndex) {
            return -1;
        }

        int middle = (startIndex + endIndex) / 2;

        if (item == array[middle]) {
            return middle;
        } else if (item < array[middle]) {
            return binarySearch(startIndex, middle - 1, item);
        } else {
            return binarySearch(middle + 1, endIndex, item);
        }
    }

    private static int linerSearch(int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }


}
