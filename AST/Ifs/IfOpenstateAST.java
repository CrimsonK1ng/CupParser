class IfOpenstateAST extends OpenstateAST implements AST{
    ExprAST expr;
    OpenstateAST open;
    StatementAST  state;

    public IfOpenstateAST(ExprAST expr, StatementAST state){
        this.expr = expr;
        this.state=  state;
        this.open = null;
    }
    public IfOpenstateAST(ExprAST expr, OpenstateAST open){
        this.expr = expr;
        this.open = open;
        this.state = null;
    }

    public String toString(int indent){
        if(this.open != null){
            return(getBase(indent) + String.format("if ( %s )\n%s", this.expr, this.open.toString(indent+1)));
        }
        else if(this.state!= null){
            return(getBase(indent)+ String.format("if ( %s )\n%s", this.expr, this.state.toString(indent+1)));
        }
        return "UH OH";
    }
}
