public class FactorialOfNumber {

    public static void main(String[] args) {
        System.out.println(factorialUsingNormalRecusrion(5));
        System.out.println();
        System.out.println(factorialUsingNormalAccumulator(5));
    }

    private static int factorialUsingNormalAccumulator(int accumulator, int n) {
        if (n == 1) return accumulator;
        return factorialUsingNormalAccumulator(n * accumulator, n - 1);
    }

    private static int factorialUsingNormalAccumulator(int n) {
        return factorialUsingNormalAccumulator(1, n);
    }

    private static int factorialUsingNormalRecusrion(int n) {
        if (n == 1) return 1;
        return n * factorialUsingNormalRecusrion(n - 1);
    }
}
