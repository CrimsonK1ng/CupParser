class FieldAST implements AST{
    AST ast;

    public FieldAST(AST expr){
        this.ast = expr;
    }

    public String toString(){

        return ("" + String.format("%s;", this.ast));

    }
}
