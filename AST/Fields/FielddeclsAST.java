class FielddeclsAST extends SimpleMethods implements AST{
    public OptionalfinalAST fin;
    public FieldAST field;
    public FielddeclsAST field_decls;
    public TypeAST type;
    public IdentAST ident;
    public int indent;
    public FielddeclsAST(){}

    public FielddeclsAST( FieldAST field, FielddeclsAST decls){
        this.field = field;
        this.field_decls= decls;
    }

    public FielddeclsAST(OptionalfinalAST fin, TypeAST type, IdentAST id, FieldAST field, FielddeclsAST decls){
        this.fin = fin;
        this.type = type;
        this.ident = id;
        this.field = field;
        this.field_decls= decls;
    }


    public void accept(Visitor v){
        if(this.field != null){
            this.fin.accept(v);
            this.type.accept(v);
            this.ident.accept(v);
            this.field.accept(v);
            v.visit(this);
        }
        if(this.field_decls != null)
            this.field_decls.accept(v);
    }

    public String toString(){
        if(this.field_decls == null){
            return "";
        }
        return(""+ String.format("%s%s %s %s\n%s", this.fin, this.type, this.ident, this.field, this.field_decls));
    }

    public String toString(int indent){
        if(this.field_decls == null){
            return "";
        }
        String field  = "";
        if(this.field != null){
            field = this.field.toString();
        }
        return(""+ String.format("%s", this.field_decls.toString(indent))
                + getBase(indent) + String.format("%s%s %s %s\n", this.fin, this.type, this.ident, field));

    }

    public String getType(Visitor e) throws TypeConflictException{
        FielddeclsAST cur = this;
        while(cur.field_decls != null){
            if(cur.field.getType(e).equals("array")){
                //Special case. We can have an array of any type
                return "";
            }
            else if(!cur.field.getType(e).equals(cur.type.getType(e))){
                throw new TypeConflictException(String.format("Type %s must be same type as expression: %s", cur.type.getType(e), cur.field.getType(e)));
            }

            cur = cur.field_decls;
        }
        return "";
        //return this.type.getType(e);
    }
}
