public class RocketLauncher extends Decorator{
    suit s;

    RocketLauncher(suit s){
        this.s = s;
    }

    public double cost() {
        return s.cost() + 150000;
    }

    public double weight() {
        return s.weight() + 7.5;
    }

    public String getname(){
        return s.getname() + " " + "Rocket Lancher ";
    }
}
