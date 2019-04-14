/**
 * AST node for a number
 */
class CharlitAST extends ExpressionLiterals implements AST {
    char ch;

    public CharlitAST(String ch) {
        if (ch.length() == 1){
            this.ch = ch.charAt(0);
        }
    }


    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString() {
        return(""+String.format("%s", this.ch));
    }

}
