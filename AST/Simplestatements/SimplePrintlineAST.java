class SimplePrintlineAST extends SimplePrintlistAST{
    public SimplePrintlineAST(){
    }

    public String toString(){
        return("" + String.format("PRINTLINE"));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("printline ( );"));
    }
}
