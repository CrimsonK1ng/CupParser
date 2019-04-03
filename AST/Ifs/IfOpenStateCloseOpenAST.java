class IfOpenStateCloseOpenAST extends OpenstateAST{
    ExprAST expr;
    OpenstateAST open;
    ClosedstateAST closed;

    public IfOpenStateCloseOpenAST(ExprAST e, ClosedstateAST c, OpenstateAST o){
        this.expr = e;
        this.closed = c;
        this.open = o;
    }

    public String toString(){
        return("" + String.format("IF ( %s )\n%s\nELSE\n%s", this.expr, this.closed, this.open));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("IF OPEN ( %s )\n", this.expr)
                + String.format("%s\n", this.closed.toString(indent+1))
                + getBase(indent) + "ELSE\n"
                + String.format("%s", this.open.toString(indent+1)));
    }
}
