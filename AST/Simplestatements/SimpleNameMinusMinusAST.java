class SimpleNameMinusMinusAST extends SimplestateAST implements AST{
    public NameAST name;
    public SimpleNameMinusMinusAST(NameAST n){
        this.name = n;
    }


    public void accept(Visitor v){
        this.name.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s --;", this.name));
    }

    public String toString(int indent){
        return(getBase(indent)+ String.format("%s --;", this.name));
    }
    public String getType(Visitor e){
        if(this.name.getType(e).equals("float") || this.name.getType(e).equals("int")){
            //return this.name.getType(e);
            return "";
        }
        throw new TypeConflictException(String.format(
            "Cannot -- type %s", this.name.getType(e)
        ));
    }
    public Object getValue(Visitor v){ return null;

    }
}
