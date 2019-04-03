class StatementAST extends SimpleMethods implements AST{
    OpenstateAST open;
    ClosedstateAST close;
    public StatementAST(){}

    public StatementAST(OpenstateAST open){
        this.open = open;
        this.close = null;
    }

    public StatementAST(ClosedstateAST closed){
        this.close = closed;
        this.open = null;
    }


    public String toString(int indent){
        if(this.open != null){
            return("" + String.format("%s", this.open.toString(indent)));
        }
        return("" + String.format("%s", this.close.toString(indent)));
    }
}
