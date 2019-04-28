class ReturnException extends RuntimeException{
    public ReturnException(){
        super("");
    }

    public ReturnException(String m){
        super(m);
    }
}
