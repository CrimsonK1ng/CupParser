
class NamearrayAST extends NameAST implements AST{
    IdentAST id;
    ExprAST expr;
    public NamearrayAST(IdentAST id){
        this.id = id;
        this.expr = null;
    }

    public NamearrayAST(IdentAST id, ExprAST expr){
        this.id = id;
        this.expr = expr;
    }

    public String toString(){
        return("" + String.format("%s [%s]", this.id, this.expr));
    }
}
