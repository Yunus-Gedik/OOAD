public class Laser extends Decorator{
    suit s;

    Laser(suit s){
        this.s = s;
    }

    public double cost() {
        return s.cost() + 200000;
    }

    public double weight() {
        return s.weight() + 5.5;
    }

    public String getname(){
        return s.getname() + " " + "Laser ";
    }
}
