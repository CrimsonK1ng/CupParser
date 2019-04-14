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


    public void accept(Visitor v){
        v.visit(this);
        if(this.open != null)
            this.open.accept(v);
        if(this.close != null)
            this.close.accept(v);
        //v.exitScope(); We will leave this to the lower level classes
    }


    public String toString(int indent){
        if(this.open != null){
            return("" + String.format("%s", this.open.toString(indent)));
        }
        return("" + String.format("%s", this.close.toString(indent)));
    }
}
