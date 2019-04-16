class ArgAST implements AST{
    TypeAST type;
    IdentAST id;

    public ArgAST(){}

    public ArgAST(TypeAST type,IdentAST id){
        this.type = type;
        this.id = id;
    }

    public void accept(Visitor v){
        this.type.accept(v);
        this.id.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s %s", this.type, this.id));
    }

    public String getType(Visitor e){
        return this.type.type;
    }

    public String getType(){
        return this.type.type;
    }
}
