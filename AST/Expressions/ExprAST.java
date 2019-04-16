class ExprAST implements AST{
    public ExprAST expr;
    public String type;
    public ExprAST(){
    }

    public ExprAST(ExprAST expr){
        this.expr = expr;
        this.type = expr.type;
    }

    public ExprAST(String type){
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
        System.out.println("UHHHH");
        return expr.getType(e);
    }

}
