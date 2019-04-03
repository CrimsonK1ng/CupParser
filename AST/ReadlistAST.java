class ReadlistAST implements AST{
    NameAST name;
    ReadlistAST read;

    public ReadlistAST(NameAST name){
        this.name = name;
        this.read = null;
    }

    public ReadlistAST(NameAST name, ReadlistAST read){
        this.name = name;
        this.read = read;
    }

    public String toString(){
        if (this.read != null){
            return("" + String.format("%s, %s", this.name, this.read));
        }
        return("" + String.format("%s", this.name));
    }
}
