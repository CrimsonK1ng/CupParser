class ExprAST implements AST{
    public ExprAST expr;
    public String type;
    public ExprAST(){
    }

    public ExprAST(ExprAST expr){
        this.expr = expr;
    }

    public ExprAST(String type){
        this.expr = null;
        this.type = type;
    }
    public ExprAST(ExprAST expr, String type){
        this.expr = expr;
        this.type = type;
    }


    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }


    public String toString(){
        return(""+ String.format("%s", expr));
    }

    public String getType(Visitor e){
        if(this.expr != null)
            return expr.getType(e);
        return this.type;
    }

}
