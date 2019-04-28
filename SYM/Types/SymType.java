abstract class SymType{
    public String type;
    public Object value;
    public SymType(){}

    public abstract Object getValue();
    public abstract void setValue(Object o);
    public abstract String getType();
}
