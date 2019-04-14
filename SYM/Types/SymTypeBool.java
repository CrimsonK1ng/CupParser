class SymTypeBool extends SymType{
    public String type;
    public Boolean value;

    public SymTypeBool(){
        this.type = "bool";
    }

    public SymTypeBool(Boolean value){
        this.type = "bool";
        this.value = value;
    }

    public Boolean getValue(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }
}
