
class TernaryexprAST extends ExprAST implements AST{
    ExprAST expr1;
    ExprAST true_expr;
    ExprAST false_expr;

    public TernaryexprAST(ExprAST e1, ExprAST e2, ExprAST e3){
        this.expr1 = e1;
        this.true_expr = e2;
        this.false_expr = e3;
    }


    public void accept(Visitor v){
        this.expr1.accept(v);
        this.true_expr.accept(v);
        this.false_expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+String.format("(%s ? %s : %s)", expr1, true_expr, false_expr));
    }
}
