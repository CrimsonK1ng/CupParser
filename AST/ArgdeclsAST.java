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

    public void accept(Visitor v){
        if(this.arglist != null){
            v.visit(this);
            this.arg.accept(v);
            this.comma.accept(v);
            this.arglist.accept(v);
        }
    }

    public String toString(){
        if(this.arglist == null){
            return "";
        }
        String arglist = "";
        if(this.arglist != null){
            arglist = this.arglist.toString();
        }
        if(this.comma.iscomma){
            return(""+ String.format("%s, %s", this.arg,  this.arglist));
        }
        return(""+ String.format("%s %s", this.arg, arglist));


    }
}
