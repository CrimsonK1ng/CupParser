class SymTableArgArrayEntry extends SymTableEntry{
    int size;

    public SymTableArgArrayEntry(String name, SymType type){
        super(name, type);
    }
    public String toString(int indent){
        return getBase(indent) + String.format("%s %s[]", this.type.getType(), this.name);
    }
}
