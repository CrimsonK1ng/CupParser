class SimpleFunctionAST extends SimplestateAST implements AST{
    public IdentAST id;

    public SimpleFunctionAST(IdentAST id){
        this.id = id;
    }


    public void accept(Visitor v){
        this.id.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s ( );", this.id));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s ( );", this.id));
    }
    public String getType(Visitor e) {
        SymTableEntry entry = e.lookup(this.id.name + "_");
        if(entry != null){
            return "";//entry.type.getType();
        }
        return null; //This should throw an exception. NULL IS HERE IN CASE
    }
    public Object getValue(Visitor v){
        //TODO not gonna deal with this
        return null;
    }
}
