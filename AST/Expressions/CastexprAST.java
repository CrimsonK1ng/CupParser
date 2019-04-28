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
    public Object getValue(Visitor v) {
        switch(this.type){
            case "int":
                return (Integer) this.expr.getValue(v);
            case "char":
                return (Character) this.expr.getValue(v);
            case "float":
                return (Float) this.expr.getValue(v);
            case "bool":
                return (Boolean) this.expr.getValue(v);
        }
        return null; //something fd up;
    }
}
