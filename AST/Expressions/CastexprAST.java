class CastexprAST extends ExprAST implements AST{
    TypeAST type;
    ExprAST expr;

    public CastexprAST(TypeAST type, ExprAST expr){
        this.type = type;
        this.expr = expr;

    }

    public String toString(){
        return("" + String.format("(%s) %s", type, expr));
    }
}
