public class TowerOfHonoi {

    public static void main(String[] args) {
        towerOfHonoi(3, 'A', 'B', 'C');
    }

    private static void towerOfHonoi(int n, char from, char middle, char to) {
        if (n == 1) {
            System.out.println("Plate 1 moved from: " + from + " to: " + to);
            return;
        }

        towerOfHonoi(n - 1, from, to, middle);
        System.out.println("Plate " + n + " moved from: " + from + " to: " + to);
        towerOfHonoi(n - 1, middle, from, to);
    }
}
