class SymTableArrayEntry extends SymTableEntry{
    int size;

    public SymTableArrayEntry(String name, SymType type, int size){
        super(name, type);
        this.size = size;
    }
    public SymTableArrayEntry(Boolean fin, String name, SymType type, int size){
        super(fin, name, type);
        this.size = size;
    }
    public String toString(int indent){
        if(this.isfinal){
            return getBase(indent) + String.format("final %s %s[]", this.type.getType(), this.name);
        }
        return getBase(indent) + String.format("%s %s[%d]", this.type.getType(), this.name, this.size);
    }
}
