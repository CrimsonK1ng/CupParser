class ExprAST implements AST{
    AST expr;

    public ExprAST(AST expr){
        this.expr = expr;
    }


    public String toString(){
        return("" + String.format("%s", expr));
    }

}
