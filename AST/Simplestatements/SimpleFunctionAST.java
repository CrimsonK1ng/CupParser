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
        SymTableFunctionEntry entry = (SymTableFunctionEntry) v.lookup(this.id.name + "_");
        System.out.println("VOID");
        if(entry != null){
            entry.decl.getValue(v); //TODO make sure void stuff runs
        }
        return null; //This should throw an exception. NULL IS HERE IN CASE
    }
}
