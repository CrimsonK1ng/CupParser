
class MethodAST extends SimpleMethods implements AST{
    String ret;
    IdentAST id;
    IdentAST args;
    FielddeclsAST field_list;
    IdentAST statements;
    String semi;
    public MethodAST(String ret, IdentAST id, IdentAST args, FielddeclsAST fields, IdentAST states, String sem){
        this.ret = ret;
        this.id = id;
        this.args = args;
        this.field_list = fields;
        this.statements = states;
        this.semi = sem;
    }

    public String toString(){
        return "" + String.format("%s %s ( %s ) {\n %s %s \n} %s", this.ret, this.id, this.args, this.field_list, this.statements, this.semi);
    }
}
