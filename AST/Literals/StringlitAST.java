/**
 * AST node for a number
 */
class StringlitAST  extends ExpressionLiterals implements AST {
    String s;

    public StringlitAST(String s) {
        super("string");
        this.s = s;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString() {
        return (""+String.format("%s", this.s));
    }
    public String getType(Visitor v){
        return "string";
    }

}
