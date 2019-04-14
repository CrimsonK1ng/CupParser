class SymTableProgramEntry extends SymTableEntry{
    public SymTableProgramEntry(String name){
        super(name, new SymTypeVoid());
        this.table = new SymTable();
    }

    public String toString(){
        return String.format("class %s \n%s", this.name, table.toString(1));
    }
}
