class SimplestateAST extends ClosedstateAST implements AST{

    public SimplestateAST(){

    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "SIMPLE";
    }

    @Override
    public String getType(Visitor v){
        System.out.println("SIMPLE");
        return "";
    }
}
