class FieldArrayAST extends FieldAST implements AST{
    IntlitAST num;

    public FieldArrayAST(IntlitAST n){
        this.num = n;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){

        return ("" + String.format("[%s];", this.num));

    }

    public String getType(Visitor e){
        return "array";
    }
    public Object getValue(Visitor v){ return null;

    }
}
