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

    public void accept(Visitor v){
        this.expr.accept(v);
        if(this.plist != null)
            this.plist.accept(v);
        v.visit(this);
    }

    public String toString(){
        if(this.plist != null){
            return(""+ String.format("%s, %s", this.expr, this.plist));
        }
        return(""+ String.format("%s", this.expr));
    }

    public String getType(Visitor e){
        // Not sure if I have to check this one;
        return "";
    }
}
