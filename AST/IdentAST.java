/**
 * AST node for an identifier
 */ 
class IdentAST implements AST {
  String name;                

  public IdentAST(String s) {
    name = s; 
  }

  public String toString() {
    return name; 
  }

}


