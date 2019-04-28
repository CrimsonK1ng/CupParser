class StatementlistAST extends SimpleMethods implements AST{
    public StatementAST state;
    public StatementlistAST slist;

    public StatementlistAST(){
        this.state = null;
        this.slist = null;
    }
    public StatementlistAST(StatementAST s, StatementlistAST sl){
        this.state = s;
        this.slist = sl;
    }


    public void accept(Visitor v){
        if(this.state != null)
            this.state.accept(v);
        if(this.slist != null)
            this.slist.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        if(this.state == null) return "";
        return(String.format("%s\n%s", this.state.toString(indent), this.slist.toString(indent)));
    }

    public String getType(Visitor e) throws TypeConflictException{
        StatementlistAST cur = this;
        String ret = "";
        String temp = "";
        while(cur.state != null){
            temp = cur.state.getType(e);
            if(ret.isEmpty()){
                ret = temp;
            }
            else if(!ret.equals(temp) && !ret.equals("void")){
                throw new TypeConflictException(
                    String.format("Return type conflict %s %s", ret, temp)
                );
            }
            cur = cur.slist;
        }
        if(ret.isEmpty())
            return "void";
        return ret;
    }


    public Object getValue(Visitor v){
        if(this.state != null){
            this.state.getValue(v);
        }
        if(this.slist != null){
            this.slist.getValue(v);
        }
        return null;
    }
}
