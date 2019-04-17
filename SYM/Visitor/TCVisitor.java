import java.util.*;
class TCVisitor implements Visitor{

    /*
        We don't need to type check on a lot of things thank the lord.

        How to keep track of scope:
            when hitting any scope increasing AST we run:
                this.gst.lookup(ident)
                keep track of the current entry in our class
            when exit() is called we make the cur go to it's parent
    */
    private GlobalSymbolTable gst;
    private SymTableEntry cur;
    public TCVisitor(GlobalSymbolTable g){
        this.gst = g;
    }

    public void visit( ProgramAST a ){

    }

    public void visit( BinaryOp a ){
    }
    public void visit( FieldAST a ){
    }
    public void visit( FieldArrayAST a ){

    }
    public void visit( FieldExprAST a ){
    }
    public void visit( ArgAST a ){
    }
    public void visit( ExprAST a ){
    }
    public void visit( ArgdeclsAST a ){
        a.getType(this);

    }
    public void visit( FielddeclsAST a ){
        a.getType(this);
    }
    public void visit( FunctionexprAST a ){

    }
    public void visit( MemberdeclsAST a ){
    }
    public void visit( MethodAST a ){
    }
    public void visit( MethoddeclsAST a ){
        this.gst.lookup(a);
        a.getType(this);
    }
    public void visit( PrintlistAST a ){
    }
    public void visit( ReadlistAST a ){
    }
    public void visit( ReturntypeAST a ){
    }
    public void visit( StatementAST a ){

    }
    public void visit( StatementlistAST a ){

    }
    public void visit( TypeAST a ){

    }
    public void visit( ReturnsimpleAST a ){

    }
    public void visit( ReturnSimpleExprAST a ){

    }
    public void visit( SimpleAssignAST a ){

    }
    public void visit( SimpleBodyAST a ){
        this.cur = this.gst.lookup(a);
    }
    public void visit( SimpleFunctionArgsAST a ){

    }
    public void visit( SimpleFunctionAST a ){

    }
    public void visit( SimpleNameAST a ){

    }
    public void visit( SimplePrintlineAST a ){

    }
    public void visit( SimplePrintlistAST a ){

    }
    public void visit( SimpleNewStateAST a ){

    }
    public void visit( OptionalexprAST a ){

    }
    public void visit( OptionalcommaAST a ){

    }
    public void visit( OptionalfinalAST a ){

    }
    public void visit( OptionalsemiAST a ){

    }
    public void visit( NamearrayAST a ){

    }
    public void visit( NameAST a ){

    }
    public void visit( BooleanAST a ){

    }
    public void visit( CharlitAST a ){

    }
    public void visit( FloatlitAST a ){

    }
    public void visit( IdentAST a ){

    }
    public void visit( IntlitAST a ){
    }
    public void visit( StringlitAST a ){

    }
    public void visit( ClosedstateAST a ){

    }
    public void visit( IfClosedAST a ){

    }
    public void visit( IfOpenstateAST a ){

    }
    public void visit( IfOpenStateCloseOpenAST a ){

    }
    public void visit( OpenstateAST a ){

    }
    public void visit( WhileclosedAST a ){

    }
    public void visit( WhileopenstateAST a ){

    }
    public void visit( BinaryexprAST a ){
        a.getType(this);

    }
    public void visit( CastexprAST a ){
        a.getType(this);

    }
    public void visit( SingleexprAST a ){
        a.getType(this);

    }
    public void visit( SingleParenedExprAST a ){
        a.getType(this);

    }
    public void visit( TernaryexprAST a ){
        a.getType(this);

    }
    public void visit( UnaryexprAST a ){
        a.getType(this);

    }
    public void visit( ArgarrayAST a ){
        a.getType(this);

    }
    public void visit( ParameterArgsAST a ){
        a.getType(this);

    }

    public void exit(){
        this.gst.exit();
    }

    public SymTableEntry lookup(String name){
        SymTableEntry e = this.gst.lookup(name);
        return e;
    }
}
