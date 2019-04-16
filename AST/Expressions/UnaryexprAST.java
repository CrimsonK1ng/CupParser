class UnaryexprAST extends ExprAST implements AST{
    String operator;

    public UnaryexprAST(String op, ExprAST expr){
        super(expr, expr.type);
        this.operator = op;
    }


    public void accept(Visitor v){
        this.expr.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s%s", operator, expr));
    }

    public String getType(Visitor e) throws TypeConflictException{
        if(this.operator.equals("~") && (this.expr.getType(e).equals("bool") || this.expr.getType(e).equals("int")))
            return this.expr.getType(e);
        else if(this.operator.equals("-") && (this.expr.getType(e).equals("float") || this.expr.getType(e).equals("int")))
            return this.expr.getType(e);
        else if(this.operator.equals("+") && (this.expr.getType(e).equals("float") || this.expr.getType(e).equals("int")))
            return this.expr.getType(e);
        else
            throw new TypeConflictException(String.format("%s cannot be applied to op %s", this.expr.getType(e), this.operator));
    }

}
