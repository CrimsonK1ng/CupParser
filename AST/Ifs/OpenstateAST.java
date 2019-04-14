abstract class OpenstateAST extends StatementAST implements AST{
    public String toString(){
        return("" + String.format("%s %s", this.open, this.close));
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s %s", this.open.toString(indent), this.close.toString(indent)));
    }
}
