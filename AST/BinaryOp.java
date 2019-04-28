/**
 * AST node for a number
 */
class BinaryOp implements AST {
    String op;

    public BinaryOp(String s) {
        this.op = s;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(int indent) {
        return (""+String.format("%s",this.op));
    }

    public String toString() {
        return (""+String.format("%s",this.op));
    }

    public String getType(Visitor e) {
        return "";
    }
    public Object getValue(Visitor v) {
        return null;
    }

}
