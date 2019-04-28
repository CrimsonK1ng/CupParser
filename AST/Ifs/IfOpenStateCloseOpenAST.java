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

    public String getType(Visitor v){
        if(this.open.getType(v).equals(this.closed.getType(v)))
            return this.open.getType(v);
        else if (this.open.getType(v).isEmpty() && !this.closed.getType(v).isEmpty())
            return this.closed.getType(v);
        else if (!this.open.getType(v).isEmpty() && this.closed.getType(v).isEmpty())
            return this.open.getType(v);
        else
            throw new TypeConflictException(
                String.format("Return type conflict %s %s", this.open.getType(v), this.closed.getType(v))
            );
    }
    public Object getValue(Visitor v) {
        if((Boolean) this.expr.getValue(v)){
            this.closed.getValue(v);
        } else{
            this.open.getValue(v);
        }
        return null;
    }
}
