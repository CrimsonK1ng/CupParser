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


    public void accept(Visitor v){
        this.name.accept(v);
        if(this.read != null)
            this.read.accept(v);
        v.visit(this);
    }

    public String toString(){
        if (this.read != null){
            return(""+ String.format("%s, %s", this.name, this.read));
        }
        return(""+ String.format("%s", this.name));
    }

    public String getType(Visitor e) throws TypeConflictException{
        ReadlistAST cur = this;
        while(cur != null){
            if(cur.name.getType(e).equals("array")){
                throw new TypeConflictException(String.format(
                    "Cannot read array"
                ));
            }
            cur = cur.read;
        }
        return "";
    }
    public Object getValue(Visitor v){ return null;

    }
}
