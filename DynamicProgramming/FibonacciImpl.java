import java.util.*;

public class FibonacciImpl {

    static Map<Integer, Integer> memorizeTable;

    public FibonacciImpl() {
        memorizeTable = new HashMap<>();
        memorizeTable.put(0, 0);
        memorizeTable.put(1, 1);
    }

    public static void main(String[] args) {
        FibonacciImpl fibonacciImpl = new FibonacciImpl();
        System.out.println(fibonacciImpl.getFibonacciNumberRecursive(5));
        System.out.println(fibonacciImpl.getFibonacciNumberDP(1000));
    }

    private static int getFibonacciNumberRecursive(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        return getFibonacciNumberRecursive(number - 1) + getFibonacciNumberRecursive(number - 2);
    }

    private static int getFibonacciNumberDP(int number) {

        if (memorizeTable.containsKey(number)) return memorizeTable.get(number);

        memorizeTable.put(number - 1, getFibonacciNumberDP(number - 1));
        memorizeTable.put(number - 2, getFibonacciNumberDP(number - 2));

        int calculateNumber = memorizeTable.get(number - 1) + memorizeTable.get(number - 2);
        return calculateNumber;
    }
}
