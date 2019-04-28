/**
 * AST node for an identifier
 */
class IdentAST  extends ExpressionLiterals implements AST {
    public String name;
    public String type;
    public Boolean isFinal;
    public Boolean isArray;

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
        if(this.type == null){
            SymTableEntry ent = e.lookup(this.name);
            this.type = ent.type.getType();
            this.isArray = ent.isArray;
            this.isFinal = ent.ifFinal;
        }
        if(this.isArray){
            return "array";
        }
        return type;
    }

    public String getType(Visitor e, boolean withInt){
        if(this.type == null){
            SymTableEntry ent = e.lookup(this.name);
            this.type = ent.type.getType();
            this.isArray = ent.isArray;
            this.isFinal = ent.ifFinal;
        }
        return type;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString() {
        return name;
    }

    public Object getValue(Visitor v) {
        SymTableEntry ent = v.lookup(this.name);
        return ent.type.getValue();
    }

}
