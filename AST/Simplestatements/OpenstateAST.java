abstract class OpenstateAST extends StatementAST implements AST{
    public String toString(){
        return(""+ String.format("%s %s", this.open, this.close));
    }

    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s %s", this.open.toString(indent), this.close.toString(indent)));
    }

    @Override
    public String getType(Visitor e){
        if(this.open != null)
            return this.open.getType(e);
        else if(this.close != null)
            return this.close.getType(e);
        return "";
    }

}
