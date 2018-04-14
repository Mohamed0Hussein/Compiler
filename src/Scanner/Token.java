/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

/**
 *
 * @author eslam
 */
public class Token {
    static enum TokenTypes {
    ID, Symbol , ReservedWord, Number, Comment
}
    static String reservedWords = "if then else end repeat until read write";
    //static String specialSymbols = "\\+|-|\\*|/|=|<|(|)|;|:=|";
    //static String specialSymbols = "[\\*\\+-/=<();:= ]";
    static String specialSymbols = "((?<=[\\*\\+-/=<();:={} ])|(?=[\\*\\+-/=<();:={} ]))";

    private TokenTypes TokenType;
    String Lexeme  ;
    public Token() {
        
    }
   public static String [] Tokenize(String S)
   {
     String [] tokens =  S.split(specialSymbols);
     for (int i =0; i<tokens.length;i++)
{
    System.out.println( tokens[i]);
}

     return tokens;
   }
   
    
}
