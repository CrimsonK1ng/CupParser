class StatementlistAST extends SimpleMethods implements AST{
    StatementAST state;
    StatementlistAST slist;

    public StatementlistAST(){}

    public StatementlistAST(StatementAST s, StatementlistAST sl){
        this.state = s;
        this.slist = sl;
    }

    public String toString(int indent){
        if(this.state == null){
            return "";
        }
        else if(this.slist == null){
            return(String.format("%s\n", this.state.toString(indent)));
        }
        return(String.format("%s\n%s", this.state.toString(indent), this.slist.toString(indent)));
    }
}
