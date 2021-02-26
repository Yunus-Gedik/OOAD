public class Gauss implements Method {

    private final double ep = 1e-10;
    
    /** 
     *  By using matrice multiplication this method performs gaussian elimination 
     *  to find the roots of given equations.
     * 
     * @param A Coefficient array
     * @param b Constant array
     * @return double[] result of gaussian method
     */
    public double[] method(double[][] A, double[] b){
        int n = b.length;
        double[] x = new double[n];

        for (int y = 0; y < n; ++y){
            int max = y;
            for (int i = y + 1; i < n; ++i){
                if (Math.abs(A[i][y]) > Math.abs(A[max][y])) {
                    max = i;
                }
            }

            double[] temp = A[y]; 
                     A[y] = A[max]; 
                     A[max] = temp;
            
            double t = b[y]; 
                       b[y] = b[max]; 
                       b[max] = t;

            if (Math.abs(A[y][y]) <= ep){
                throw new ArithmeticException("Possible singular matrix!");
            }

            for (int i = y + 1; i < n; ++i){
                double alpha = A[i][y] / A[y][y];
                b[i] -= alpha * b[y];
                for (int j = y; j < n; ++j){
                    A[i][j] -= A[y][j]* alpha;
                }
            }
        }

        for (int i = n - 1; i >= 0; --i){
            double sum = 0;
            for (int j = i+1; j < n; ++j){
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }

}