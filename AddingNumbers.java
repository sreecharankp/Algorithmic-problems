public class AddingNumbers {

    public static void main(String[] args) {
        System.out.println(addingNumbersByIteration(5));
        System.out.println(addingNumbersByRecursion(5));
    }

    private static int addingNumbersByRecursion(int n) {
        if (n == 1) return 1;
        return n + addingNumbersByRecursion(n - 1);
    }

    private static int addingNumbersByIteration(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = result + i;
        }
        return result;
    }
}
