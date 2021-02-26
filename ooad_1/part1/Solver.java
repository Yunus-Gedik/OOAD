import java.util.*;

public class Solver {
    private Method method = null;
    private double[][] A;
    private double[] B;
    
    Solver(double[][] A, double[] B){
        this.A = A;
        this.B = B; 
    }

    Solver(){
        System.out.printf("enter the number of equations:\n");
        Scanner scan = new Scanner(System.in);
        int num_equ = scan.nextInt();
        System.out.printf("\n");

        A = new double[num_equ][num_equ];
        B = new double[num_equ];

        for(int i=0; i<num_equ; ++i){
            System.out.printf("Enter %d. equation (example: 5 3 -1 9) : \n", i );
            for(int j=0; j < num_equ ; ++j){
                A[i][j] = scan.nextDouble();
            }
            B[i] = scan.nextDouble();
        }
        scan.close();
    }

    
    /** 
     *  Dynamic changaeble solve method.
     * 
     * @param method Method to be desired.
     */
    public void setMethod(Method method){
        this.method = method;
    }

    public void solve(){
        double[] result = method.method(A, B);
        for(int i=0; i< result.length; ++i){
            System.out.printf("%f  ",result[i]);
        }
        System.out.println();
    }

}
