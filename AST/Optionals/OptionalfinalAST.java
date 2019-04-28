class OptionalfinalAST implements AST{
    boolean ifFinal;

    public OptionalfinalAST(Boolean is){
        this.ifFinal = is;
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if (this.ifFinal){
            return "final ";
        } else {
            return "";
        }
    }

    public String getType(Visitor e){
        return "";
    }
    public Object getValue(Visitor v) {
        return null;

    }
}
