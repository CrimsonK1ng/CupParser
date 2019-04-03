class ReturnsimpleAST extends SimplestateAST implements AST{
    public ReturnsimpleAST(){

    }

    public String toString(){
        return "return;";
    }
    public String toString(int indent){
        return(getBase(indent) + "return;");
    }
}
