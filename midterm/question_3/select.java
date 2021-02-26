public class select {
    String from;
    String attribute;

    void set(String from,String attribute){
        this.from = from;
        this.attribute = attribute;
    }

    boolean perform(){
        System.out.println("Performing select...");
        if(from != null && attribute != null){
            return true;
        }
        return false;
    }
    void rollback(){
        System.out.println("Rollbacking select...");
        /*
            Actually select operation does not need rollback,
            because this operation does not have any side affect.
         */
    }
}
