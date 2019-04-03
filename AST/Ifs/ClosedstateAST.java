/*
This class exists to handle the one case where closed returns a simple
*/
class ClosedstateAST extends StatementAST implements AST{
    SimplestateAST simple;

    public ClosedstateAST(){}

    public ClosedstateAST(SimplestateAST simple){
        this.simple = simple;
    }

    public String toString(int indent){
        return( String.format("%s", this.simple.toString(indent)));
    }
}
