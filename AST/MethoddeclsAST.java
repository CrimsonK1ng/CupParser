class MethoddeclsAST extends SimpleMethods implements AST{
    MethodAST method;
    MethoddeclsAST other_method;

    public MethoddeclsAST(){
        this.method = null;
        this.other_method = null;
    }

    public MethoddeclsAST (MethodAST method, MethoddeclsAST other){
        this.method = method;
        this.other_method = other;
    }

    public String toString(){
        if(this.method == null || this.other_method == null)
            return "";
        return "" + String.format("%s\n%s", this.method, this.other_method);
    }

    public String toString(int indent){
        if(this.method == null || this.other_method == null)
            return "";

        return getBase(indent) + String.format("%s\n%s", this.method, this.other_method.toString(indent));
    }
}
