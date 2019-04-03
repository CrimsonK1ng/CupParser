class SimpleAssignAST extends SimplestateAST{
    NameAST name;
    ExprAST expr;

    public SimpleAssignAST(NameAST n, ExprAST e){
        this.name = n;
        this.expr = e;
    }

    public String toString(){
        return("" + String.format("%s = %s;", this.name, this.expr));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s = %s;", this.name, this.expr));
    }
}
