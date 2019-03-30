class TypeAST implements AST{
    String type;

    public TypeAST (String type){
        this.type = type;
    }


    public String toString(){
        return "" + String.format("%s", this.type);
    }
}
