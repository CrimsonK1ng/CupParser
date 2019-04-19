JAVA=java
JAVAC=javac
# Root of the project
JFLEX=./jflex
CUPJAR=java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR):class-files

default: all test

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
	cat test_generated/test2.txt
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
test_final:
	$(JAVA) -cp $(CP) Main < tests/test_final.txt > test_generated/test_final.txt
	cat test_generated/test_final.txt
test_final_bad:
	$(JAVA) -cp $(CP) Main < tests/test_final_bad.txt > test_generated/test_final_bad.txt
	cat test_generated/test_final_bad.txt
test_function:
	$(JAVA) -cp $(CP) Main < tests/test_function.txt > test_generated/test_function.txt
	cat test_generated/test_function.txt
test_function_bad_int:
	$(JAVA) -cp $(CP) Main < tests/test_function_bad_int.txt > test_generated/test_function_bad_int.txt
	cat test_generated/test_function_bad_int.txt
test_function_bad_char:
	$(JAVA) -cp $(CP) Main < tests/test_function_bad_char.txt > test_generated/test_function_bad_char.txt
	cat test_generated/test_function_bad_char.txt
test_function_bad_string:
	$(JAVA) -cp $(CP) Main < tests/test_function_bad_string.txt > test_generated/test_function_bad_string.txt
	cat test_generated/test_function_bad_string.txt
test_function_bad_float:
	$(JAVA) -cp $(CP) Main < tests/test_function_bad_float.txt > test_generated/test_function_bad_float.txt
	cat test_generated/test_function_bad_float.txt
test_function_bad_bool:
	$(JAVA) -cp $(CP) Main < tests/test_function_bad_bool.txt > test_generated/test_function_bad_bool.txt
	cat test_generated/test_function_bad_bool.txt
test_binops_int_int:
	$(JAVA) -cp $(CP) Main < tests/test_binops_int_int.txt > test_generated/test_binops_int_int.txt
	cat test_generated/test_binops_int_int.txt
test_binops_int_float:
	$(JAVA) -cp $(CP) Main < tests/test_binops_int_float.txt > test_generated/test_binops_int_float.txt
	cat test_generated/test_binops_int_float.txt
test_binops_string_string:
	$(JAVA) -cp $(CP) Main < tests/test_binops_string_string.txt > test_generated/test_binops_string_string.txt
	cat test_generated/test_binops_string_string.txt
test_binops_string_string_bad:
	$(JAVA) -cp $(CP) Main < tests/test_binops_string_string_bad.txt > test_generated/test_binops_string_string_bad.txt
	cat test_generated/test_binops_string_string_bad.txt
test_binops_name_expr:
	$(JAVA) -cp $(CP) Main < tests/test_binops_name_expr.txt > test_generated/test_binops_name_expr.txt
	cat test_generated/test_binops_name_expr.txt
test_binops_name_expr_bad:
	$(JAVA) -cp $(CP) Main < tests/test_binops_name_expr_bad.txt > test_generated/test_binops_name_expr_bad.txt
	cat test_generated/test_binops_name_expr_bad.txt
test_scopes:
	$(JAVA) -cp $(CP) Main < tests/test_scopes.txt > test_generated/test_scopes.txt
	cat test_generated/test_scopes.txt
test_method_return:
	$(JAVA) -cp $(CP) Main < tests/test_method_return.txt > test_generated/test_method_return.txt
	cat test_generated/test_method_return.txt
test_method_return_bad:
	$(JAVA) -cp $(CP) Main < tests/test_method_return_bad.txt > test_generated/test_method_return_bad.txt
	cat test_generated/test_method_return_bad.txt
test_method_typing:
	$(JAVA) -cp $(CP) Main < tests/test_method_typing.txt > test_generated/test_method_typing.txt
	cat test_generated/test_method_typing.txt
test_method_typing_bad:
	$(JAVA) -cp $(CP) Main < tests/test_method_typing_bad.txt > test_generated/test_method_typing_bad.txt
	cat test_generated/test_method_typing_bad.txt
test_while_expr:
	$(JAVA) -cp $(CP) Main < tests/test_while_expr.txt > test_generated/test_while_expr.txt
	cat test_generated/test_while_expr.txt
test_while_expr_bad:
	$(JAVA) -cp $(CP) Main < tests/test_while_expr_bad.txt > test_generated/test_while_expr_bad.txt
	cat test_generated/test_while_expr_bad.txt
test_plusplus:
	$(JAVA) -cp $(CP) Main < tests/test_plusplus.txt > test_generated/test_plusplus.txt
	cat test_generated/test_plusplus.txt
test_plusplus_bad:
	$(JAVA) -cp $(CP) Main < tests/test_plusplus_bad.txt > test_generated/test_plusplus_bad.txt
	cat test_generated/test_plusplus_bad.txt
test_unary:
	$(JAVA) -cp $(CP) Main < tests/test_unary.txt > test_generated/test_unary.txt
	cat test_generated/test_unary.txt
test_unary_bad:
	$(JAVA) -cp $(CP) Main < tests/test_unary_bad.txt > test_generated/test_unary_bad.txt
	cat test_generated/test_unary_bad.txt
test_unary_bool_bad:
	$(JAVA) -cp $(CP) Main < tests/test_unary_bool_bad.txt > test_generated/test_unary_bool_bad.txt
	cat test_generated/test_unary_bool_bad.txt
test_comp:
	$(JAVA) -cp $(CP) Main < tests/test_comp.txt > test_generated/test_comp.txt
	cat test_generated/test_comp.txt
