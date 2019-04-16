/**
 * AST node for an identifier
 */
class IdentAST  extends ExpressionLiterals implements AST {
    String name;
    String type;
    Boolean isArray;

    public IdentAST(){
        type = null;
        isArray = false;
    }
    public IdentAST(String s) {
        name = s;
        type = null;
        isArray = false;
    }

    public String getType(Visitor e){
        SymTableEntry entry = e.lookup(name);
        this.type = entry.type.getType();
        this.isArray = entry.isArray;
        System.out.println(entry.isArray);
        if(this.isArray){
            return "Array";
        }
        return type;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

  public String toString() {
    return name;
  }

}
