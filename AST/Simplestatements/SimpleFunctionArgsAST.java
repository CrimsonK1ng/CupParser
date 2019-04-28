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
    public String getType(Visitor e){
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

        SymTableEntry entry = e.lookup(arg_list);
        if(entry != null){
            return "";//entry.type.getType();
        }

        return null;
    }
    public Object getValue(Visitor v){
        //Not gonna deal with this right now.
        return null;
    }
}
