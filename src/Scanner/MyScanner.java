package Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyScanner {

public static void main(String[] args) {
         try {
            // FileReader file = new FileReader(MyScanner.class.getResource("Input.txt").toString());
            // FileReader file = new FileReader(("D:\\GitHub\\Compiler\\src\\Scanner\\InputFile.txt"));
           FileReader file = new FileReader(("InputFile.txt"));
             BufferedReader input = new BufferedReader(file);
          /*  String S = "read x;\n"
                    + "if 0 < x then {this is a comment}\n"
                    + " fact := 1;\n"
                    + " repeat\n"
                    + " fact := fact * x;\n"
                    + " x := x - 1\n"
                    + " until x = 0;\n"
                    + " write fact\n"
                    + "end";*/
           String S = "";
            
           while(true){
            
            try{
             S = S.concat(input.readLine());
            }
            catch (NullPointerException ex){
                break;
            }
             
         }
             ArrayList<Token> tokens = Token.Tokenize(S);
             for (int i = 0; i < tokens.size(); i++) {
                 System.out.println(tokens.get(i));
             }

         } catch (FileNotFoundException ex) {
             Logger.getLogger(MyScanner.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(MyScanner.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
}
