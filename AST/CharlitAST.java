/**
 * AST node for a number
 */ 
class CharlitAST implements AST {
    char ch;

    public CharlitAST(String ch) {
        if (ch.length() == 1){
            this.ch = ch.charAt(0);
        }
    }

    public String toString() {
        return(""+String.format("%s", this.ch)); 
    }

}

