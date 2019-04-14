class SymTypeVoid extends SymType{
    public String type;
    public SymTypeVoid(){
        this.type = "void";
    }

    public Object getValue(){
        return null;
    }

    public String getType(){
        return this.type;
    }
}
