class WhileclosedAST extends ClosedstateAST implements AST{
    public ClosedstateAST close;
    public ExprAST expr;

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

    public String getType(Visitor e) throws TypeConflictException{
        if(this.expr.getType(e).equals("int") || this.expr.getType(e).equals("bool"))
            return this.close.getType(e);
        else
            throw new TypeConflictException(String.format(
                "While loop requires boolean based expression  not: %s", this.expr.getType(e)
            ));
    }
}
