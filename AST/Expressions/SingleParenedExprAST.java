class SingleParenedExprAST extends SingleexprAST{
    ExprAST expr;
    public SingleParenedExprAST(ExprAST expr){
        this.expr = expr;
    }

    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+String.format("(%s)", expr));
    }
}
