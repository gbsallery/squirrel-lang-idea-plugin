package com.squirrelplugin;
import java.util.*;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.squirrelplugin.psi.SquirrelTypes.*;
import static com.squirrelplugin.SquirrelParserDefinition.*;
import com.intellij.psi.TokenType;

%%

%{
    public _SquirrelLexer() {
        this((java.io.Reader)null);
    }

    protected int myLeftParenCount;

    private static final class State {
        final int state;

        public State(int state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "yystate = " + state;
        }
    }

    protected final Stack<State> myStateStack = new Stack<State>();

    private void pushState(int state) {
        myStateStack.push(new State(yystate()));
        yybegin(state);
    }

    private void popState() {
        if (!myStateStack.empty()) {
            State state = myStateStack.pop();
            yybegin(state.state);
        }
    }
%}

%public
%class _SquirrelLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
  myLeftParenCount = 0;
  myStateStack.clear();
%eof}

LINE_COMMENT=("//"|#)[^\r\n]*
BLOCK_COMMENT="/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*(\*+"/")
IDENTIFIER=[a-zA-Z_]+[a-zA-Z_0-9]*
INT=((0[1-9][0-7]*)|(0x[0-9a-fA-F]*)|('[:letter:]')|(0|([1-9][0-9]*)))
FLOAT=((([0-9]+\.[0-9]*)|([0-9]*\.[0-9]+))([eE][+-]?[0-9]+)?)|([0-9]+([eE][+-]?[0-9]+))
STRING=(@\"([^\"]|\"\")*\"|\"(\\.|[^\"\n\r])*\")
NL=\r|\n|\r\n
WS=[ \t\f]
ANY=[ \t\f\r\na-zA-Z0-9_\-\.,+-*&\^%@!~|<>/\?:;\(\)\{\}\[\]]

%state MAYBE_NL_EXPRESSION, MAYBE_NL_EXPRESSION_CONFIRM, MAYBE_NL_TERMINAL_KEYWORD, INSIDE_IFELSE, RBRACE_SEMICOLON, STATEMENT_WITH_PARENTHESES, DO_STATEMENT, LBRACE_START

%%
<YYINITIAL, STATEMENT_WITH_PARENTHESES, DO_STATEMENT, LBRACE_START> {
  {WS}+                { return WS; }
  {NL}+                { return NL; }

  "}"                  { popState(); return RBRACE; }
  "]"                  { pushState(MAYBE_NL_EXPRESSION); return RBRACK; }
  ")"                  {

                        myLeftParenCount--;
                        if (myLeftParenCount == 0) {
                            if (yystate() == STATEMENT_WITH_PARENTHESES) {
                                popState();
                            } else {
                                pushState(MAYBE_NL_EXPRESSION);
                            }
                        }

                       return RPAREN;
                       }
  "++"                 { return INCREMENT; }
  "--"                 { return DECREMENT; }
  "{"                  { pushState(LBRACE_START); return LBRACE; }
  "["                  { return LBRACK; }
  "("                  { myLeftParenCount++; return LPAREN; }
  "::"                 { return DOUBLE_COLON; }
  ":"                  { return COLON; }
  ";"                  { if (yystate() == DO_STATEMENT) { popState(); } return SEMICOLON; }
  ","                  { return COMMA; }
  "..."                { return MULTI_ARGS; }
  "</"                 { return CLASS_ATTR_START; }
  "/>"                 { return CLASS_ATTR_END; }
  "<<"                 { return SHIFT_LEFT; }
  ">>"                 { return SHIFT_RIGHT; }
  ">>>"                { return UNSIGNED_SHIFT_RIGHT; }
  "<=>"                { return CMP; }
  "=="                 { return EQ; }
  "!="                 { return NOT_EQ; }
  "<="                 { return LESS_OR_EQUAL; }
  ">="                 { return GREATER_OR_EQUAL; }
  "<-"                 { return SEND_CHANNEL; }
  "+="                 { return PLUS_ASSIGN; }
  "-="                 { return MINUS_ASSIGN; }
  "*="                 { return MUL_ASSIGN; }
  "/="                 { return QUOTIENT_ASSIGN; }
  "%="                 { return REMAINDER_ASSIGN; }
  "||"                 { return COND_OR; }
  "&&"                 { return COND_AND; }
  "="                  { return ASSIGN; }
  "!"                  { return NOT; }
  "~"                  { return BIT_NOT; }
  "|"                  { return BIT_OR; }
  "^"                  { return BIT_XOR; }
  "&"                  { return BIT_AND; }
  "<"                  { return LESS; }
  ">"                  { return GREATER; }
  "+"                  { return PLUS; }
  "-"                  { return MINUS; }
  "*"                  { return MUL; }
  "/"                  { return QUOTIENT; }
  "%"                  { return REMAINDER; }
  "?"                  { return QUESTION; }
  "@"                  { return AT; }
  "."                  { return PERIOD; }
  "const"              { return CONST; }
  "enum"               { return ENUM; }
  "local"              { return LOCAL; }
  "function"           { pushState(STATEMENT_WITH_PARENTHESES); return FUNCTION; }
  "constructor"        { return CONSTRUCTOR; } // TODO: CAN ALSO BE A STATEMENT WITH PARENTHESES
  "class"              { return CLASS; }
  "extends"            { return EXTENDS; }
  "static"             { return STATIC; }
  "break"              { pushState(MAYBE_NL_TERMINAL_KEYWORD); return BREAK; }
  "continue"           { pushState(MAYBE_NL_TERMINAL_KEYWORD); return CONTINUE; }
  "return"             { pushState(MAYBE_NL_TERMINAL_KEYWORD); return RETURN; }
  "yield"              { pushState(MAYBE_NL_TERMINAL_KEYWORD); return YIELD; }
  "throw"              { return THROW; }
  "for"                { pushState(STATEMENT_WITH_PARENTHESES); return FOR; }
  "foreach"            { pushState(STATEMENT_WITH_PARENTHESES); return FOREACH; }
  "in"                 { return IN; }
  "while"              {

                        if (yystate() != DO_STATEMENT) {
                            pushState(STATEMENT_WITH_PARENTHESES);
                        }
                        else {
                            popState();
                        }
                        return WHILE;

                       }
  "do"                 { pushState(DO_STATEMENT); return DO; } // Should track DO state to place a virtual semicolon after while
  "if"                 { pushState(STATEMENT_WITH_PARENTHESES); return IF; }
  "else"               { return ELSE; }
  "switch"             { pushState(STATEMENT_WITH_PARENTHESES); return SWITCH; }
  "case"               { return CASE; }
  "default"            { return DEFAULT; }
  "try"                { return TRY; }
  "catch"              { return CATCH; }
  "typeof"             { return TYPEOF; }
  "clone"              { return CLONE; }
  "delete"             { return DELETE; }
  "resume"             { return RESUME; }
  "instanceof"         { return INSTANCEOF; }
  "true"               { return TRUE; }
  "false"              { return FALSE; }
  "null"               { return NULL; }

  {LINE_COMMENT}       { return LINE_COMMENT; }
  {BLOCK_COMMENT}      { return BLOCK_COMMENT; }
  {IDENTIFIER}         { pushState(MAYBE_NL_EXPRESSION); return IDENTIFIER; }
  {INT}                { pushState(MAYBE_NL_EXPRESSION); return INT; }
  {FLOAT}              { pushState(MAYBE_NL_EXPRESSION); return FLOAT; }
  {STRING}             { pushState(MAYBE_NL_EXPRESSION); return STRING; }

  [^] { return TokenType.BAD_CHARACTER; }
}

<RBRACE_SEMICOLON> {
{ANY}              { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
.                  { popState(); yypushback(yylength());  }
}


<MAYBE_NL_TERMINAL_KEYWORD> {
{WS}+              { return WS; }
{NL}+              { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
{LINE_COMMENT}     { return LINE_COMMENT; }
{BLOCK_COMMENT}    { return BLOCK_COMMENT; }

.                  { popState(); yypushback(yylength());  }
}

<MAYBE_NL_EXPRESSION> {
{WS}+              { return WS; }
{NL}+              { popState(); pushState(MAYBE_NL_EXPRESSION_CONFIRM); return NL; }
{LINE_COMMENT}     { return LINE_COMMENT; }
{BLOCK_COMMENT}    { return BLOCK_COMMENT; }

.                  { popState(); yypushback(yylength());  }
}
//
<MAYBE_NL_EXPRESSION_CONFIRM> {
{WS}+              { return WS; }
{NL}+              { return NL; }
{LINE_COMMENT}     { return LINE_COMMENT; }
{BLOCK_COMMENT}    { return BLOCK_COMMENT; }

"instanceof"       { popState(); yypushback(yylength()); }

"["                { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
"::"               { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
{IDENTIFIER}       { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
{INT}              { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
{FLOAT}            { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }
{STRING}           { popState(); yypushback(yylength()); return SEMICOLON_SYNTHETIC; }

.                  { popState(); yypushback(yylength()); }
}