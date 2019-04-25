
class SingleexprAST extends ExprAST implements AST{

    public SingleexprAST(){}

    public SingleexprAST(ExpressionLiterals expr){
        super(expr);
    }

    public void accept(Visitor v){
        v.visit(this);
    }


    public String toString(){
        return (""+String.format("%s", expr));
    }

    public String getType(Visitor e){
        return this.expr.getType(e);
    }
    public Object getValue(Visitor v){ return null;

    }
}
