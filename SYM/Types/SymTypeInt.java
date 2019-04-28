class SymTypeInt extends SymType{
    public Integer value;
    public SymTypeInt(){
        this.type = "int";
        this.value = 0;
    }

    public SymTypeInt(Integer value){
        this.value = value;
        this.type = "int";
    }

    public Integer getValue(){
        return (Integer) this.value;
    }

    public void setValue(Object b){
        this.value = (Integer) b;
    }

    public String getType(){
        return this.type;
    }
}
