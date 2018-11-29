public class HamiltonianCycleImpl {

    static class HamiltonianCycle {
        private int numberOfVertices;
        private int[] hamiltonPath;
        private int[][] adjescentMatrix;

        public HamiltonianCycle(int[][] adjescentMatrix) {
            this.adjescentMatrix = adjescentMatrix;
            this.hamiltonPath = new int[adjescentMatrix.length];
            this.numberOfVertices = adjescentMatrix.length;

            this.hamiltonPath[0] = 0;
        }

        public void solve() {
            if (findFeasibleSolution(1)) {
                showHamiltonianPath();
            } else {
                System.out.println("No feasible solution...");
            }
        }

        private boolean findFeasibleSolution(int position) {

            if (position == numberOfVertices) {
                if (adjescentMatrix[hamiltonPath[position - 1]][hamiltonPath[0]] == 1) {
                    return true;
                } else {
                    return false;
                }
            }

            for (int vertexIndex = 1; vertexIndex < numberOfVertices; vertexIndex++) {
                if (isFeasible(vertexIndex, position)) {
                    hamiltonPath[position] = vertexIndex;
                    if (findFeasibleSolution(position + 1)) {
                        return true;
                    }
                }

                //Backtrack
            }
            return false;
        }

        private boolean isFeasible(int vertexIndex, int position) {

            //First Criteria: Weather two nodes are connected.?
            if (adjescentMatrix[hamiltonPath[position - 1]][vertexIndex] == 0) {
                return false;
            }

            //Seccond Criteria: Node is already visited or not
            for (int i = 0; i < position; i++) {
                if (hamiltonPath[i] == vertexIndex) {
                    return false;
                }
            }
            return true;
        }

        private void showHamiltonianPath() {
            System.out.println("Hamilton Cycle: ");
            for (int i = 0; i < hamiltonPath.length; i++) {
                System.out.print(hamiltonPath[i] + " ");
            }
            System.out.print(hamiltonPath[0]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };
        HamiltonianCycle algo = new HamiltonianCycle(matrix);
        algo.solve();
    }
}
