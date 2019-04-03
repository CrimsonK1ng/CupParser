/**
 * AST node for a number
 */
class IntlitAST  extends ExpressionLiterals implements AST {
    Integer number;

    public IntlitAST(String s) {
        try{
            number = Integer.valueOf(s);
        } catch (NumberFormatException e) { number=null; }
    }

    public String toString() {
        return(this.number.toString());
    }

}
