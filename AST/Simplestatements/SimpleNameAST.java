class SimpleNameAST extends SimplestateAST implements AST{
    NameAST name;
    boolean plusplus;
    public SimpleNameAST(NameAST n, boolean b){
        this.name = n;
        this.plusplus = b;
    }

    public String toString(){
        if(this.plusplus){
            return("" + String.format("%s ++;", this.name));
        }
        return("" + String.format("%s --;", this.name));
    }

    public String toString(int indent){
        if(this.plusplus){
            return(getBase(indent) + String.format("%s ++;", this.name));
        }
        return(getBase(indent)+ String.format("%s --;", this.name));
    }
}
