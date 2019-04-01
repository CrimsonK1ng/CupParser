class BinaryexprAST implements AST{
    BinaryOp binop;
    ExprAST left;
    ExprAST right;

    public BinaryexprAST(ExprAST left, BinaryOp b, ExprAST right){
        this.binop = b;
        this.left = left;
        this.right = right;
        
    }

    public String toString(){
        return("" + String.format("%s %s %s", left, binop, right));
    }
}
