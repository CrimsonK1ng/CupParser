class OptionalsemiAST implements AST{
    boolean semi;

    public OptionalsemiAST(boolean isSemi){
        semi = isSemi;
    }

    public String toString(){
        if (semi){
            return ";";
        }
        else {
            return "";
        }
    }
}
