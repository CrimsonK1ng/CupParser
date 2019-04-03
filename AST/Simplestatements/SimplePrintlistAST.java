class SimplePrintlistAST extends SimplestateAST implements AST{
    PrintlistAST plist;
    public SimplePrintlistAST(){}

    public SimplePrintlistAST(PrintlistAST plist){
        this.plist = plist;
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("print ( %s );", this.plist));
    }
}
