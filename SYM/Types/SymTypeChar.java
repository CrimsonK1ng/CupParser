class SymTypeChar extends SymType{

    public Character value;
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

    public void setValue(Object b){
        this.value = (Character) b;
    }

    public String getType(){
        return this.type;
    }
}
