public class client {
    /**
     * Main method to use system
     * @param args
     */
    public static void main(String[] args){
        query_Manager manage = new query_Manager();


        // Here to demonstrate undo,i.e rollback operations "which" parameter passed as null.
        update Update = new update();
        Update.set("accounts",null,"1£");

        select Select = new select();
        Select.set("banks", "participation");

        alter Alter = new alter();
        Alter.set("poors","salary_in_₺");


        query com_up = new command_update(Update);
        query com_sel = new command_select(Select);
        query com_al = new command_alter(Alter);


        manage.add_query(com_sel);
        manage.add_query(com_al);
        manage.add_query(com_up);

        manage.execute();
    }

}
