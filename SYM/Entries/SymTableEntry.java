class SymTableEntry{
    public Boolean ifFinal;
    public SymTableEntry parent;
    public SymTable table;
    public String name;
    public SymType type;
    public Boolean isArray;
    public int size;

    public SymTableEntry(){
        this.parent = null;
        this.table = null;
        this.ifFinal = false;
        this.isArray = false;
        this.size = 0;
    }
    public SymTableEntry(String name, SymType type){
        this.parent = null;
        this.table = null;
        this.ifFinal = false;
        this.isArray = false;
        this.size = 0;
        this.name = name;
        this.type = type;
    }

    public SymTableEntry(Boolean fin, String name, SymType type){
        this.parent = null;
        this.table = null;
        this.isArray = false;
        this.ifFinal = fin;
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
        if(this.ifFinal){
            return getBase(indent) + String.format("final %s %s", this.type.getType(), this.name);
        }
        return getBase(indent) + String.format("%s %s", this.type.getType(), this.name);
    }
}
