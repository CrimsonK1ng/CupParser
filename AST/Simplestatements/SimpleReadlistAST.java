class SimpleReadlistAST extends SimplestateAST implements AST{
    ReadlistAST rlist;

    public SimpleReadlistAST(ReadlistAST r){
        this.rlist = r;
    }

    public String toString(){
        return("" + String.format("read ( %s );", this.rlist));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("read ( %s );", this.rlist));
    }
}
