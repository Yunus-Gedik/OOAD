public interface query {
    /**
     * perform query utility
     * @return
     */
    boolean execute();

    /**
     * rollback changes if execute returns false
     */
    void undo();
}
