
class SingleexprAST extends ExprAST implements AST{
    ExpressionLiterals expr;

    public SingleexprAST(){}

    public SingleexprAST(ExpressionLiterals expr){
        this.expr= expr;
    }

    public void accept(Visitor v){
        v.visit(this);
    }


    public String toString(){
        return(""+String.format("%s", expr));
    }
}
