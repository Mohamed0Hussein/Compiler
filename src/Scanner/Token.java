/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

import java.util.ArrayList;

/**
 *
 * @author eslam
 */
public class Token {
    static enum TokenTypes {
    ID, Symbol , ReservedWord, Number, Comment
}
    static String reservedWords = "ifthenelseendrepeatuntilreadwrite";
    static String specialSymbols = "+-*/=<();:={}";
    static int i = 0;
    static String regex = "((?<=[\\*\\+-/=<();:={}\n ])|(?=[\\*\\+-/=<();:={}\n ]))";
    //static String regex = "((?<=[\\*\\+-/<();{}\n ]|:=|=)|(?=[\\*\\+-/<();{}\n ]|:=|=))";
   // static String regex = "(?<=\\*|\\+|-|/|<|(|)|;|{|}|\n| |:=|=)|(?=\\*|\\+|-|/|<|(|)|;|{|}|\n| |:=|=)";

    private TokenTypes TokenType;
    String Lexeme  ;

    public Token(TokenTypes TokenType, String Lexeme) {
        this.TokenType = TokenType;
        this.Lexeme = Lexeme;
    }
    
   public static ArrayList<Token> Tokenize(String S)
   {
     String [] Stringtokens =  S.split(regex);
     //Stringtokens =  S.split(regex);
     ArrayList Tokens = new ArrayList<Token>();
   
     for ( i =0; i<Stringtokens.length;i++)
        {
            //if (!(Stringtokens[i].contains(" ")||(Stringtokens[i].equals("\n"))))
            if (!(Stringtokens[i].trim().equals("")))
            {
            if(Stringtokens[i].trim().equals(":") &&Stringtokens[i+1].trim().equals("=") ) {Tokens .add(getToken(":=",Stringtokens ));i++;}
            else  Tokens .add(getToken(Stringtokens[i].trim(),Stringtokens ));
           
        }
        }

    return Tokens;
   }
   public static Token getToken (String s,  String [] StringTokens){
         Token token ;
       //if(!(s.equals(" "))){
     
       if (reservedWords.contains(s)){
           token = new Token(TokenTypes.ReservedWord, s);
       }
       else if(specialSymbols.contains(s)){
           if (!s .equals("{") || s .equals("}")){
               token = new Token(TokenTypes.Symbol, s);
           }
           else {
               String comment="{";
               while (!StringTokens[i].equals("}")){
                   i++;
                   comment = comment.concat(StringTokens[i]);
                 // System.out.println(comment );
                   
               }
               
               i++;
               token = new Token(TokenTypes.Comment,comment);
           }
           
       }
       else if (isNumeric(s)) {
           token =  new Token(TokenTypes.Number,s); 
       
   }
       else token =  new Token(TokenTypes.ID,s);
   

  // }
       return token;
   }
  public static boolean isNumeric(String s)  
{  
  try  
  {  
    int x = Integer.parseInt(s);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;
}   
  public String toString()
  {
      return ("Token: "+TokenType.toString()+"       Lexeme: "+Lexeme);
  }
}
