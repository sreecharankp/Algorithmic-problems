public class HeadAndTailRecursion {

    public static void main(String[] args) {
        headRecursion(4);
        System.out.println();
        tailRecursion(4);
    }

    //Its similar to iterative for loop
    private static void tailRecursion(int n) {
        if (n == 0) return;
        System.out.println(n);
        tailRecursion(n - 1);
    }

    private static void headRecursion(int n) {
        if (n == 0) return;
        headRecursion(n - 1);
        System.out.println(n);
    }
}
