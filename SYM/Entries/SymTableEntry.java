class SymTableEntry{
    public Boolean isfinal;
    public SymTableEntry parent;
    public SymTable table;
    public String name;
    public SymType type;

    public SymTableEntry(){
        this.parent = null;
        this.table = null;
        this.isfinal = false;
    }
    public SymTableEntry(String name, SymType type){
        this.name = name;
        this.type = type;
    }

    public SymTableEntry(Boolean fin, String name, SymType type){
        this.isfinal = fin;
        this.name = name;
        this.type = type;
    }

    public static String getBase(int indent){
        String base = "";
        for(int i=0; i<indent; i++){
            base += "\t";
        }
        return base;
    }

    public String toString(int indent){
        if(this.isfinal){
            return getBase(indent) + String.format("final %s %s", this.type.getType(), this.name);
        }
        return getBase(indent) + String.format("%s %s", this.type.getType(), this.name);
    }
}
