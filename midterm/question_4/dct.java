import java.util.ArrayList;

public class dct extends templateTransform{

    /**
     * Calls super which I defined
     * @param f
     */
    dct(String f){
        super(f);
    }

    /**
     * Performs DCT transofrmation and save is in "out" arraylist.
     */
    @Override
    void transform() {
        for(int k = 0; k< in.size(); ++k){
            complex total = new complex();
            for(int n=0;n<in.size();++n){
                total.real = total.real + ( in.get(n) * Math.cos((Math.PI*k*((2*n)+1)) / (in.size()*2)));
            }
            out.add(total);
        }
    }
}
