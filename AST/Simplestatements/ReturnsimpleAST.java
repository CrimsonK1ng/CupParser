class ReturnsimpleAST extends SimplestateAST implements AST{
    public ReturnsimpleAST(){

    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "return;";
    }
    public String toString(int indent){
        return(getBase(indent) + "return;");
    }

    @Override
    public String getType(Visitor e){
        return "void";
    }
    public Object getValue(Visitor v){ return null;

    }
}
