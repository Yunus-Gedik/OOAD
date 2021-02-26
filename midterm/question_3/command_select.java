public class command_select implements query{
    select Select;

    command_select(select Select){
        this.Select = Select;
    }

    @Override
    public boolean execute() {
        return Select.perform();
    }

    @Override
    public void undo() {
        Select.rollback();
    }
}
