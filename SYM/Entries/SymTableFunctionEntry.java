import java.util.*;
class SymTableFunctionEntry extends SymTableEntry{
    public ArrayList<SymTableEntry> params; //Variable length list of parameters
    public SymTableFunctionEntry(String name, SymType type){
        super(name, type);
        this.table = new SymTable();
    }
    public SymTableFunctionEntry(String name, SymType type, SymTableEntry parent){
        super(name, type);
        this.params = params;
        this.table = new SymTable();
    }

    public String toString(int indent){
        return getBase(indent) +
                String.format("function %s %s\n%s", this.type.getType(), this.name, this.table.toString(indent+1));
    }
}
