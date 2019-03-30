class ExprAST implements AST {
    String expr[];

    public ExprAST(String s1) {
        expr = new String[1];
        expr[0] = s1;
    }

    public ExprAST(String s1, String s2) {
        expr = new String[2];
        expr[0] = s1;
        expr[1] = s2;
    }

    public ExprAST(String s1, String s2, String s3) {
        expr = new String[3];
        expr[0] = s1;
        expr[1] = s2;
        expr[2] = s3;
    }
    
    public String toString() {

        String expr_string = "";
        for(int i=0; i < expr.length; i++){
            expr_string += "" + String.format("%s", expr[i]);
        }
        return(""+String.format("%s", expr_string)); 
    }

}
