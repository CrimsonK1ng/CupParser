class ReturnSimpleExprAST extends ReturnsimpleAST implements AST{
    public ExprAST expr;

    public ReturnSimpleExprAST(ExprAST expr){
        this.expr = expr;
    }


    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        return getBase(indent)+ String.format("return %s;", this.expr);
    }

    @Override
    public String getType(Visitor e){
        return this.expr.getType(e);
    }
    public Object getValue(Visitor v){ return null;

    }
}
