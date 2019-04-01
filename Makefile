JAVA=java
JAVAC=javac
# Root of the project
JFLEX=./jflex
CUPJAR=java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR):class-files

default: test

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $(wildcard *java) $(wildcard AST/*)  -d class-files

FILE=	SimpleLexer.java parser.java  sym.java\
		$(shell find AST -name *AST*) \
		Main.java

run: output.txt

output.txt: all
	$(JAVA) -cp $(CP) Main < example.as > output.txt
	cat output.txt

all: SimpleLexer.java parser.java $(FILE:java=class)

clean:
	rm -f class-files/*.class *.class *~ *.bak Yylex.java parser.java sym.java

SimpleLexer.java: simple.jflex
	$(JFLEX) simple.jflex

parser.java: parser.cup
	$(CUP) -interface -dump < parser.cup

test: output.txt
	@(diff output.txt output.good && echo "Test OK!") || echo "Test failed!"
