class SymTypeBool extends SymType{
    public Boolean value;
    public SymTypeBool(){
        this.type = "bool";
        this.value = false;
    }

    public SymTypeBool(Boolean value){
        this.type = "bool";
        this.value = value;
    }

    public Boolean getValue(){
        return (Boolean) this.value;
    }

    public void setValue(Object b){
        this.value = (Boolean) b;
    }

    public String getType(){
        return this.type;
    }
}
