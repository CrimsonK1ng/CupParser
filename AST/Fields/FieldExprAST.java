class FieldExprAST extends FieldAST implements AST{
    ExprAST expr;
    public FieldExprAST(ExprAST expr){
        this.expr= expr;
    }

    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){

        return ("" + String.format("%s;", this.expr));

    }
}
