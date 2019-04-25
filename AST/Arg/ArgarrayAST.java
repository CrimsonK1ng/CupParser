
class ArgarrayAST extends ArgAST implements AST{
    public ArgarrayAST(TypeAST type,IdentAST id){
        super(type, id);
    }

    public void accept(Visitor v){
        this.type.accept(v);
        this.id.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s %s[]", this.type, this.id));
    }

    public String getType(Visitor e){
        return this.type.type;
    }
    public Object getValue(Visitor v){
        return null;
    }
}
