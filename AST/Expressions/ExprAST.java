class ExprAST implements AST{
    AST expr;
    int indent;
    public ExprAST(){}

    public ExprAST(AST expr){
        this.expr = expr;
    }


    public String toString(){
        return("" + String.format("%s", expr));
    }

}
