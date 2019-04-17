import java.util.*;
class GlobalSymbolTable {
    /*
        Starts the GST. Should contain the program name and then the entrance.
    */
    public SymTableProgramEntry prog;
    public SymTableEntry cur_entry;
    public SymTable curtable;

    public int scopeCount;
    public GlobalSymbolTable(){
    }

    public void startProgram(String name){
        this.prog = new SymTableProgramEntry(name);
        this.curtable = this.prog.table;
        this.cur_entry = this.prog;
    }

    public void addEntry(SymTableEntry entry) throws MultiplyDeclaredException{
        entry.parent = this.cur_entry;
        if(this.curtable.lookupInScope(entry.name) == null)
            this.curtable.add(entry);
        else
            throw new MultiplyDeclaredException(String.format("%s %s", entry.type.getType(), entry.name));
    }

    public void addEntry(SymTableFunctionEntry entry) throws MultiplyDeclaredException{

        entry.parent = this.cur_entry;
        if(this.curtable.lookupInScope(entry.name) == null)
            this.curtable.add(entry);
        else
            throw new MultiplyDeclaredException(String.format("%s %s", entry.type.getType(), entry.name));

        this.curtable = entry.table;
        this.cur_entry = entry;
        this.scopeCount += 1;
    }

    public void addEntry(SymTableStatementCurlyEntry entry) throws MultiplyDeclaredException{
        entry.parent = this.cur_entry;
        if(this.curtable.lookupInScope(entry.name) == null)
            this.curtable.add(entry);
        else
            throw new MultiplyDeclaredException(String.format("%s %s", entry.type.getType(), entry.name));
        this.curtable = entry.table;
        this.cur_entry = entry;
        this.scopeCount += 1;
    }

    public SymTableEntry lookup(String name){
        SymTableEntry cur = this.cur_entry;
        while(cur != null){
            if(cur.table.lookup(name) != null){
                return cur.table.lookup(name);
            }
            cur = cur.parent;
        }

        //The final check
        if(name.equals(this.prog.name)){
            return this.prog;
        }

        List<String> splitname = Arrays.asList(name.split("_"));

        if(splitname.size() > 1){
            throw new UndeclaredException(String.format("Function %s(%s) is undeclared", splitname.get(0), String.join(" ", splitname.subList(1,splitname.size()))));
        }
        throw new UndeclaredException(String.format("Variable %s is undeclared", name));
    }

    public SymTableEntry lookup(MethoddeclsAST m) throws UndeclaredException{
        String method_args = "";
        ArrayList<TypeAST> t = m.method.arglist.getTypes();
        for(int i=0; i < t.size(); i++){
            method_args += t.get(i).type;
            if(i < t.size()-1)
                method_args += "_";
        }
        SymTableEntry cur = this.cur_entry;
        while(cur != null){
            if(cur.table.lookup(String.format("%s_%s", m.ident.name, method_args)) != null){
                this.cur_entry = cur.table.lookup(String.format("%s_%s", m.ident.name, method_args));
                return this.cur_entry;
            }
            cur = cur.parent;
        }
        throw new UndeclaredException(String.format("Function %s(%s) is undeclared", m.ident.name, method_args));
    }

    public SymTableEntry lookup(SimpleBodyAST a){
        SymTableEntry cur = this.cur_entry;
        while(cur != null){
            if(cur.table.lookup(String.format("statement_body_%d", a.toString(0).hashCode())) != null){
                this.cur_entry = cur.table.lookup(String.format("statement_body_%d", a.toString(0).hashCode()));
                return this.cur_entry;
            }
            cur = cur.parent;
        }
        throw new UndeclaredException(String.format("Statement %s is undeclared (SHOULD NEVER HAPPEN, HOW DID YOU DO THIS)", a.toString(0)));
    }

    public void exit(){
        this.cur_entry = this.cur_entry.parent;
        this.curtable = this.cur_entry.table;
    }

    public String toString(){
        return this.prog.toString();
    }
}
