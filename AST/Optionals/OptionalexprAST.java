class OptionalexprAST extends ExprAST implements AST{

    public OptionalexprAST(){
    }

    public OptionalexprAST(ExprAST expr){
        super(expr);
    }


    public void accept(Visitor v){
        if(this.expr != null)
            this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        if (this.expr == null){
            return "";
        }
        return(""+ String.format("= %s", this.expr));

    }

    public String getType(Visitor e){
        if(this.expr != null)
            return this.expr.getType(e);
        return "";
    }
    public Object getValue(Visitor v) {
        if(this.expr != null){
            return this.expr.getValue(v);
        }

        return null;
    }
}
