
public class dft extends templateTransform{
    /**
     * Calls super which I defined
     * @param f
     */
    dft(String f){
        super(f);
    }

    /**
     * Calls super which I defined
     * @param f
     * @param time
     */
    dft(String f,boolean time){
        super(f,time);
    }

    /**
     * Performs DFT transofrmation and save is in "out" arraylist.
     */
    @Override
    void transform() {
        long begin = System.currentTimeMillis();
        for(int k = 0; k< in.size(); ++k){
            complex total = new complex();
            for(int n=0;n<in.size();++n){
                total.real = total.real + (in.get(n) * Math.cos((2*Math.PI*k*n)/in.size()));
                total.img = total.img + ((-1)* in.get(n) * Math.sin((2*Math.PI*k*n)/in.size()));
            }
            out.add(total);
        }
        long end = System.currentTimeMillis();
        if(time){
            System.out.printf("DFT took estimated %d milliseconds.",end-begin);
        }

    }

}