test_comp_bad:
	$(JAVA) -cp $(CP) Main < tests/test_comp_bad.txt > test_generated/test_comp_bad.txt
	cat test_generated/test_comp_bad.txt
test_bool_comp:
	$(JAVA) -cp $(CP) Main < tests/test_bool_comp.txt > test_generated/test_bool_comp.txt
	cat test_generated/test_bool_comp.txt
test_bool_comp_bad:
	$(JAVA) -cp $(CP) Main < tests/test_bool_comp_bad.txt > test_generated/test_bool_comp_bad.txt
	cat test_generated/test_bool_comp_bad.txt
test_ternary:
	$(JAVA) -cp $(CP) Main < tests/test_ternary.txt > test_generated/test_ternary.txt
	cat test_generated/test_ternary.txt
test_ternary_bad:
	$(JAVA) -cp $(CP) Main < tests/test_ternary_bad.txt > test_generated/test_ternary_bad.txt
	cat test_generated/test_ternary_bad.txt
test_print_array:
	$(JAVA) -cp $(CP) Main < tests/test_print_array.txt > test_generated/test_print_array.txt
	cat test_generated/test_print_array.txt
test_print_array_bad:
	$(JAVA) -cp $(CP) Main < tests/test_print_array_bad.txt > test_generated/test_print_array_bad.txt
	cat test_generated/test_print_array_bad.txt
test_read:
	$(JAVA) -cp $(CP) Main < tests/test_read.txt > test_generated/test_read.txt
	cat test_generated/test_read.txt
test_read_bad:
	$(JAVA) -cp $(CP) Main < tests/test_read_bad.txt > test_generated/test_read_bad.txt
	cat test_generated/test_read_bad.txt

all: SimpleLexer.java parser.java $(FILE:java=class)

clean:
	rm -f class-files/*.class *.class *~ *.bak Yylex.java parser.java sym.java

SimpleLexer.java: simple.jflex
	$(JFLEX) simple.jflex

parser.java: parser.cup
	$(CUP) -interface -dump < parser.cup

test: all test*
	@(diff test_generated/test1.txt gold/test1.gold && echo "[Test 1]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test2.txt gold/test2.gold && echo "[Test 2]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test3.txt gold/test3.gold && echo "[Test 3]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test4.txt gold/test4.gold && echo "[Test 3]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_int_float.txt gold/test_binops_int_float.gold && echo "[Test 5]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_int_int.txt gold/test_binops_int_int.gold && echo "[Test 6]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_name_expr_bad.txt gold/test_binops_name_expr_bad.gold && echo "[Test 7]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_name_expr.txt gold/test_binops_name_expr.gold && echo "[Test 8]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_string_string.txt gold/test_binops_string_string.gold && echo "[Test 9]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_binops_string_string_bad.txt gold/test_binops_string_string_bad.gold && echo "[Test 10]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_bool_comp.txt gold/test_bool_comp.gold && echo "[Test 11]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_bool_comp_bad.txt gold/test_bool_comp_bad.gold && echo "[Test 12]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_comp.txt gold/test_comp.gold && echo "[Test 13]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_comp_bad.txt gold/test_comp_bad.gold && echo "[Test 14]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_field_decl.txt gold/test_field_decl.gold && echo "[Test 15]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_field_decl_bad.txt gold/test_field_decl_bad.gold && echo "[Test 16]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_final.txt gold/test_final.gold && echo "[Test 17]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_final_bad.txt gold/test_final_bad.gold && echo "[Test 18]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function.txt gold/test_function.gold && echo "[Test 19]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function_bad_int.txt gold/test_function_bad_int.gold && echo "[Test 20]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function_bad_char.txt gold/test_function_bad_char.gold && echo "[Test 21]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function_bad_string.txt gold/test_function_bad_string.gold && echo "[Test 22]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function_bad_float.txt gold/test_function_bad_float.gold && echo "[Test 23]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_function_bad_bool.txt gold/test_function_bad_bool.gold && echo "[Test 24]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_method_return.txt gold/test_method_return.gold && echo "[Test 25]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_method_return_bad.txt gold/test_method_return_bad.gold && echo "[Test 26]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_method_typing.txt gold/test_method_typing.gold && echo "[Test 27]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_method_typing_bad.txt gold/test_method_typing_bad.gold && echo "[Test 28]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_multiply.txt gold/test_multiply.gold && echo "[Test 29]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_plusplus.txt gold/test_plusplus.gold && echo "[Test 30]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_plusplus_bad.txt gold/test_plusplus_bad.gold && echo "[Test 31]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_return.txt gold/test_return.gold && echo "[Test 32]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_scopes.txt gold/test_scopes.gold && echo "[Test 33]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_ternary.txt gold/test_ternary.gold && echo "[Test 34]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_ternary_bad.txt gold/test_ternary_bad.gold && echo "[Test 35]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_unary.txt gold/test_unary.gold && echo "[Test 36]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_unary_bad.txt gold/test_unary_bad.gold && echo "[Test 37]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_unary_bool_bad.txt gold/test_unary_bool_bad.gold && echo "[Test 38]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_print_array.txt gold/test_print_array.gold && echo "[Test 39]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_print_array_bad.txt gold/test_print_array_bad.gold && echo "[Test 39]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_read.txt gold/test_read.gold && echo "[Test 40]\t\tTest OK!") || echo "Test failed!"
	@(diff test_generated/test_read_bad.txt gold/test_read_bad.gold && echo "[Test 41]\t\tTest OK!") || echo "Test failed!"
