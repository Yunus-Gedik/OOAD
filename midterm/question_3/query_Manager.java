import java.util.ArrayList;

public class query_Manager {
    ArrayList<query> commands = new ArrayList<query>();

    /**
     * Adds new command i.e. query
     * @param q new command
     */
    void add_query(query q){
        commands.add(q);
    }

    /**
     * Execute added commands atomic
     * @return true if transaction succeed, false otherwise
     */
    boolean execute(){
        for(int i=0;i<commands.size();++i){
            if(!commands.get(i).execute()){
                System.out.println("A problem occurred while performing commands!");
                for(int j= i;j>=0;--j){
                    commands.get(j).undo();
                }
                return false;
            }
        }
        return true;
    }
}
