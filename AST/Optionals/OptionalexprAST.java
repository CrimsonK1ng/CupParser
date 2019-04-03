class OptionalexprAST extends ExprAST implements AST{
    ExprAST expr;

    public OptionalexprAST(){
        this.expr = null;
    }

    public OptionalexprAST(ExprAST expr){
        this.expr = expr;
    }

    public String toString(){
        if (this.expr == null){
            return "";
        }
        return("" + String.format("= %s", this.expr));

    }

}
