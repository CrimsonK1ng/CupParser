class ArgdeclsAST implements AST{
    ArgdeclsAST arglist;
    ArgAST  arg;
    OptionalcommaAST comma;

    public ArgdeclsAST(){}

    public ArgdeclsAST(ArgAST a, ArgdeclsAST args){
        this.arg = a;
        this.arglist = args;
    }

    public ArgdeclsAST(ArgAST a, ArgdeclsAST args, OptionalcommaAST comma){
        this.arg = a;
        this.arglist = args;
        this.comma = comma;
    }
    public String toString(){
        if(this.arglist == null){
            return "";
        }
        if(this.comma.iscomma){
            return(""+ String.format("%s, %s", this.arg,  this.arglist));
        }
        return(""+ String.format("%s %s", this.arg, this.arglist));


    }
}
