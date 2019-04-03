class WhileopenstateAST extends OpenstateAST implements AST{
    OpenstateAST open;
    ExprAST expr;

    public WhileopenstateAST(ExprAST expr, OpenstateAST open){
        this.expr = expr;
        this.open = open;
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("WHILE ( %s )\n", this.expr)
                + String.format("%s", this.open.toString(indent+1)));
    }
}
