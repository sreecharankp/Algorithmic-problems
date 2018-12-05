public class CoinChangeProb {

    public int naiveCoinChange(int M, int[] v, int index) {
        if (M < 0) return 0;
        if (M == 0) return 1;

        if (v.length == index) return 0;

        return naiveCoinChange(M - v[index], v, index) + naiveCoinChange(M, v, index + 1);
    }

    public void dynamicCoinChange(int M, int[] v) {

        int[][] dpTable = new int[v.length + 1][M + 1];

        //Initianlization
        for (int i = 0; i <= v.length; i++) {
            dpTable[i][0] = 1;
        }

        for (int i = 1; i <= M; i++) {
            dpTable[0][i] = 0;
        }

        //O(v*M)
        for (int i = 1; i <= v.length; i++) {
            for (int j = 1; j <= M; j++) {

                if (v[i - 1] <= j) {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - v[i - 1]];
                } else {
                    dpTable[i][j] = dpTable[i - 1][j];
                }
            }
        }

        for(int i=0;i<v.length+1;i++){
            for(int j=0;j<M+1;j++){
                System.out.print(dpTable[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Solution: " + dpTable[v.length][M]);
    }

    public static void main(String[] args) {
        int[] v = {1, 2, 3};
        int M = 4;
        CoinChangeProb prob = new CoinChangeProb();
        //System.out.println(prob.naiveCoinChange(M, v, 0));
        prob.dynamicCoinChange(M, v);
    }
}
