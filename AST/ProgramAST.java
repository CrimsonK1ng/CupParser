
class ProgramAST implements AST {
    IdentAST id;
    MemberdeclsAST members;

    public ProgramAST(IdentAST id, MemberdeclsAST mem) {
        this.id = id;
        this.members = mem;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.id.accept(v);
        this.members.accept(v);
    }

    public String toString() {
        //Pass indent to the toString methods
        return(""+String.format("class %s {\n%s}",this.id.toString(), this.members.toString(1)));
    }

}
