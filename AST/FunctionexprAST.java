
class FunctionexprAST implements AST{
    IdentAST id;
    IdentAST args; //need to make Args

    public FunctionexprAST(IdentAST id){
        this.id= id;
    }

    public FunctionexprAST(IdentAST id, IdentAST args){
        this.id= id;
        this.args= args;
        
    }

    public String toString(){
        if (args == null){
            return("" + String.format("%s ()", id));
        } else{
            return("" + String.format("%s (%s)", id, args));
        }
    }
}
