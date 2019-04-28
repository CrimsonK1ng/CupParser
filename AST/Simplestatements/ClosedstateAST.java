/*
This class exists to handle the one case where closed returns a simple
*/
class ClosedstateAST extends StatementAST implements AST{
    public SimplestateAST simple;

    public ClosedstateAST(){}

    public ClosedstateAST(SimplestateAST simple){
        this.simple = simple;
    }


    public void accept(Visitor v){
        v.visit(this);
        this.simple.accept(v);
    }

    public String toString(int indent){
        return( String.format("%s", this.simple.toString(indent)));
    }

    @Override
    public String getType(Visitor e){
        if(this.simple != null)
            return this.simple.getType(e);
        return "";
    }
    public Object getValue(Visitor v){
        if(this.simple != null)
            return this.simple.getValue(v);
        return null;

    }
}
