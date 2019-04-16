class SimpleFunctionArgsAST extends SimplestateAST implements AST{
    public IdentAST id;
    public ParameterArgsAST args;

    public SimpleFunctionArgsAST(IdentAST id, ParameterArgsAST args){
        this.id = id;
        this.args = args;
    }


    public void accept(Visitor v){
        this.id.accept(v);
        this.args.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s ( %s );", this.id, this.args));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s ( %s );", this.id, this.args));
    }
    public String getType(Visitor e){
        return "";
    }
}
