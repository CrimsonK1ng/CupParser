class NameAST extends ExpressionLiterals implements AST{
    IdentAST id;
    public NameAST(){}

    public NameAST(IdentAST id){
        this.id = id;
    }

    public NameAST(IdentAST id, ExprAST expr){
        this.id = id;
    }


    public void accept(Visitor v){
        this.id.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s",this.id));
    }

    public String getType(Visitor e){
        return this.id.getType(e);
    }
    public Object getValue(Visitor v){ return null;

    }
}
