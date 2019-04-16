/**
 * AST node for a number
 */
class FloatlitAST  extends ExpressionLiterals implements AST {
  Float number;

  public FloatlitAST(String s) {
    super("float");
    try {
        number = Float.parseFloat(s);
    }
    catch (NumberFormatException e) { number = Float.NaN; };
  }
    public void accept(Visitor v){
        v.visit(this);
    }

  public String toString() {
    return (""+String.format("%.2f",number));
  }

  public String getType(Visitor v){
      return "float";
  }
}
