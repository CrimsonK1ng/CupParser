class SymTypeFloat extends SymType{
    public Float value;
    public SymTypeFloat(){
        this.type = "float";
        this.value = 0.0f;
    }

    public SymTypeFloat(Float value){
        this.type = "float";
        this.value = value;
    }

    public Float getValue(){
        return (Float) this.value;
    }

    public void setValue(Object b){
        this.value = (Float) b;
    }

    public String getType(){
        return this.type;
    }
}
