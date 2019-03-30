/**
 * AST node for a number
 */ 
class IntlitAST implements AST {
  Integer number;

  public IntlitAST(String s) {
    try { number = Integer.parseInt(s); }
    catch (NumberFormatException e) { number = null; };
  }

  public String toString() {
    return(this.number.toString()); 
  }

}

