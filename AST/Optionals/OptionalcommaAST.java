class OptionalcommaAST implements AST{
    boolean iscomma;

    public OptionalcommaAST(boolean t){
        this.iscomma = t;
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if(this.iscomma){
            return "";
        }
        return ",";
    }

    public String getType(Visitor e){
        return "";
    }
    public Object getValue(Visitor v){ return null;

    }
}
