/**
 * AST node for an identifier
 */
class IdentAST  extends ExpressionLiterals implements AST {
  String name;

  public IdentAST(String s) {
    name = s;
  }


    public void accept(Visitor v){
        v.visit(this);
    }

  public String toString() {
    return name;
  }

}
