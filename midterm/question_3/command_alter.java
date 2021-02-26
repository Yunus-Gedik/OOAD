public class command_alter implements query{
    alter Alter;

    command_alter(alter Alter){
        this.Alter = Alter;
    }

    @Override
    public boolean execute() {
        return Alter.perform();
    }

    @Override
    public void undo() {
        Alter.rollback();
    }
}
