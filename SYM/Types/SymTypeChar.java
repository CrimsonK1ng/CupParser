class SymTypeChar extends SymType{
    public String type;
    public Character value;

    public SymTypeChar(){
        this.type = "char";
    }

    public SymTypeChar(Character value){
        this.type = "char";
        this.value = value;
    }

    public Character getValue(){
        return this.value;
    }

    public String getType(){
        return this.type;
    }
}
