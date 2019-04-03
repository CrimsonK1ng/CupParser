class MemberdeclsAST extends SimpleMethods implements AST{
    FielddeclsAST field_decls;
    MethoddeclsAST method_decls;

    public MemberdeclsAST(FielddeclsAST fields, MethoddeclsAST methods){
        this.field_decls = fields;
        this.method_decls = methods;
    }

    public String toString(int indent){
        return("" + String.format("%s%s", this.field_decls.toString(indent), this.method_decls.toString(indent)));
    }
}
