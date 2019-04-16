abstract class ExpressionLiterals extends ExprAST implements AST{
    public String type;
    public ExpressionLiterals(){
    }

    public ExpressionLiterals(String s){
        this.type = s;
    }

    public String getType(Visitor e){
        return type;
    };
}
