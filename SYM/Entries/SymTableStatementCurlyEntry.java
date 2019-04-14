import java.util.*;
class SymTableStatementCurlyEntry extends SymTableEntry{

    public SymTableStatementCurlyEntry(){
        super("Statement", new SymTypeVoid());
        this.table = new SymTable();
    }

    public SymTableStatementCurlyEntry(String name){
        super(name, new SymTypeVoid());
        this.table = new SymTable();
    }

    public SymTableStatementCurlyEntry(SymTableEntry parent){
        super("Statement", new SymTypeVoid());
        this.table = new SymTable();
        this.parent = parent;
    }

    public String toString(int indent){
        return getBase(indent) +
                String.format("statement %s \n%s", this.name, this.table.toString(indent+1));
    }
}
