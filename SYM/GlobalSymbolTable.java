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
        while(cur.parent != null){
            if(cur.table.lookup(name) != null){
                return this.cur_entry.table.lookup(name);
            }
            cur = this.cur_entry.parent;
        }

        //The final check
        if(name.equals(this.prog.name)){
            return this.prog;
        }
        throw new UndeclaredException(String.format("Variable %s is undeclared", name));
    }

    public SymTableEntry lookup(MethoddeclsAST m) throws UndeclaredException{
        String method_args = "";
        ArrayList<TypeAST> t = m.method.arglist.getTypes();
        System.out.println(t.size());
        for(int i=0; i < t.size(); i++){
            method_args += t.get(i).type;
            if(i < t.size()-1)
                method_args += "_";
        }
        SymTableEntry cur = this.cur_entry;
        while(cur != null){
            if(cur.table.lookup(String.format("%s_%s", m.ident.name, method_args)) != null){
                this.cur_entry = this.cur_entry.table.lookup(String.format("%s_%s", m.ident.name, method_args));
                return this.cur_entry;
            }
            cur = this.cur_entry.parent;
        }
        throw new UndeclaredException(String.format("%s is undeclared", m.ident.name, method_args));
    }

    public SymTableEntry lookup(SimpleBodyAST a){
        return this.curtable.lookup(String.format("statement_body_%d", a.toString(0).hashCode()));
    }

    public void exit(){
        this.cur_entry = this.cur_entry.parent;
        this.curtable = this.cur_entry.table;
    }

    public String toString(){
        return this.prog.toString();
    }
}
