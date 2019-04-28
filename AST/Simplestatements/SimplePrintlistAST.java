class SimplePrintlistAST extends SimplestateAST implements AST{
    PrintlistAST plist;
    public SimplePrintlistAST(){}

    public SimplePrintlistAST(PrintlistAST plist){
        this.plist = plist;
    }


    public void accept(Visitor v){
        if(this.plist != null)
            this.plist.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("print ( %s );", this.plist));
    }
    public String getType(Visitor e){
        return this.plist.getType(e);
    }
    public Object getValue(Visitor v){
        this.plist.getValue(v);
        System.out.println("Printlist");
        return null;
    }
}
