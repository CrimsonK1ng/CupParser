# Sym Table

This is the symbol table building code.

Visitor:
    Contains the code for the Visitor design pattern.

    All AST members have an ```accept``` method declared for the visitor.
    All visitors have a ```visit``` method defined for a given AST.

    All actions defined will build the symbol table.

    TODO Visitors may keep track of defined scope. But may leave that to SymTable?
Types:
    Simple class for keeping track of types


**ISSUES**
    IF Statements require a way to be hashed that won't conflict with other if statemetns.
    Currently the code does not respect this and as such will conflict. Maybe that is why
    Lists are preferred?
        |
        -> Idea is to just take the expression and hash that.
            Maybe I will just make it a linked list :(
                
SymTable*:
    All code with this basename works on developing the symbol table.

    Always start with a **GlobalSymbolTable** which keeps track of head of GlobalSymbolTable
    and then moves us into the correct scope.

    All SymbleTableEntries contain a *Parent* reference such that as we traverse the
    tree we can return the parent to bounce out of the current scope so:

    Program
        |
        -> Function
                |
                -> If
                    |
                    -> If
                        |
                 Parent<-
                 |
          <Parent-
    And so on.


    Not quite sure if this will work well but it should be good I think.
