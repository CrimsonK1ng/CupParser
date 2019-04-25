class CastexprAST extends ExprAST implements AST{

    public CastexprAST(TypeAST type, ExprAST expr){
        super(expr, type.type);
    }

    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }


    public String toString(){
        return(""+ String.format("(%s) %s", type, expr));
    }

    public String getType(Visitor e){
        //TODO this is probably really screwed up
        return type;
    }
    public Object getValue(Visitor v){ return null;

    }
}
