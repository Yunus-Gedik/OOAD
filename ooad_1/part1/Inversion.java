class Inversion implements Method{ 

    /** 
     * Inverse matrix calculator, also checks for singularity
     * 
     * @param A[][] coefficients array
     * @param [][]inverse inversed A[][] stores here
     * @return boolean if singular then return false
     */
    private boolean inverse(double[][] A, double [][]inverse) {
        double [][]adj = new double[N][N]; 
        double deter;

        if ((deter = determinant(A, N)) == 0) { 
            System.out.println("Singular matrix, can't find its inverse!"); 
            return false; 
        } 
        
        adjoint(A, adj); 
    

        for (int i = 0; i < N; ++i){
            for (int j = 0; j < N; ++j){ 
                inverse[i][j] = adj[i][j]/(float)deter; 
            }
        }
        return true; 
    } 

    /** 
     * Calculates cofactor of A[p][q] and save it in temp[][]
     * 
     * @param A[][] coefficients array
     * @param temp[][] array to save cofactor of coefficients
     * @param p row index
     * @param q column index
     * @param n current dimension
     */
    private void Cofactor(double A[][], double temp[][], int p, int q, int n){ 
        int i = 0, j = 0; 
    
        for (int row = 0; row < n; ++row) { 
            for (int col = 0; col < n; ++col) { 
                if (row != p && col != q) { 
                    temp[i][j++] = A[row][col]; 

                    if (j == n - 1) { 
                        j = 0; 
                        ++i; 
                    } 
                } 
            } 
        } 
    } 
    
    /** 
     * @param A[][] coefficients array
     * @param [][]adj Adjoint matrice of A[][]
     */
    private void adjoint(double A[][],double [][]adj){ 
        if (N == 1){
            adj[0][0] = 1; 
            return; 
        } 
    
        double sign = 1; 
        double [][]temp = new double[N][N]; 
    
        for (int i = 0; i < N; ++i) { 
            for (int j = 0; j < N; ++j) { 
                Cofactor(A, temp, i, j, N);
                if(((j+i)%2) == 0){
                    sign = 1;
                }
                else{
                    sign = -1;
                }
                adj[j][i] = (sign)*(determinant(temp, N-1)); 
            } 
        } 
    } 

    /** 
     * Recursive determinant calculator by using getCcofactor method
     * 
     * @param A[][] coefficients array
     * @param n current dimension
     * @return double
     */
    private double determinant(double A[][], int n) { 
        double D = 0; // Initialize result 
    
        // Base case 
        if (n == 1){
            return A[0][0]; 
        }

        double [][]t = new double[N][N]; 
        int sign = 1;  
    
        for (int f = 0; f < n; ++f) { 
            Cofactor(A, t, 0, f, n); 
            D +=  A[0][f] * sign * determinant(t,n -1); 
            sign = -sign; 
        } 
        return D; 
    }
    
    
    /** 
     * Multiplies two matrices A and B and return it double[]
     * 
     * @param A 
     * @param B
     * @return double[]
     */
    private double[] mulMat(double[][] A, double[] B){
        double[] last = new double[N];
        for(int i = 0; i < N; ++i) {
                for (int k = 0; k < N; ++k) {
                    last[i] += A[i][k] * B[k];
                }
        }

        return last;
    }
    
    private static int N = 0; 

    /** 
     * By using x = A^(-1) * B this method calculates the roots of given equations.
     * 
     * @param A coefficients array
     * @param B constants array
     * @return double[] roots array to be return
     */
    public double[] method(double[][] A, double[] B){

        N = B.length;

        double [][]adj = new double[N][N]; 
    
        double [][]inv = new double[N][N]; 
    
        adjoint(A, adj); 
    
        inverse(A, inv);
            
        return(mulMat(inv, B));
    }
}