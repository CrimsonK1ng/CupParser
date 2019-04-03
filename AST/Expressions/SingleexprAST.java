
class SingleexprAST extends ExprAST implements AST{
    ExpressionLiterals expr;

    public SingleexprAST(){}

    public SingleexprAST(ExpressionLiterals expr){
        this.expr= expr;
    }

    public String toString(){
        return(""+String.format("%s", expr));
    }
}
