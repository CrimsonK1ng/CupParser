/**
 * AST node for a number
 */
class IntlitAST  extends ExpressionLiterals implements AST {
    Integer number;

    public IntlitAST(String s) {
        super("int");
        try{
            number = Integer.valueOf(s);
        } catch (NumberFormatException e) { number=null; }
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString() {
        return(this.number.toString());
    }
      public String getType(Visitor v){
          return "int";
      }
}
