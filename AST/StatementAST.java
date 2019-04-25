class StatementAST extends SimpleMethods implements AST{
    public OpenstateAST open;
    public ClosedstateAST close;
    public StatementAST(){}

    public StatementAST(OpenstateAST open){
        this.open = open;
        this.close = null;
    }

    public StatementAST(ClosedstateAST closed){
        this.close = closed;
        this.open = null;
    }


    public void accept(Visitor v){
        v.visit(this);
        if(this.open != null)
            this.open.accept(v);
        if(this.close != null)
            this.close.accept(v);
        //v.exit(); We will leave this to the lower level classes
    }


    public String toString(int indent){
        if(this.open != null){
            return(""+ String.format("%s", this.open.toString(indent)));
        }
        return(""+ String.format("%s", this.close.toString(indent)));
    }

    public String getType(Visitor e){
        if(this.open != null)
            return this.open.getType(e);
        if(this.close != null)
            return this.close.getType(e);
        return "";
    }
    
    public Object getValue(Visitor v){ return null;

    }
}
