class StatementlistAST extends SimpleMethods implements AST{
    StatementAST state;
    StatementlistAST slist;

    public StatementlistAST(){}
    public StatementlistAST(StatementAST s, StatementlistAST sl){
        this.state = s;
        this.slist = sl;
    }


    public void accept(Visitor v){
        this.state.accept(v);
        if(this.slist.state != null)
            this.slist.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        if(this.state == null) return "";
        return(String.format("%s\n%s", this.state.toString(indent), this.slist.toString(indent)));
    }
}
