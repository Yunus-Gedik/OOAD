import java.io.IOException;

public class Main {
    /**
     * Performs transformations
     * @param args
     */
    public static void main(String[] args){

        templateTransform Dft_time = new dft(args[0],true);
        templateTransform Dft_notime = new dft(args[0]);
        templateTransform Dct = new dct(args[0]);

        Dft_notime.procedure();
        //Dft_time.procedure();
        //Dct.procedure();
    }
}
