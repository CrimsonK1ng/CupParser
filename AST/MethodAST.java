
class MethodAST extends SimpleMethods implements AST{
    ReturntypeAST ret;
    IdentAST id;
    String args;
    FielddeclsAST field_list;
    IdentAST statements;
    OptionalsemiAST semi;
    public MethodAST(ReturntypeAST ret, IdentAST id, String args, FielddeclsAST fields, IdentAST states, OptionalsemiAST sem){
        this.ret = ret;
        this.id = id;
        this.args = args;
        this.field_list = fields;
        this.statements = states;
        this.semi = sem;
    }

    public MethodAST(ReturntypeAST ret, IdentAST id, OptionalsemiAST sem){
        this.ret = ret;
        this.id = id;
        this.args = null;
        this.field_list = null;
        this.statements = null;
        this.semi = sem;
    }

    public String toString(){
        return "" + String.format("%s %s ( %s ) {\n %s %s \n} %s", this.ret, this.id, this.args, this.field_list, this.statements, this.semi);
    }
}
