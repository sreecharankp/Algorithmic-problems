public class NQueensProblem {
    static class QueenProb {
        int numberOfQueens;
        int[][] chessBoard;

        public QueenProb(int numberOfQueens) {
            this.numberOfQueens = numberOfQueens;
            this.chessBoard = new int[numberOfQueens][numberOfQueens];
        }

        public void solve() {
            if (setQueens(0)) {
                printQueens();
            } else {
                System.out.println("Solution is not possible");
            }
        }

        private boolean setQueens(int colIndex) {

            if (colIndex == numberOfQueens) {
                return true;
            }

            for (int rowIndex = 0; rowIndex < numberOfQueens; rowIndex++) {
                if (isPlacedValid(rowIndex, colIndex)) {
                    chessBoard[rowIndex][colIndex] = 1;
                    if (setQueens(colIndex+1)) {
                        return true;
                    }

                    //Backtracking!!!
                    chessBoard[rowIndex][colIndex] = 0;
                }
            }

            return false;
        }

        private boolean isPlacedValid(int rowIndex, int colIndex) {

            for (int i = 0; i < colIndex; i++)
                if (chessBoard[rowIndex][i] == 1)
                    return false;

            for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == 1)
                    return false;
            }

            for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--) {
                if (chessBoard[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }

        private void printQueens() {
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard.length; j++) {
                    if (chessBoard[i][j] == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        QueenProb prob=new QueenProb(5);
        prob.solve();
    }
}
