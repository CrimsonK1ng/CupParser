class FielddeclsAST extends SimpleMethods implements AST{
    FieldAST field;
    FielddeclsAST field_decls;

    public FielddeclsAST(){
        this.field = null;
        this.field_decls= null;
    }

    public FielddeclsAST(FieldAST field, FielddeclsAST decls){
        this.field = field;
        this.field_decls= decls;
    }

    public String toString(){
        return("" + String.format("%s\n%s", this.field, this.field_decls));

    }

    public String toString(int indent){
        if (this.field == null && this.field_decls == null)
            return "";

        return(getBase(indent) + String.format("%s\n%s", this.field, this.field_decls.toString(indent)));

    }
}
