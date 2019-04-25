abstract class SymType{
    public String type;
    public Object value;
    public SymType(){}

    public abstract Object getValue();
    public abstract String getType();
}
