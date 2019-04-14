class WhileclosedAST extends ClosedstateAST implements AST{
    ClosedstateAST close;
    ExprAST expr;

    public WhileclosedAST(ExprAST expr, ClosedstateAST c1){
        this.close = c1;
        this.expr = expr;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.expr.accept(v);
        this.close.accept(v);
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("while ( %s )\n", this.expr)
                + String.format("%s", this.close.toString(indent+1)));
    }
}
