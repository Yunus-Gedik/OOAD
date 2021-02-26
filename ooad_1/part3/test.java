public class test{

    public static void main(String[] args){

        suit s1 = new ora();
        System.out.println("Cost is : " + s1.cost());
        System.out.println("Weight is : " + s1.weight());
        System.out.println("Description is : " + s1.getname() + "\n");

        suit s2 = new tor();
        s2 = new Laser(s2);
        s2 = new Laser(s2);
        s2 = new RocketLauncher(s2);
        System.out.println("Cost is : " + s2.cost());
        System.out.println("Weight is : " + s2.weight());
        System.out.println("Description is : " + s2.getname());

    }

}