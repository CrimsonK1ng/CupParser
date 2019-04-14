class SimpleAssignAST extends SimplestateAST{
    NameAST name;
    ExprAST expr;

    public SimpleAssignAST(NameAST n, ExprAST e){
        this.name = n;
        this.expr = e;
    }


    public void accept(Visitor v){
        this.name.accept(v);
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return("" + String.format("%s = %s;", this.name, this.expr));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s = %s;", this.name, this.expr));
    }
}
