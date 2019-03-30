/**
 * AST node for a number
 */ 
class FloatlitAST implements AST {
  Float number;

  public FloatlitAST(String s) {
    try { number = Float.parseFloat(s); }
    catch (NumberFormatException e) { number = Float.NaN; };
  }

  public String toString() {
    return(""+String.format("%.2f",number)); 
  }

}

