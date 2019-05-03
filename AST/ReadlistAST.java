import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
class ReadlistAST implements AST{
    NameAST name;
    ReadlistAST read;

    public ReadlistAST(NameAST name){
        this.name = name;
        this.read = null;
    }

    public ReadlistAST(NameAST name, ReadlistAST read){
        this.name = name;
        this.read = read;
    }


    public void accept(Visitor v){
        this.name.accept(v);
        if(this.read != null)
            this.read.accept(v);
        v.visit(this);
    }

    public String toString(){
        if (this.read != null){
            return(""+ String.format("%s, %s", this.name, this.read));
        }
        return(""+ String.format("%s", this.name));
    }

    public String getType(Visitor e) throws TypeConflictException{
        if(this.name.getType(e).equals("array")){
            throw new TypeConflictException(String.format(
                "Cannot read array"
            ));
        }
        if(this.read != null){
            this.read.getType(e);
        }
        return "";
    }
    public Object getValue(Visitor v){
        SymTableEntry entry = v.lookup(this.name.getId());
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Boolean notValid = true;
        while(notValid){
            try{
                System.out.print(String.format("Input for %s of type %s: ", entry.name, entry.type.getType()));
                String input = scanner.readLine();
                switch(entry.type.getType()){
                    case "int":
                        entry.type.setValue( Integer.parseInt(input));
                        notValid = false;
                    case "float":
                        entry.type.setValue( Float.parseFloat(input));
                        notValid = false;
                    case "char":
                        if(input.length() == 1){
                            entry.type.setValue( input.charAt(0));
                            notValid = false;
                        } else {
                            System.out.println("Must be single char");
                        }
                    case "bool":
                        if(input.toLowerCase().equals("true") || input.toLowerCase().equals("false")){
                            entry.type.setValue( Boolean.parseBoolean(input));
                            notValid = false;
                        }
                    default:
                }
            }
            catch (NumberFormatException e){
                System.out.println("Not a Number");
            }
            catch (ClassCastException e){
            }
            catch (IOException e){
            }
        }
        if(this.read != null)
            this.read.getValue(v);
        return null;
    }
}
