class SymTypeBool extends SymType{

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

    public String getType(){
        return this.type;
    }
}
