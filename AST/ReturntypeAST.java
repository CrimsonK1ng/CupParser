
class ReturntypeAST implements AST {
    TypeAST type;
    boolean isvoid;

    public ReturntypeAST(TypeAST t) {
        this.type = t;
        this.isvoid = false;
    }

    public ReturntypeAST(boolean isvoid) {
        this.isvoid = isvoid;
        this.type = null;
    }


    public void accept(Visitor v){
        if(this.type != null)
            this.type.accept(v);
        v.visit(this);
    }

    public String toString() {
        if (this.isvoid){
            return "void";
        }else{
            return this.type.toString();
        }
    }

    public String getType(Visitor e){
        if(this.isvoid)
            return "void";
        else
            return type.getType(e);
    }

    public Object getValue(Visitor v){
        return null;
    }
}
