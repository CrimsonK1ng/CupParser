class OptionalfinalAST implements AST{
    boolean isfinal;

    public OptionalfinalAST(boolean is){
        this.isfinal = is;
    }

    public String toString(){
        if (this.isfinal){
            return "final ";
        } else {
            return "";
        }
    }
}
