class ReturnSimpleExprAST extends ReturnsimpleAST implements AST{
    ExprAST expr;

    public ReturnSimpleExprAST(ExprAST expr){
        this.expr = expr;
    }


    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        return getBase(indent)+ String.format("return %s;", this.expr);
    }
}
