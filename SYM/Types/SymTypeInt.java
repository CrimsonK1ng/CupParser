class SymTypeInt extends SymType{
    public String type;
    public Integer value;

    public SymTypeInt(){
        this.type = "int";
    }

    public SymTypeInt(Integer value){
        this.value = value;
        this.type = "int";
    }

    public Integer getValue(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }
}
