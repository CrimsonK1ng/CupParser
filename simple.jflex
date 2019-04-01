
import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%implements sym
%class SimpleLexer

%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

public void syntax_error(Symbol s){
    System.out.println("compiler has detected a syntax error at line " + s.left 
        + " column " + s.right);
}

%}

/* 
*Comment 
*/
lineterminator      = \r|\n|\r\n
whitespace          = [ \n\t]
inputchar           = [^\r\n\t]
comment             = \\\\{inputchar}*{lineterminator}
commentblock        = (\\\*([^*]|\*+[^\\*])*)\*\\
digit               = [0-9]
letter              = [A-Za-z]
alphanumeric        = {letter}|{digit}
intlit              = {digit}+
charlit             = \'([^\'\\]|\\\'|\\\\)\'
stringlit           = \"(.*?|\\\'|\\\"|\\\,|\\\\|\\t|\\n|[  ])*\"+
floatlit            = {digit}+\.{digit}+
identifier          = [a-zA-Z]{alphanumeric}*


%%
/* 
*Keywords 
*/
class           { return newSym(sym.CLASS, "class"); }
final           { return newSym(sym.FINAL, "final"); }
true            { return newSym(sym.TRUE, yytext()); }
false           { return newSym(sym.FALSE, yytext()); }
void            { return newSym(sym.VOID, "void"); }
bool            { return newSym(sym.BOOL, "bool"); }
int             { return newSym(sym.INT, "int"); }
float           { return newSym(sym.FLOAT, "float"); }
char            { return newSym(sym.CHAR, "char"); }
string          { return newSym(sym.STRING, "string"); }
else            { return newSym(sym.ELSE, "else"); }
if              { return newSym(sym.IF, "if"); }
print           { return newSym(sym.PRINT, "print"); }
return          { return newSym(sym.RETURN, "return"); }
printline       { return newSym(sym.PRINTLINE, "printline"); }
read            { return newSym(sym.READ, "read"); }
"*"             { return newSym(sym.TIMES, "*"); }
"+"             { return newSym(sym.PLUS, "+"); }
"-"             { return newSym(sym.MINUS, "-"); }
"/"             { return newSym(sym.DIVIDE, "/"); }
";"             { return newSym(sym.SEMI, ";"); }
":"             { return newSym(sym.COLON, ":"); }
","             { return newSym(sym.COMMA, ","); }
"("             { return newSym(sym.LEFT_PAREN, "("); }
")"             { return newSym(sym.RT_PAREN, ")"); }
"{"             { return newSym(sym.LEFT_CURL, "{"); }
"}"             { return newSym(sym.RT_CURL, "}"); }
"["             { return newSym(sym.LEFT_BRKT, "["); }
"]"             { return newSym(sym.RT_BRKT, "]"); }
"="             { return newSym(sym.EQ, "="); }
"=="            { return newSym(sym.EQEQ, "=="); }
">"             { return newSym(sym.GTR, ">"); }
"<"             { return newSym(sym.LESS, "<"); }
"<="            { return newSym(sym.LESS_EQ, "<="); }
">="            { return newSym(sym.GTR_EQ, ">="); }
"<>"            { return newSym(sym.NOT_EQ, "<>"); }
"||"            { return newSym(sym.OR, "||"); }
"&&"            { return newSym(sym.AND, "&&"); }
"?"             { return newSym(sym.QUES, "?"); }
"~"             { return newSym(sym.BNOT, "~"); }
{identifier}    { return newSym(sym.IDENT, yytext()); }
{intlit}        { return newSym(sym.INTLIT, yytext()); }
{floatlit}      { return newSym(sym.FLOATLIT, yytext()); }
{charlit}       { return newSym(sym.CHARLIT, yytext().charAt(1) ); }
{stringlit}     { return newSym(sym.STRINGLIT, yytext()); }
{comment}       { /* Ignore comment line */
                    System.out.println("Comment line: " + yytext()); }
{commentblock}  { /* Ignore comment line */
                    System.out.println("Comment block: " + yytext()); }
{whitespace}    { /* Ignored */ }
/* error fallback */
<<EOF>>         { return newSym(EOF); }
.               { throw new Error("Unexpected character ["+yytext()+"]"); }
