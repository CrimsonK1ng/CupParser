class SymTypeFloat extends SymType{
    public SymTypeFloat(){
        this.type = "float";
        this.value = 0;
    }

    public SymTypeFloat(Float value){
        this.type = "float";
        this.value = value;
    }

    public Float getValue(){
        return (Float) this.value;
    }

    public String getType(){
        return this.type;
    }
}
