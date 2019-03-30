
class ProgramAST implements AST {
    IdentAST id;
    String members;

    public ProgramAST(IdentAST id, String mem) {
        this.id = id; 
        this.members = mem;
    }

    public String toString() {
        //Pass indent to the toString methods
        return(""+String.format("class %s {\n%s }",this.id.toString(), this.members)); 
    }

}

