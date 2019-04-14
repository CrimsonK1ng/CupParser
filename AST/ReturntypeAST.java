
class ReturntypeAST implements AST {
    TypeAST type;
    boolean isVoid;

    public ReturntypeAST(TypeAST t) {
        this.type = t;
    }

    public ReturntypeAST(boolean isVoid) {
        this.isVoid = isVoid;
    }


    public void accept(Visitor v){
        if(this.type != null)
            this.type.accept(v);
        v.visit(this);
    }

    public String toString() {
        if (this.isVoid){
            return "void";
        }else{
            return this.type.toString();
        }
    }

}
