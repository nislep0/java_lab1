public class Lab1 {

    static void main() {
        try {
            char[][] a = {
                    {'1', 'A', 'V'},
                    {'B', '&', '('}
            };

            char[][] b = {
                    {'j', '*'},
                    {'H', 'd'},
                    {'?', '^'}
            };

            char[][] c = multiplyMatrices(a, b);

            System.out.println("Matrix A:");
            printMatrix(a);

            System.out.println("\nMatrix B:");
            printMatrix(b);

            System.out.println("\nMatrix C = A * B:");
            printMatrix(c);

            double[] averages = rowAverages(c);

            System.out.println("\nAverage value of each row in matrix C:");
            for (int i = 0; i < averages.length; i++) {
                System.out.printf("Row %d: %.2f%n", i + 1, averages[i]);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static char[][] multiplyMatrices(char[][] a, char[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }

        int rows = a.length;
        int cols = b[0].length;
        int common = b.length;

        char[][] result = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < common; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = (char) sum;
            }
        }
        return result;
    }

    private static double[] rowAverages(char[][] matrix) {
        double[] averages = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            averages[i] = (double) sum / matrix[i].length;
        }
        return averages;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
