/**
 * AST node for a number
 */
class CharlitAST extends ExpressionLiterals implements AST {
    public Character ch;

    public CharlitAST(String ch) {
        super("char");
        this.ch = ch.charAt(1);
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString() {
        return (""+String.format("\'%c\'", this.ch));
    }

    public String getType(Visitor v){
        return "char";
    }
    public Object getValue(Visitor v) {
        return this.ch;
    }
}
