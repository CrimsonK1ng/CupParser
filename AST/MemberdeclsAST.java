class MemberdeclsAST extends SimpleMethods implements AST{
    FielddeclsAST field_decls;
    MethoddeclsAST method_decls;
    public MemberdeclsAST(FielddeclsAST fields, MethoddeclsAST methods){
        this.field_decls = fields;
        this.method_decls = methods;
    }

    public String toString(){
        return("" + String.format("%s\n%s", this.field_decls.toString(1), this.method_decls));

    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s\n%s", this.field_decls.toString(1), this.method_decls));

    }
}
