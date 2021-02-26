public class update {
    String where;
    String which;
    String value;
    String old_value;

    void set(String where,String which,String value){
        this.where = where;
        this.which = which;
        this.value = value;
    }

    boolean perform(){
        System.out.println("Performing update...");
        // Fill "old_value" here or in constructor before updating.
        if(where != null && which != null ){
            return true;
        }
        return false;
    }
    void rollback(){
        System.out.println("Rollbacking update...");
        /*
            Assign "old_value" to "value".
            Call "perform".
         */
    }
}
