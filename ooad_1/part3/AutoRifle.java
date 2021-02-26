public class AutoRifle extends Decorator{
    suit s;

    AutoRifle(suit s){
        this.s = s;
    }

    public double cost() {
        return s.cost() + 30000;
    }

    public double weight() {
        return s.weight() + 1.5;
    }

    public String getname(){
        return s.getname() + " " + "Auto Rifle ";
    }

}
