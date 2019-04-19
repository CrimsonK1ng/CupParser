class MethoddeclsAST extends SimpleMethods implements AST{
    ReturntypeAST returns;
    IdentAST ident;
    MethodAST method;
    MethoddeclsAST other_method;
    public MethoddeclsAST(){}

    public MethoddeclsAST (ReturntypeAST ret, IdentAST id, MethodAST method, MethoddeclsAST other){
        this.returns = ret;
        this.ident = id;
        this.method = method;
        this.other_method = other;
    }


    public void accept(Visitor v){
        if(this.method != null){
            v.visit(this);
            this.returns.accept(v);
            this.ident.accept(v);
            this.method.accept(v);
            v.exit();
        if(this.other_method.other_method != null)
            this.other_method.accept(v);
        }
    }

    public String toString(){
        if(this.method == null || this.other_method == null)
            return "";
        return(""+ String.format("%s %s %s\n%s", this.returns, this.ident, this.method, this.other_method));

    }

    public String toString(int indent){
        if(this.other_method == null)
            return "";
        String othermethod = "";
        if (this.other_method != null)
            othermethod = this.other_method.toString(indent);
        return(getBase(indent) + String.format("%s %s %s\n%s", this.returns, this.ident, this.method.toString(indent), othermethod));
    }

    public String getType(Visitor e) throws TypeConflictException{
        String returnType = this.returns.getType(e);
        String methodType = this.method.getType(e);
        if(returnType.equals("float") && methodType.equals("int")){
            return "float";
        }
        else if(returnType.equals("bool") && methodType.equals("int")){
            return "bool";
        }
        else if(!returnType.equals(methodType)){
            throw new TypeConflictException(String.format("%s not compatable with %s", returnType, methodType));
        }
        else
            return returnType;
    }
}
