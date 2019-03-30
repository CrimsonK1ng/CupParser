/**
 * AST node for a number
 */ 
class BinaryOp implements AST {
    String op;

    public BinaryOp(String s) {
        this.op = s;
    }

    public String toString(int indent) {
        return(""+String.format("%s",this.op)); 
    }
    
    public String toString() {
        return(""+String.format("%s",this.op)); 
    }

}

