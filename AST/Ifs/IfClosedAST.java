class IfClosedAST extends ClosedstateAST implements AST{
    ClosedstateAST close1, close2;
    ExprAST expr;

    public IfClosedAST(SimplestateAST simple){

    }

    public IfClosedAST(ExprAST expr, ClosedstateAST c1, ClosedstateAST c2){
        this.close1 = c1;
        this.close2 = c2;
        this.expr = expr;
    }

    public String toString(){
        return("" + String.format("if ( %s )\n%s\nELSE\n%s", this.expr, this.close1, this.close2));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("if ( %s )\n", this.expr)
                  + String.format("%s\n", this.close1.toString(indent+1))
                  + getBase(indent) + "else\n"
                  + String.format("%s", this.close2.toString(indent+1)));
    }
}
