class ArgAST implements AST{
    TypeAST type;
    IdentAST id;

    public ArgAST(){}

    public ArgAST(TypeAST type,IdentAST id){
        this.type = type;
        this.id = id;
    }
    public String toString(){
        return("" + String.format("%s %s", this.type, this.id));
    }
}
