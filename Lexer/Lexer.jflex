
        /*---- Codigo de Usuario ----*/


// Paquetes e importaciones

package com.peter.typesecure.lexer;
import java_cup.runtime.*;  
import com.peter.typesecure.parser.*;

/*---- Opciones y declaraciones ----*/

%%

%{
    //Codigo de usuario en sintaxis java
    String txt = "";

   
%}

//----------> Directivas


%class Lexer
%public
%cup
%unicode
%column
%line
%state COMENTARIO1
%state COMENTARIO2
%state TEXTOD
%state TEXTOS

// Declarar Expresiones regulares

    /* TEXTO */

comillaD = \" 
comillaS = \'

    /* ID'S */

id = ([a-zA-z]|"_")([a-zA-z]|{entero}|"_")+

    /* ESPACIOS */

WhiteSpace = [\r|\n|\r\n] | [ \t\f]

    /* NUMEROS */

entero = [0-9]+
decimal = ({entero})+(".")({entero})+ 
bigInt = {entero}"n"

    /* BOOLEANOS */
true = "true"
false = "false"

        /* PALABRAS RESERVADAS */

    /*TIPOS DE DATOS*/
Number = "number"
BigInt = "bigint"
String = "string"
Boolean = "boolean"
Void = "void"
Const = "const"
Let = "let"




// ESTADO INICIAL ES " YYNITIAL"

%%

/*---- Reglas Lexicas ----*/

<YYINITIAL> {WhiteSpace} {  }

<YYINITIAL> "//" { yybegin(COMENTARIO1); }

<COMENTARIO1>  [^\n] {  }

<COMENTARIO1> "\n"    { yybegin(YYINITIAL); }

<YYINITIAL> "/*" { yybegin(COMENTARIO2); }

<COMENTARIO2>  [^*/] {  }

<COMENTARIO2>  "*/" { yybegin(YYINITIAL); }

<YYINITIAL> {comillaD} { txt=""; yybegin(TEXTOD); }

<TEXTOD>  [^\"] { txt += yytext(); }

<TEXTOD>  {comillaD} { yybegin(YYINITIAL); return new Symbol(sym.TEXTO,yycolumn+1,yyline+1, txt); }

<YYINITIAL> {comillaS} { txt=""; yybegin(TEXTOS); }

<TEXTOS>  [^\'] { txt += yytext(); }

<TEXTOS>  {comillaS} { yybegin(YYINITIAL); return new Symbol(sym.TEXTO,yycolumn+1,yyline+1, txt); }

<YYINITIAL> {entero} { return new Symbol(sym.NUMBER,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {decimal} { return new Symbol(sym.NUMBER,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {bigInt} { return new Symbol(sym.BIGINT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {true} { return new Symbol(sym.TRUE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {false} { return new Symbol(sym.FALSE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {Number} { return new Symbol(sym.RNUMBER,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {BigInt} { return new Symbol(sym.RBIGINT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {String} { return new Symbol(sym.RSTRING,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {Boolean} { return new Symbol(sym.RBOOLEAN,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {Void}   { return new Symbol(sym.RVOID,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {Const} { return new Symbol(sym.RCONST,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {Let} { return new Symbol(sym.RLET,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "+" {return new Symbol(sym.MAS,yycolumn+1,yyline+1, yytext());}

<YYINITIAL> "-" { return new Symbol(sym.MENOS,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "*" { return new Symbol(sym.MULTIPLICACION,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "/" { return new Symbol(sym.DIVISION,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "%" { return new Symbol(sym.MOD,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "(" { return new Symbol(sym.PARENTESIS_ABIERTO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> ")" { return new Symbol(sym.PARENTESIS_CERRADO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "++" { return new Symbol(sym.INCREMENTO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "--" { return new Symbol(sym.DECREMENTO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "=" { return new Symbol(sym.ASIGNACION,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {id} {return new Symbol(sym.ID,yycolumn+1,yyline+1, yytext()); }


[^] { 
            System.out.println(" ******* ERROR LEXICO " + yytext() + " linea " + (yyline+1) + " columna "  + (yycolumn+1) + "  ********" );
            
    }

