class IfOpenstateAST extends OpenstateAST implements AST{
    ExprAST expr;
    StatementAST  state;

    public IfOpenstateAST(ExprAST expr, StatementAST state){
        this.expr = expr;
        this.state=  state;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.expr.accept(v);
        if(this.state != null)
            this.state.accept(v);
    }

    public String toString(int indent){
        if(this.open != null){
            return(getBase(indent) + String.format("if ( %s )\n%s", this.expr, this.open.toString(indent+1)));
        }
        else if(this.state!= null){
            return(getBase(indent)+ String.format("if ( %s )\n%s", this.expr, this.state.toString(indent+1)));
        }
        return "UH OH";
    }

    public String getType(Visitor v){
        return this.state.getType(v);
    }
    public Object getValue(Visitor v){ return null;

    }
}
