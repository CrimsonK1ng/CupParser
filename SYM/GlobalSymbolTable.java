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

    public void addEntry(SymTableEntry entry){
        entry.parent = this.cur_entry;
        this.curtable.add(entry);
    }

    public void addEntry(SymTableFunctionEntry entry){

        entry.parent = this.cur_entry;
        this.curtable.add(entry);

        this.curtable = entry.table;
        this.cur_entry = entry;
        this.scopeCount += 1;
    }

    public void addEntry(SymTableStatementCurlyEntry entry){
        entry.parent = this.cur_entry;
        this.curtable.add(entry);
        this.curtable = entry.table;
        this.cur_entry = entry;
        this.scopeCount += 1;
    }

    public void exitScope(){
        this.cur_entry = this.cur_entry.parent;
        this.curtable = this.cur_entry.table;
    }

    public String toString(){
        return this.prog.toString();
    }
}
