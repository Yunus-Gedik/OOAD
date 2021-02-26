public class alter {
    String table_name;
    String column_name;

    void set(String table_name,String column_name){
        this.table_name = table_name;
        this.column_name = column_name;
    }

    boolean perform(){
        System.out.println("Performing alter...");
        if(table_name != null && column_name != null){
            return true;
        }
        return false;
    }
    void rollback(){
        System.out.println("Rollbacking alter...");
        /*
            drop "column_name" from table if exist
         */
    }
}
