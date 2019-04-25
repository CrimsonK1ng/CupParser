import java.util.*;
class ASTVisitor implements Visitor{
    /*
    TODO ask professor Maclin how we handle the type checking lookups if we
    come across something like:

    ```
        a = 203
        int a;
    ```

    TODO I believe this should throw an error right away on this first parse. So
        First parse should notify issues like the above.
    */

    private GlobalSymbolTable gst;
    public ASTVisitor(){
        this.gst = new GlobalSymbolTable();
    }

    public void visit( ProgramAST a ){
        this.gst.startProgram(a.id.name);
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
        this.gst.addEntry(new SymTableEntry(
            a.id.name,
            getSymType(a.type.type)
        ));
    }
    public void visit( ExprAST a ){

    }
    public void visit( ArgdeclsAST a ){

    }
    public void visit( FielddeclsAST a ){
        // TODO value is not stored inside the Entries right now.
        if(a.field instanceof FieldExprAST){
            this.gst.addEntry(new SymTableEntry(
                a.fin.ifFinal,
                a.ident.name,
                getSymType(a.type.type)
            ));
        } else if (a.field instanceof FieldArrayAST){
            FieldArrayAST fa = (FieldArrayAST) a.field;
            this.gst.addEntry(new SymTableArrayEntry(
                a.fin.ifFinal,
                a.ident.name,
                getSymType(a.type.type),
                fa.num.number
            ));
        }
    }
    public void visit( FunctionexprAST a ){

    }
    public void visit( MemberdeclsAST a ){

    }
    public void visit( MethodAST a ){
    }
    public void visit( MethoddeclsAST a ){
        String method_args = "";
        ArrayList<TypeAST> t = a.method.arglist.getTypes();
        for(int i=0; i < t.size(); i++){
            method_args += t.get(i).type;
            if(i < t.size()-1)
                method_args += "_";
        }
        if(a.returns.isvoid){
            this.gst.addEntry(new SymTableFunctionEntry(
                String.format("%s_%s",a.ident.name, method_args),
                getSymType("")
            ));
        } else {
            this.gst.addEntry(new SymTableFunctionEntry(
                String.format("%s_%s",a.ident.name, method_args),
                getSymType(a.returns.type.type)
            ));
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
        //Saving it with a hashcode appended should give us a consistent lookup :)
        this.gst.addEntry(new SymTableStatementCurlyEntry(
            String.format("statement_body_%d", a.toString(0).hashCode())
        ));
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
        this.gst.addEntry(new SymTableArgArrayEntry(
            a.id.name,
            getSymType(a.type.type)
        ));
    }
    public void visit( ParameterArgsAST a ){

    }

    public SymType getSymType(String t){
        if(t.equals("")) {
            return (new SymTypeVoid());
        } else if ( t.equals("int") ){
            return (new SymTypeInt());
        } else if ( t.equals("float") ){
            return (new SymTypeFloat());
        } else if ( t.equals("char") ){
            return (new SymTypeChar());
        } else if ( t.equals("bool") ){
            return (new SymTypeBool());
        }
        return null; //SHOULD NOT HAPPEN
    }

    public void exit(){
        this.gst.exit();
    }

    public void printGST(){
        System.out.println(this.gst);
    }

    public GlobalSymbolTable getGST(){
        return this.gst;
    }

    public SymTableEntry lookup(String s){
        return null;
    }
    public SymTableEntry lookup(ArrayList<String> s){
        return null;
    }
}
