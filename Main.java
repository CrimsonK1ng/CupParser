import java.io.*;
import java.util.*;

public class Main {

  public static void main(String [] args) throws Exception {
    Reader reader = null;

    if (args.length == 1) {
      File input = new File(args[0]);
      if (!input.canRead()) {
        System.out.println("Error: could not read ["+input+"]");
      }
      reader = new FileReader(input);
    }
    else {
     reader = new InputStreamReader(System.in);
    }

    SimpleLexer scanner = new SimpleLexer(reader);   // create scanner

    parser parser = new parser(scanner); // create parser
    ProgramAST program = null;

    try {
        program = (ProgramAST) parser.parse().value;  // parse
        ASTVisitor visitor = new ASTVisitor();
        program.accept(visitor);
        //Build symbol table
        visitor.printGST();

        TCVisitor tc = new TCVisitor(visitor.getGST());
        //Type check
        program.accept(tc);
        //Print AST
        System.out.println(program);

        System.out.println("---------Program Output---------");
        IntVisitor iv = new IntVisitor(visitor.getGST());
        program.accept(iv);
    }
    catch (MultiplyDeclaredException e){
        e.printStackTrace();
    }
    catch (Exception e) {
        e.printStackTrace();
    }

  }

  public static void error(String s) {
    System.out.println(s);
  }
}
