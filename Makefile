JAVA=java
JAVAC=javac
# Root of the project
JFLEX=./jflex
CUPJAR=java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR):class-files

default: all test2

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $(wildcard *java) \
	$(wildcard AST/*java) \
	$(wildcard AST/Arg/*java) \
	$(wildcard AST/Expressions/*java)  \
	$(wildcard AST/Ifs/*java) \
	$(wildcard AST/Literals/*java) \
	$(wildcard AST/Fields/*java) \
	$(wildcard AST/Optionals/*java) \
	$(wildcard AST/Name/*java) \
	$(wildcard AST/Simplestatements/*java) \
	$(wildcard SYM/Visitor/*java) \
	$(wildcard SYM/Entries/*java) \
	$(wildcard SYM/Types/*java) \
	$(wildcard SYM/*java) \
	-d class-files

FILE=	SimpleLexer.java parser.java  sym.java\
		$(shell find AST -name *AST*) \
		Main.java

run: output.txt

test1:
	$(JAVA) -cp $(CP) Main < tests/test1.txt > test_generated/test1.txt

test2:
	$(JAVA) -cp $(CP) Main < tests/test2.txt > test_generated/test2.txt
	cat test_generated/test2.txt

test3:
	$(JAVA) -cp $(CP) Main < tests/test3.txt > test_generated/test3.txt
	cat test_generated/test3.txt

test4:
	$(JAVA) -cp $(CP) Main < tests/test4.txt > test_generated/test4.txt
	cat test_generated/test4.txt

test_multiply:
	$(JAVA) -cp $(CP) Main < tests/test_multiply.txt > test_generated/test_multiply.txt
	cat test_generated/test_multiply.txt

test_return:
	$(JAVA) -cp $(CP) Main < tests/test_return.txt > test_generated/test_return.txt
	cat test_generated/test_return.txt
test_field_decls:
	$(JAVA) -cp $(CP) Main < tests/test_field_decl.txt > test_generated/test_field_decl.txt
	cat test_generated/test_field_decl.txt
test_field_decl_bad:
	$(JAVA) -cp $(CP) Main < tests/test_field_decl_bad.txt > test_generated/test_field_decl_bad.txt
	cat test_generated/test_field_decl_bad.txt
test_scopes:
	$(JAVA) -cp $(CP) Main < tests/test_scopes.txt > test_generated/test_scopes.txt
	cat test_generated/test_scopes.txt
test_method_return:
	$(JAVA) -cp $(CP) Main < tests/test_method_return.txt > test_generated/test_method_return.txt
	cat test_generated/test_method_return.txt
test_method_return_bad:
	$(JAVA) -cp $(CP) Main < tests/test_method_return_bad.txt > test_generated/test_method_return_bad.txt
	cat test_generated/test_method_return_bad.txt

all: SimpleLexer.java parser.java $(FILE:java=class)

clean:
	rm -f class-files/*.class *.class *~ *.bak Yylex.java parser.java sym.java

SimpleLexer.java: simple.jflex
	$(JFLEX) simple.jflex

parser.java: parser.cup
	$(CUP) -interface -dump < parser.cup

test: all test1 test2 test3 test4
	@(diff test_generated/test1.txt gold/test1.gold && echo "[Test 1]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test2.txt gold/test2.gold && echo "[Test 2]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test3.txt gold/test3.gold && echo "[Test 3]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test4.txt gold/test4.gold && echo "[Test 3]\t\tTest OK!") || echo "Test failed!"
