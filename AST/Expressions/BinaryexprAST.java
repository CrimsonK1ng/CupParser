class BinaryexprAST extends ExprAST implements AST{
    public BinaryOp binop;
    public ExprAST left;
    public ExprAST right;

    public BinaryexprAST(ExprAST left, BinaryOp b, ExprAST right){
        this.binop = b;
        this.left = left;
        this.right = right;
    }

    public void accept(Visitor v){
        this.binop.accept(v);
        this.left.accept(v);
        this.right.accept(v);
        v.visit(this);
    }


    public String toString(){
        return(""+ String.format("%s %s %s", left, binop, right));
    }

    private Boolean doesNotContain(String e, String... args){
        for(String s : args){
            if(e.equals(s))
                return false;
        }
        return true;
    }
    /*
    intlit, charlit, strlit, floatlit, true, false are of type int, char, string, float, bool and bool respectively
    - and + as unary expressions can only be applied to int or float and produce the same resulting type
    ~ is a boolean operator which may be applied to bool and int values, producing a bool value
    *, /, - may be applied to int and int, one int and one float, float and float and produce an int, float and float values
    + may be applied as - but also represents a concatenation when applied to strings
    the comparison operations, <, >, <=, >=, ==, <> may be applied to any pair of values of the same type and produce a bool, they may also be applied to one int and float argument and one bool and int argument
    the logical or (||) and logical and (&&) may only be applied to bool arguments and produce a bool value
    the first expr in a ? operation must be a bool or int value and both of the remaining arguments must have the same type (or one can be an int and one a float)
    */
    public String getType(Visitor e) throws TypeConflictException {
        if(this.left.getType(e).equals(this.right.getType(e))){
            if(this.left.getType(e).equals("string")){
                if(!doesNotContain(this.binop.op, "*", "-", "/","||","&&"))
                    throw new TypeConflictException(String.format("String cannot be applied to %s", this.binop.op));
            }
            else if(this.left.getType(e).equals("char")){
                if(!doesNotContain(this.binop.op, "*","-","/","+","||","&&"))
                    throw new TypeConflictException(String.format("Char cannot be applied to %s", this.binop.op));
            }
            else if(this.left.getType(e).equals("float")){
                if(!doesNotContain(this.binop.op, "||","&&"))
                    throw new TypeConflictException(String.format("Float cannot be applied to %s", this.binop.op));
            }
            else if(this.left.getType(e).equals("int")){
                if(!doesNotContain(this.binop.op, "||","&&"))
                    throw new TypeConflictException(String.format("Int cannot be applied to %s", this.binop.op));
            }
            return "";
        }else if((this.left.getType(e).equals("int") || this.left.getType(e).equals("float") )&& (this.right.getType(e).equals("float") || this.right.getType(e).equals("int"))){
            if(!doesNotContain(this.binop.op, "||", "&&"))
                throw new TypeConflictException(String.format("Int and Float cannot be applied to %s", this.binop.op));
            return "";
        }
        else if((this.left.getType(e).equals("int") || this.left.getType(e).equals("bool") )&& (this.right.getType(e).equals("int") || this.right.getType(e).equals("bool"))){
            if(!doesNotContain(this.binop.op, "||", "&&"))
                throw new TypeConflictException(String.format("Int and Bool cannot be applied to %s", this.binop.op));
            return "";
        }
        else if(this.binop.op.equals("||")){
            throw new TypeConflictException(String.format("%s cannot be OR'ed with %s", this.left.getType(e), this.right.getType(e)));
        }
        else if(this.binop.op.equals("&&")){
            throw new TypeConflictException(String.format("%s cannot be AND'ed with %s", this.left.getType(e), this.right.getType(e)));
        }
        else
            throw new TypeConflictException(String.format("Shit Fucked %s cannot be AND'ed with %s", this.left.getType(e), this.right.getType(e)));
    }
}
