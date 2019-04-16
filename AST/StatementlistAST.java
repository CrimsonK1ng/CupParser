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
        this.state.accept(v);
        if(this.slist.state != null)
            this.slist.accept(v);
        v.visit(this);
    }

    public String toString(int indent){
        if(this.state == null) return "";
        return(String.format("%s\n%s", this.state.toString(indent), this.slist.toString(indent)));
    }

    public String getType(Visitor e) throws TypeConflictException{
        StatementlistAST cur = this;
        System.out.println(state.getType(e));
        String ret = "";
        while(cur.state != null){
            System.out.println(ret);
            String temp = "";
            temp = cur.state.getType(e);
            if(ret.isEmpty()){
                ret = temp;
            }
            else if(!ret.equals(temp)){
                throw new TypeConflictException(
                    String.format("Return type conflict %s %s", ret, temp)
                );
            }
            cur = this.slist;
        }
        if(ret.isEmpty())
            return "void";
        return ret;
    }
}
