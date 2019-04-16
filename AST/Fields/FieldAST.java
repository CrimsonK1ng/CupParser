class FieldAST implements AST{
    public FieldAST(){

    }
    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return ("");
    }

    public String getType(Visitor e){
        return "void";
    }
}
