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
        ID, Symbol, ReservedWord, Number, Comment, Error
    }
    static String reservedWords = "if then else end repeat until read write";
    static String[] reservedWordsArray = reservedWords.split(" ");
    static String specialSymbols = "+-*/=<();:={}";
    static int i = 0;
    static String regex = "((?<=[\\*\\+-/=<();:={}\n\t ])|(?=[\\*\\+-/=<();:={}\n\t ]))";

    private TokenTypes TokenType;
    String Lexeme;
    String ErrorDescription;

    public Token(TokenTypes TokenType, String Lexeme) {
        this.TokenType = TokenType;
        this.Lexeme = Lexeme;
    }

    public Token(TokenTypes TokenType, String Lexeme, String ErrorDescription) {
        this.TokenType = TokenType;
        this.Lexeme = Lexeme;
        this.ErrorDescription = ErrorDescription;
    }

    public static ArrayList<Token> Tokenize(String S) {
        String[] Stringtokens = S.split(regex);
        //Stringtokens =  S.split(regex);
        ArrayList Tokens = new ArrayList<Token>();

       /* for (i = 0; i < Stringtokens.length; i++) {
            System.out.println(Stringtokens[i]);
        }*/
        for (i = 0; i < Stringtokens.length; i++) {
        
            if (!(Stringtokens[i].trim().equals(""))) {
                if (!(Stringtokens[i].trim().equals("{"))) {

                    if (Stringtokens[i].trim().equals(":") && Stringtokens[i + 1].trim().equals("=")) {
                        Tokens.add(getToken(":=", Stringtokens));
                        i++;
                    } else {
                        Tokens.add(getToken(Stringtokens[i].trim(), Stringtokens));
                    }
                } else {
                    //System.out.println("Here");
                    //System.out.println(Stringtokens[i]);
                    Tokens.add(getToken(Stringtokens[i], Stringtokens));
                }

            }
        }

        return Tokens;
    }

    public static Token getToken(String s, String[] StringTokens) {
        Token token;
        //if(!(s.equals(" "))){
        boolean isResrved = false;
        for (int i = 0; i < reservedWordsArray.length; i++) {
            if (s.equals(reservedWordsArray[i])) {
                isResrved = true;
                break;
            }
        }

        if (isResrved) {
            token = new Token(TokenTypes.ReservedWord, s);
        } else if (specialSymbols.contains(s)) {
            if (s.equals(":")) {
                token = new Token(TokenTypes.Error, s, "Error: Invailed Token");
            } else {

                if (!s.equals("{")) {
                    token = new Token(TokenTypes.Symbol, s);
                } else {
                    //OLD
                    int temp = i;
                    String comment = "{";
                    boolean inLine = true;
                    while (!StringTokens[i].equals("}")) {
                        i++;
                        comment = comment.concat(StringTokens[i]);
                        if (StringTokens[i].contains("\n")) {
                            inLine = false;
                            break;
                        }

        
                    }

                
                    if (inLine) {
                        token = new Token(TokenTypes.Comment, comment);
                    } else {
                        token = new Token(TokenTypes.Error, comment, "Error: Invailed comment, Contains new line without closing bracket");
                    }
                    
                }
            }
        } else if (isNumeric(s)) {
            token = new Token(TokenTypes.Number, s);

        } else {
            boolean error = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
                    error = true;
                    break;
                }

            }
            if (!error) {
                token = new Token(TokenTypes.ID, s);
            } else {
                token = new Token(TokenTypes.Error, s, "Error: Invailed Token");
            }
        }

        // }
        return token;
    }

    public static boolean isNumeric(String s) {
        try {
            int x = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String toString() {
        String s;
        if (!(TokenType == TokenType.ReservedWord || TokenType == TokenType.Error)) {
            s = "Token: " + TokenType.toString();
            for (int i = 0; i < ("Reserved Word").length() - TokenType.toString().length(); i++) {
                s = s.concat(" ");
            }

            //return ("Token: " + TokenType.toString() + "       Lexeme: " + Lexeme);
            return (s + "       Lexeme: " + Lexeme);
        } else if (TokenType == TokenType.ReservedWord) {
            return ("Token: " + "Reserved Word" + "       Lexeme: " + Lexeme);
        } else {
            s = "Token: " + TokenType.toString();
            for (int i = 0; i < ("Reserved Word").length() - TokenType.toString().length(); i++) {
                s = s.concat(" ");
            }
            return (s + "       Lexeme: " + Lexeme + "    " + this.ErrorDescription);
        }
    }
}
