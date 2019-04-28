class TypeAST implements AST{
    String type;

    public TypeAST (String type){
        this.type = type;
    }



    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return String.format("%s", this.type);
    }

    public String getType(Visitor e){
        return type;
    }

    public Object getValue(Visitor v){
        return null;
    }
}
