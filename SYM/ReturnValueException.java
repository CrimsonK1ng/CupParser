class ReturnValueException extends RuntimeException{
    public Object value;

    public ReturnValueException(Object value){
        super(""); 
        this.value = value;
    }

    public ReturnValueException(String m){
        super(m);
    }
}
