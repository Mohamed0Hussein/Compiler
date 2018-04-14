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
   
    //static String regex = "((?<=[\\*\\+-/=<();:={} ])|(?=[\\*\\+-/=<();:={} ]))";
    static String regex = "((?<=[\\*\\+-/<();{} ]|:=|=)|(?=[\\*\\+-/<();{} ]|:=|=))";
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
     for (int i =0; i<Stringtokens.length;i++)
        {
            Tokens .add(getToken(Stringtokens[i],Stringtokens ,i));

        }


    return Tokens;
   }
   public static Token getToken (String s,  String [] StringTokens,int i){
         Token token ;
       //if(!(s.equals(" "))){
     
       if (reservedWords.contains(s)){
           token = new Token(TokenTypes.ReservedWord, s);
       }
       else if(specialSymbols.contains(s)){
           if (s != "{"|| s!="}"){
               token = new Token(TokenTypes.Symbol, s);
           }
           else {
               String comment="{";
               while (StringTokens[i] != "}"){
                   
                   comment.concat(StringTokens[i]);
                   i++;
               }
               comment.concat("}");
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
      return ("Token: "+TokenType.toString()+"    Lexeme: "+Lexeme);
  }
}
