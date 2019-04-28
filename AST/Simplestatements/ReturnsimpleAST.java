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
        return "";
    }
    public Object getValue(Visitor v){
        throw new ReturnException(); //Yay abuse of powers
    }
}
