/*
    This is annoyingly different but server to be args for function declerations and such
*/

class ParameterArgsAST implements AST{
    ParameterArgsAST next_arg;
    ExprAST expr;

    public ParameterArgsAST(ExprAST expr){
        this.expr = expr;
        this.next_arg = null;
    }

    public ParameterArgsAST(ExprAST expr, ParameterArgsAST args){
        this.expr = expr;
        this.next_arg = args;
    }

    public void accept(Visitor v){
        if(this.next_arg != null)
            this.next_arg.accept(v);
        this.expr.accept(v);
        v.visit(this);
    }


    public String toString(){
        if(this.next_arg != null){
            return("" + String.format("%s, %s", this.expr, this.next_arg));
        }
        return("" + String.format("%s", this.expr));
    }
}
