public class KnightsTourProblemImpl {

    static class Constants {
        private Constants() {

        }

        public static final int BORAD_SIZE = 8;
        public static final int NUMBER_OF_MOVES = 8;
    }

    static class KnightTourProblem {
        private int[][] solutionMatrix;
        private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        public KnightTourProblem() {
            this.solutionMatrix = new int[Constants.BORAD_SIZE][Constants.BORAD_SIZE];
            initializeBoard();
        }

        private void initializeBoard() {
            for (int i = 0; i < Constants.BORAD_SIZE; i++) {
                for (int j = 0; j < Constants.BORAD_SIZE; j++) {
                    solutionMatrix[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        public void solveTour() {
            solutionMatrix[0][0] = 1;
            if (solve(2, 0, 0)) {
                printSolution();
            } else {
                System.out.println("Solution is Not Feasible!!!");
            }
        }

        private boolean solve(int stepCount, int x, int y) {

            if (stepCount == Constants.BORAD_SIZE * Constants.BORAD_SIZE + 1) {
                return true;
            }

            for (int i = 0; i < Constants.NUMBER_OF_MOVES; i++) {
                int nextX = x + xMoves[i];
                int nextY = y + yMoves[i];

                if (isStepValid(nextX, nextY)) {
                    solutionMatrix[nextX][nextY] = stepCount;

                    if (solve(stepCount + 1, nextX, nextY)) {
                        return true;
                    }

                    //BACKTRACK !!!
                    solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
                }
            }

            return false;
        }

        private boolean isStepValid(int x, int y) {
            if (x < 0 || x >= Constants.BORAD_SIZE) return false;
            if (y < 0 || y >= Constants.BORAD_SIZE) return false;
            if (solutionMatrix[x][y] != Integer.MIN_VALUE) return false;

            return true;
        }

        private void printSolution() {
            for (int i = 0; i < Constants.BORAD_SIZE; i++) {
                for (int j = 0; j < Constants.BORAD_SIZE; j++) {
                    System.out.print(solutionMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        KnightTourProblem problem = new KnightTourProblem();
        problem.solveTour();
    }
}
