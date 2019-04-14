class ExprAST implements AST{
    ExprAST expr;
    public ExprAST(){}

    public ExprAST(ExprAST expr){
        this.expr = expr;
    }


    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }


    public String toString(){
        return("" + String.format("%s", expr));
    }

}
