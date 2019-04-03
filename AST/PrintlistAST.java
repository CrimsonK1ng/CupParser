class PrintlistAST implements AST{
    ExprAST expr;
    PrintlistAST plist;

    public PrintlistAST(ExprAST expr){
        this.expr = expr;
        this.plist = null;
    }

    public PrintlistAST(ExprAST expr, PrintlistAST p){
        this.expr = expr;
        this.plist = p;
    }

    public String toString(){
        if(this.plist != null){
            return("" + String.format("%s, %s", this.expr, this.plist));
        }
        return("" + String.format("%s", this.expr));
    }
}
