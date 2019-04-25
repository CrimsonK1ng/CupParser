class SimplePrintlineAST extends SimplePrintlistAST{
    public SimplePrintlineAST(){
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("PRINTLINE"));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("printline ( );"));
    }
    public String getType(Visitor e){
        return "";
    }
    public Object getValue(Visitor v){ return null;

    }
}
