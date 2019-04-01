class FieldAST implements AST{
    OptionalfinalAST _final;
    TypeAST type;
    IdentAST id;
    IntlitAST intlit;
    OptionalexprAST expr;
    String tostring;

    public FieldAST(OptionalfinalAST fin, TypeAST type, IdentAST id, OptionalexprAST exp){
        this._final = fin;
        if (this._final == null){
            this._final= new OptionalfinalAST(false);
        }
        this.type = type;
        this.id = id;
        this.expr = exp;

        this.tostring = "" + String.format("%s %s %s %s;", this._final, this.type, this.id, this.expr);
    }

    public FieldAST(TypeAST type, IdentAST id, IntlitAST intlit){
        this.type = type;
        this.id = id;
        this.intlit = intlit;

        System.out.println(intlit);
        this.tostring = "" + String.format("%s %s [%s];", this.type, this.id, this.intlit.toString());
    }

    public String toString(){
        return("" + this.tostring);

    }
}
