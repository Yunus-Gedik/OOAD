public class command_update implements query{
    update Update;

    command_update(update Update){
        this.Update = Update;
    }

    @Override
    public boolean execute() {
        return Update.perform();
    }

    @Override
    public void undo() {
        Update.rollback();
    }
}
