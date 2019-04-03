class OptionalcommaAST implements AST{
    boolean iscomma;

    public OptionalcommaAST(boolean t){
        this.iscomma = t;
    }

    public String toString(){
        if(this.iscomma){
            return "";
        }
        return ",";
    }
}
