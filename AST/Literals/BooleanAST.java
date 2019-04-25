class BooleanAST extends ExpressionLiterals implements AST{
    public boolean is;

    public BooleanAST(boolean b){
        super("bool");
        this.is = b;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if(this.is){
            return "true";
        } else {
            return "false";
        }
    }

    public String getType(Visitor v){
        return "bool";
    }
    public Object getValue(Visitor v){ return null;

    }
}
