import java.util.*;
class IntVisitor implements Visitor{

    /*
        We don't need to type check on a lot of things thank the lord.

        How to keep track of scope:
            when hitting any scope increasing AST we run:
                this.gst.lookup(ident)
                keep track of the current entry in our class
            when exit() is called we make the cur go to it's parent
    */
    private GlobalSymbolTable gst;
    private Stack<SymTableEntry> previousScope;
    public IntVisitor(GlobalSymbolTable g){
        this.gst = g;
        this.previousScope = new Stack<SymTableEntry>();
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

    }
    public void visit( FielddeclsAST a ){
        a.getValue(this);
    }
    public void visit( FunctionexprAST a ){

    }
    public void visit( MemberdeclsAST a ){

    }
    public void visit( MethodAST a ){

    }
    public void visit( MethoddeclsAST a ){
        this.gst.lookup(a);
        if(a.ident.name.equals("main") && a.returns.isvoid){
            a.getValue(this);
        }
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
    }
    public void visit( SimpleFunctionArgsAST a ){

    }
    public void visit( SimpleFunctionAST a ){

    }
    public void visit( SimpleNamePlusPlusAST a ){

    }
    public void visit( SimpleNameMinusMinusAST a ){

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

    }
    public void visit( CastexprAST a ){

    }
    public void visit( SingleexprAST a ){

    }
    public void visit( SingleParenedExprAST a ){

    }
    public void visit( TernaryexprAST a ){

    }
    public void visit( UnaryexprAST a ){

    }
    public void visit( ArgarrayAST a ){

    }
    public void visit( ParameterArgsAST a ){

    }

    public void exit(){
        /*
        System.out.println(this.gst);
        System.out.println("GSDF");
        for(SymTableEntry e : this.gst.curtable.table){
            System.out.println(e.name);
        }
        */

        if(this.previousScope.size() > 0){
            this.gst.cur_entry = this.previousScope.pop();
            this.gst.curtable = this.gst.cur_entry.table;
        }
    }

    public SymTableEntry lookup(String name){
        SymTableEntry e = this.gst.lookup(name);
        return e;
    }

    public SymTableEntry lookup(MethoddeclsAST a){
        this.previousScope.push(this.gst.cur_entry);
        return this.gst.lookup(a);
    }

    public SymTableEntry lookup(ArrayList<String> names){
        return this.gst.lookup(names);
    }

    public void updateEntry(String name, Object value){
        this.gst.updateEntry(name, value);
    }
}
