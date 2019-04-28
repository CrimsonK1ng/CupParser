class WhileopenstateAST extends OpenstateAST implements AST{
    public OpenstateAST open;
    public ExprAST expr;

    public WhileopenstateAST(ExprAST expr, OpenstateAST open){
        this.expr = expr;
        this.open = open;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.expr.accept(v);
        this.open.accept(v);
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("while ( %s )\n", this.expr)
                + String.format("%s", this.open.toString(indent+1)));
    }

    public String getType(Visitor e){
        return this.open.getType(e);
    }

    public Object getValue(Visitor v){
        while((Boolean)this.expr.getValue(v)){
            System.out.println("WhileClosed :(");
            this.open.getValue(v);
        }
        return null;
    }
}
