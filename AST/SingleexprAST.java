
class SingleexprAST implements AST{
    AST ast;
    ExprAST expr;

    public SingleexprAST(ExprAST expr){
        this.expr= expr;
    }

    public SingleexprAST(AST lit){
        this.ast = lit;
    }

    public String toString(){
        if(expr != null){
            return(""+String.format("(%s)", expr));
        } else{
            return(""+String.format("%s", ast));
        }
    }
}
