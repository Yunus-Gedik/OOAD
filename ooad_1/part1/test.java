public class test {
    public static void main(String[] args){
        Solver solve = new Solver();
        solve.setMethod(new Gauss());
        solve.solve();
        solve.setMethod(new Inversion());
        solve.solve();
    }
}
