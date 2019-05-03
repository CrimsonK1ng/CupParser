import java.util.*;
class SimpleFunctionArgsAST extends SimplestateAST implements AST{
    public IdentAST id;
    public ParameterArgsAST args;

    public SimpleFunctionArgsAST(IdentAST id, ParameterArgsAST args){
        this.id = id;
        this.args = args;
    }


    public void accept(Visitor v){
        this.id.accept(v);
        this.args.accept(v);
        v.visit(this);
    }

    public String toString(){
        return(""+ String.format("%s ( %s );", this.id, this.args));
    }

    public String toString(int indent){
        return(getBase(indent) + String.format("%s ( %s );", this.id, this.args));
    }

    public ArrayList<String> getSymName(Visitor e){
        String name = this.id.name;
        ArrayList<String> arg_list = new ArrayList<String>();
        ParameterArgsAST pargs = this.args;
        while(pargs != null){
            if(arg_list.size() < 1){
                arg_list.add(name + "_" + pargs.expr.getType(e));
                if(pargs.expr.getType(e).equals("int")){
                    arg_list.add(name + "_float");
                }
                else if(pargs.expr.getType(e).equals("bool")){
                    arg_list.add(name + "_int");
                }
            }
            else{
                for(int i = 0; i < arg_list.size(); i++){
                    String cur_entry = arg_list.get(i);
                    arg_list.set(i, cur_entry + "_" + pargs.expr.getType(e));
                    if(pargs.expr.getType(e).equals("int")){
                        arg_list.add(cur_entry + "_float");
                    }
                    else if(pargs.expr.getType(e).equals("bool")){
                        arg_list.add(cur_entry + "_int");
                    }
                }
            }
            pargs = pargs.next_arg;
        }
        if(arg_list.isEmpty()){
            arg_list.add(name + "_");
        }
        return arg_list;
    }
    public String getType(Visitor e){

        SymTableEntry entry = e.lookup(getSymName(e));
        if(entry != null){
            return "";//entry.type.getType();
        }

        return null;
    }
    public Object getValue(Visitor v){
        //Not gonna deal with this right now.
        SymTableFunctionEntry entry = (SymTableFunctionEntry) v.lookup(getSymName(v));
        ArrayList<Object> arg_list = new ArrayList<Object>();
        ParameterArgsAST cur = this.args;
        while(cur != null){
            arg_list.add(cur.expr.getValue(v));
            cur = cur.next_arg;
        }
        if(entry != null){
            return entry.decl.getValue(v, arg_list);
        }
        return null;
    }
}
