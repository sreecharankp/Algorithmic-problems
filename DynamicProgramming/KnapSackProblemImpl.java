public class KnapSackProblemImpl {

    private int numOfItems;
    private int capacityOfKnapSack;
    private int[][] knapsackTable;
    private int totalBenifit;
    private int[] weights;
    private int[] values;

    public KnapSackProblemImpl(int numOfItems, int capacityOfKnapSack, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.capacityOfKnapSack = capacityOfKnapSack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems + 1][capacityOfKnapSack + 1];
    }

    public void solve() {

        for (int i = 1; i < numOfItems + 1; i++) {
            for (int w = 1; w < capacityOfKnapSack + 1; w++) {

                int notTakingItem = knapsackTable[i - 1][w];
                int takingItem = 0;

                if (weights[i] <= w) {
                    takingItem = values[i] + knapsackTable[i - 1][w - weights[i]];
                }

                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }

        for (int i = 0; i < numOfItems + 1; i++) {
            for (int j = 0; j < capacityOfKnapSack + 1; j++) {
                System.out.print(knapsackTable[i][j] + " ");
            }
            System.out.println();
        }
        totalBenifit = knapsackTable[numOfItems][capacityOfKnapSack];
    }

    public void showResult() {

        System.out.println("Total benifit: " + totalBenifit);

        for (int n = numOfItems, w = capacityOfKnapSack; n > 0; n--) {
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n - 1][w]) {
                System.out.println("We take item: #" + n);
            }
        }
    }

    public static void main(String[] args) {
        /*
        Formulae for KnapSpack Problem
        S[i][w] = Math.max( S[i-1][w], v(i) + S[i-1, w-w(i)] )
        */

        int numOfItems = 3;
        int capacityOfKnapSack = 5;
        int[] weightsOfItem = new int[numOfItems + 1];
        weightsOfItem[1] = 4;
        weightsOfItem[2] = 2;
        weightsOfItem[3] = 3;
        int[] profitOfItems = new int[numOfItems + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        KnapSackProblemImpl knapSack = new KnapSackProblemImpl(numOfItems, capacityOfKnapSack, weightsOfItem, profitOfItems);
        knapSack.solve();
        knapSack.showResult();
    }
}
