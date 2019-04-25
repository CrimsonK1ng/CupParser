class FieldAST implements AST{
    public ExprAST expr;
    public FieldAST(){
        this.expr = null;
    }
    public FieldAST(ExprAST expr){
        this.expr = expr;
    }
    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return ("");
    }

    public String getType(Visitor e){
        if(this.expr != null)
            return this.expr.getType(e);
        return "void";
    }
    public Object getValue(Visitor v){ return null;

    }
}
