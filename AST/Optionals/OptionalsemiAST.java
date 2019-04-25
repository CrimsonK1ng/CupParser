class OptionalsemiAST implements AST{
    boolean semi;

    public OptionalsemiAST(boolean isSemi){
        semi = isSemi;
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        if (semi){
            return ";";
        }
        else {
            return "";
        }
    }

    public String getType(Visitor e){
        return "";
    }

    public Object getValue(Visitor v){ return null;

    }
}
