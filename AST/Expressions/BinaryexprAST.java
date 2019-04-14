class BinaryexprAST extends ExprAST implements AST{
    BinaryOp binop;
    ExprAST left;
    ExprAST right;

    public BinaryexprAST(ExprAST left, BinaryOp b, ExprAST right){
        this.binop = b;
        this.left = left;
        this.right = right;

    }

    public void accept(Visitor v){
        this.binop.accept(v);
        this.left.accept(v);
        this.right.accept(v);
        v.visit(this);
    }


    public String toString(){
        return("" + String.format("%s %s %s", left, binop, right));
    }
}
