class NameAST extends ExpressionLiterals implements AST{
    IdentAST id;
    public NameAST(){}

    public NameAST(IdentAST id){
        this.id = id;
    }

    public NameAST(IdentAST id, ExprAST expr){
        this.id = id;
    }

    public String toString(){
        return("" + String.format("%s",this.id));
    }
}
