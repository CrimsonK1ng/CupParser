class SimpleNewStateAST extends ClosedstateAST {

    StatementAST state;

    public SimpleNewStateAST(StatementAST s){
        this.state = s;
    }

    public String toString(int indent){
        return("" + String.format("%s", this.state));
    }
}
