class SimpleFunctionAST extends SimplestateAST implements AST{
    IdentAST id;

    public SimpleFunctionAST(IdentAST id){
        this.id = id;
    }

    public String toString(){
        return("" + String.format("%s ( );", this.id));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s ( );", this.id));
    }
}
