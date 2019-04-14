class IfOpenStateCloseOpenAST extends OpenstateAST{
    ExprAST expr;
    OpenstateAST open;
    ClosedstateAST closed;

    public IfOpenStateCloseOpenAST(ExprAST e, ClosedstateAST c, OpenstateAST o){
        this.expr = e;
        this.closed = c;
        this.open = o;
    }

    public void accept(Visitor v){
        v.visit(this);
        this.expr.accept(v);
        this.closed.accept(v);
        this.open.accept(v);
    }


    public String toString(int indent){
        return(getBase(indent) + String.format("if ( %s )\n", this.expr)
                + String.format("%s\n", this.closed.toString(indent+1))
                + getBase(indent) + "else\n"
                + String.format("%s", this.open.toString(indent+1)));
    }
}
