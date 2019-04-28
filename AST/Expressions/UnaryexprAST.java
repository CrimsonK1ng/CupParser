class UnaryexprAST extends ExprAST implements AST{
    String operator;

    public UnaryexprAST(String op, ExprAST expr){
        super(expr);
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
            throw new TypeConflictException(String.format("Unary op: %s cannot be applied to %s", this.operator, this.expr.getType(e)));
    }
    public Object getValue(Visitor v) {
        switch(this.operator){
            case "~":
                return !(Boolean)this.expr.getValue(v);
            case "+":
                if(this.expr.getType(v).equals("float"))
                    return (Float) this.expr.getValue(v);
                else if(this.expr.getType(v).equals("int"))
                    return (Integer) this.expr.getValue(v);
            case "-":
                if(this.expr.getType(v).equals("float"))
                    return (Float) this.expr.getValue(v) * -1;
                else if(this.expr.getType(v).equals("int"))
                    return (Integer) this.expr.getValue(v) * -1;
            default:
                return null;
        }
    }

}
