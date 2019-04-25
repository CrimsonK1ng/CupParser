class SymTypeChar extends SymType{

    public SymTypeChar(){
        this.type = "char";
        this.value = '0';
    }

    public SymTypeChar(Character value){
        this.type = "char";
        this.value = value;
    }

    public Character getValue(){
        return (Character) this.value;
    }

    public String getType(){
        return this.type;
    }
}
