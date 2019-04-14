class SymTypeFloat extends SymType{
    public String type;
    public Float value;
    public SymTypeFloat(){
        this.type = "float";
    }

    public SymTypeFloat(Float value){
        this.type = "float";
        this.value = value;
    }

    public Float getValue(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }
}
