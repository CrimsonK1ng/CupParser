class FieldExprAST extends FieldAST implements AST{
    public ExprAST expr;
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

    public String getType(Visitor e){
        System.out.println("MADNESS " + this.expr.getType(e));
        return this.expr.getType(e);
    }
}
