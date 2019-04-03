class SingleQuotedExprAST extends SingleexprAST{
    ExprAST expr;
    public SingleQuotedExprAST(ExprAST expr){
        this.expr = expr;
    }
    public String toString(){
        return(""+String.format("(%s)", expr));
    }
}
