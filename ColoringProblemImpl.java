public class ColoringProblemImpl {

    static class ColoringProblem {
        private int numberOfVerticies;
        private int numberOfColors;
        private int[][] matrix;
        private int[] colors;

        public ColoringProblem(int[][] matrix, int numberOfColors) {
            this.matrix = matrix;
            this.numberOfColors = numberOfColors;
            this.numberOfVerticies = matrix.length;
            this.colors = new int[numberOfVerticies];
        }

        public void solve() {
            if (solveProblem(0)) {
                printColors();
            } else {
                System.out.println("Solution is not possible..!!!");
            }
        }

        private boolean solveProblem(int nodeIndex) {
            if (nodeIndex == numberOfVerticies) {
                return true;
            }

            for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
                if (isColorValid(nodeIndex, colorIndex)) {
                    colors[nodeIndex] = colorIndex;

                    if (solveProblem(nodeIndex + 1)) {
                        return true;
                    }

                    //BackTraching !!!
                }
            }

            return false;
        }

        private boolean isColorValid(int nodeIndex, int colorIndex) {
            for (int i = 0; i < numberOfVerticies; i++) {
                if (matrix[nodeIndex][i] == 1 && colors[i] == colorIndex) {
                    return false;
                }
            }
            return true;
        }

        private void printColors() {
            for (int i = 0; i < numberOfVerticies; i++) {
                System.out.println("Node " + (i + 1) + " colored with: " + colors[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };

        int numOfColors = 3;

        ColoringProblem problem = new ColoringProblem(matrix, numOfColors);
        problem.solve();
    }
}
