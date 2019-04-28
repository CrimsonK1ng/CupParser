class FieldExprAST extends FieldAST implements AST{
    public FieldExprAST(ExprAST expr){
        super(expr);
    }

    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){

        return ("" + String.format("%s;", this.expr));

    }

    public String getType(Visitor e){
        return this.expr.getType(e);
    }
    public Object getValue(Visitor v) {
        return this.expr.getValue(v);
    }
}
