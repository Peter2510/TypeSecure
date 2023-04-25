
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

id = ([a-zA-z]|"_")([a-zA-z]|{entero}|"_")*

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

    /* TIPOS DE DATOS */
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

<YYINITIAL> "&&" { return new Symbol(sym.AND,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "||" { return new Symbol(sym.OR,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "!" { return new Symbol(sym.NOT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "<" { return new Symbol(sym.MENOR_QUE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "<=" { return new Symbol(sym.MENOR_IGUAL,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> ">" { return new Symbol(sym.MAYOR_QUE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> ">=" { return new Symbol(sym.MAYOR_IGUAL,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "==" { return new Symbol(sym.COMPARACION,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "!=" { return new Symbol(sym.DISTINTO,yycolumn+1,yyline+1, yytext()); }

    /* SIMBOLOS DE PUNTUACION*/

<YYINITIAL> "." { return new Symbol(sym.PUNTO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "," { return new Symbol(sym.COMA,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> ":" { return new Symbol(sym.DOS_PUNTOS,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> ";" { return new Symbol(sym.PUNTO_COMA,yycolumn+1,yyline+1, yytext()); }

    /* SIMBOLOS AGRUPACION */

<YYINITIAL> "{" { return new Symbol(sym.CORCHETE_ABIERTO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "}" { return new Symbol(sym.CORCHETE_CERRADO,yycolumn+1,yyline+1, yytext()); }

    /* PALABRAS RESERVADAS PARA FUNCIONES */

<YYINITIAL> "function" { return new Symbol(sym.FUNCTION,yycolumn+1,yyline+1, yytext()); }    

<YYINITIAL> "Number" { return new Symbol(sym.FNUMBER,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "BigInt" { return new Symbol(sym.FBIGINT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "Boolean" { return new Symbol(sym.FBOOLEAN,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "String" { return new Symbol(sym.FSTRING,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "length" { return new Symbol(sym.LENGTH,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "charAt" { return new Symbol(sym.CHARAT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "toLowerCase" { return new Symbol(sym.TOLOWERCASE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "toUpperCase" { return new Symbol(sym.TOUPPERCASE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "concat" { return new Symbol(sym.CONCAT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "console" { return new Symbol(sym.CONSOLE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "log" { return new Symbol(sym.LOG,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "if" { return new Symbol(sym.IF,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "else" { return new Symbol(sym.ELSE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "for" { return new Symbol(sym.FOR,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "while" { return new Symbol(sym.WHILE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "do" { return new Symbol(sym.DO,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "break" { return new Symbol(sym.BREAK,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "continue" { return new Symbol(sym.CONTINUE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "return" { return new Symbol(sym.RETURN,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "Math" { return new Symbol(sym.MATH,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "E" { return new Symbol(sym.E,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "PI" { return new Symbol(sym.PI,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "SQRT2" { return new Symbol(sym.SQRT2,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "abs" { return new Symbol(sym.ABS,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "ceil" { return new Symbol(sym.CEIL,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "cos" { return new Symbol(sym.COS,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "sin" { return new Symbol(sym.SIN,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "tan" { return new Symbol(sym.TAN,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "exp" { return new Symbol(sym.EXP,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "floor" { return new Symbol(sym.FLOOR,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "pow" { return new Symbol(sym.POW,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "sqrt" { return new Symbol(sym.SQRT,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "random" { return new Symbol(sym.RANDOM,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "printAst" { return new Symbol(sym.PRINTAST,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> "getSymbolTable" { return new Symbol(sym.GETSYMBOLTABLE,yycolumn+1,yyline+1, yytext()); }

<YYINITIAL> {id} {return new Symbol(sym.ID,yycolumn+1,yyline+1, yytext()); }


[^] { 
            System.out.println(" ******* ERROR LEXICO " + yytext() + " linea " + (yyline+1) + " columna "  + (yycolumn+1) + "  ********" );
            
    }

