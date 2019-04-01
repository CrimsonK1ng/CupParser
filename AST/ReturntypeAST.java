
class ReturntypeAST implements AST {
    TypeAST type;
    boolean isVoid;

    public ReturntypeAST(TypeAST t) {
        this.type = t;
    }

    public ReturntypeAST(boolean isVoid) {
        this.isVoid = isVoid;
    }

    public String toString() {
        if (this.isVoid){
            return "void";
        }else{
            return this.type.toString();
        }
    }

}
