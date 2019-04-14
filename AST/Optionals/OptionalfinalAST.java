class OptionalfinalAST implements AST{
    boolean isfinal;

    public OptionalfinalAST(Boolean is){
        this.isfinal = is;
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if (this.isfinal){
            return "final ";
        } else {
            return "";
        }
    }
}
