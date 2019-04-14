import java.util.*;
class SymTable {
    ArrayList<SymTableEntry> table;

    public SymTable(){
        table = new ArrayList<SymTableEntry>();
    }

    public SymTableEntry lookup(String name){
        for( SymTableEntry e : this.table){
            if (e.name.equals(name)){
                return e;
            }
        }
        return null;
    }

    public void add(SymTableEntry entry){
        this.table.add(entry);
    }

    public String toString(int indent){
        String tableString = "";
        for(SymTableEntry e : this.table){
            tableString += String.format("%s\n", e.toString(indent));
        }
        return tableString;
    }
}
