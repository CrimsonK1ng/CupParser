
class FunctionexprAST extends ExprAST implements AST{
    IdentAST id;
    ParameterArgsAST args; //need to make Args

    public FunctionexprAST(IdentAST id){
        this.id= id;
    }

    public FunctionexprAST(IdentAST id, ParameterArgsAST args){
        this.id= id;
        this.args= args;

    }


    public void accept(Visitor v){
        this.id.accept(v);
        this.args.accept(v);
        v.visit(this);
    }

    public String toString(){
        if (args == null){
            return(""+ String.format("%s ()", id));
        } else{
            return(""+ String.format("%s (%s)", id, args));
        }
    }

    public String getType(Visitor e) throws TypeConflictException{
        return "TODO";
    }
}
