class SimpleReadlistAST extends SimplestateAST implements AST{
    ReadlistAST rlist;

    public SimpleReadlistAST(ReadlistAST r){
        this.rlist = r;
    }

    public void accept(Visitor v){
        this.rlist.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("read ( %s );", this.rlist));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("read ( %s );", this.rlist));
    }
    public String getType(Visitor e){
        return this.rlist.getType(e);
    }
}
