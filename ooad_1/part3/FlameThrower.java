public class FlameThrower extends Decorator{

    suit s;

    FlameThrower(suit s){
        this.s = s;
    }

    public double cost() {
        return s.cost() + 50000;
    }

    public double weight() {
        return s.weight() + 2;
    }

    public String getname(){
        return s.getname() + " " + "Flame Thrower ";
    }
    
}
