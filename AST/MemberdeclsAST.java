class MemberdeclsAST implements AST{
    String field_decls;
    String method_decls;
    public MemberdeclsAST(String fields, String methods){
        this.field_decls = fields;
        this.method_decls = methods;
    }

    public String toString(){
        return("" + String.format("%s %s", this.field_decls, this.method_decls));

    }
}
