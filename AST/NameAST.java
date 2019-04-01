class NameAST implements AST{
    IdentAST id;
    ExprAST expr;

    public NameAST(IdentAST id){
        this.id = id;
        this.expr = null;
    }

    public NameAST(IdentAST id, ExprAST expr){
        this.id = id;
        this.expr = expr;
    }

    public String toString(){
        if(this.expr == null){
            return("" + String.format("%s",this.id));
        } else {
            return("" + String.format("%s [%s]", this.id, this.expr));
        }
    }
}
