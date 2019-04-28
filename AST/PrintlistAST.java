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

    public String getType(Visitor e) throws TypeConflictException{
        // Not sure if I have to check this one;
        PrintlistAST cur = this;
        while(cur != null){
            if(cur.expr.getType(e).equals("void") || cur.expr.getType(e).equals("array")){
                throw new TypeConflictException(String.format(
                    "Type %s cannot be printed", cur.expr.getType(e)
                ));
            }
            cur = cur.plist;

        }
        return "";
    }
    public Object getValue(Visitor v){
        System.out.print(this.expr.getValue(v));
        if(this.plist != null){
            System.out.print(" ");
            this.plist.getValue(v);
        }
        else{
            System.out.println("");
        }
        return null;
    }
}
