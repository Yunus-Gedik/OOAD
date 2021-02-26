public class complex {
    double real;
    double img;
    complex(double real, double img){
        this.img =img;
        this.real =real;
    }

    complex(){
        real =0;
        img=0;
    }

    /**
     * toString method to make it able to write back transformations to file.
     * @return
     */
    @Override
    public String toString() {
        if(img == 0){
            return Double.toString(real);
        }
        return real +" "+ img + "i";
    }
}
