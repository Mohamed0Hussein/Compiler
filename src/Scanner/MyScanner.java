package Scanner;


public class MyScanner {

    public static void main(String[] args) {
        String S = "read x;\n" +
"if 0 < x then {this is a comment}\n" +
" fact := 1;\n" +
" repeat\n" +
" fact := fact * x;\n" +
" x := x - 1\n" +
" until x = 0;\n" +
" write fact\n" +
"end";
        Token.Tokenize(S);
      
    
    }
    
}
