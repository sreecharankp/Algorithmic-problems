public class EuclideanAlgoGCD {

    public static void main(String[] args) {
        System.out.println(findGcdIterative(30, 100));
        System.out.println();
        System.out.println(findGcdRecursive(30, 100));
    }

    public static int findGcdRecursive(int num1, int num2) {
        if (num2 == 0) return num1;
        return findGcdRecursive(num2, num1 % num2);
    }

    public static int findGcdIterative(int num1, int num2) {

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
