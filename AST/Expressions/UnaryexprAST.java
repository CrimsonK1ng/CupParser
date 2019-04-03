class UnaryexprAST extends ExprAST implements AST{
    String operator;
    ExprAST expr;

    public UnaryexprAST(String str, ExprAST expr){
        this.operator = str;
        this.expr = expr;
    }

    public String toString(){
        return("" + String.format("%s%s", operator, expr));
    }

}
