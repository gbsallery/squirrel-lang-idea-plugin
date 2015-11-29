/* The following code was generated by JFlex 1.4.3 on 11/29/15 11:25 PM */

package com.squirrelplugin;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.squirrelplugin.psi.SquirrelTypes.*;
import static com.squirrelplugin.SquirrelParserDefinition.*;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11/29/15 11:25 PM from the specification file
 * <tt>SquirrelLexer.flex</tt>
 */
public class _SquirrelLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int MAYBE_SEMICOLON = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\25\1\24\1\0\1\25\1\3\22\0\1\25\1\42\1\22"+
    "\1\2\1\0\1\47\1\45\1\15\1\34\1\30\1\4\1\31\1\37"+
    "\1\20\1\16\1\1\1\10\7\12\2\11\1\35\1\36\1\41\1\40"+
    "\1\43\1\0\1\21\4\14\1\17\1\14\24\7\1\33\1\23\1\27"+
    "\1\46\1\6\1\0\1\56\1\14\1\50\1\14\1\64\1\57\2\7"+
    "\1\61\2\7\1\55\1\7\1\52\1\51\1\63\1\7\1\65\1\53"+
    "\1\54\1\60\2\7\1\13\1\62\1\7\1\32\1\44\1\26\54\0"+
    "\1\5\12\0\1\5\4\0\1\5\5\0\27\5\1\0\37\5\1\0"+
    "\u01ca\5\4\0\14\5\16\0\5\5\7\0\1\5\1\0\1\5\201\0"+
    "\5\5\1\0\2\5\2\0\4\5\10\0\1\5\1\0\3\5\1\0"+
    "\1\5\1\0\24\5\1\0\123\5\1\0\213\5\10\0\236\5\11\0"+
    "\46\5\2\0\1\5\7\0\47\5\110\0\33\5\5\0\3\5\55\0"+
    "\53\5\43\0\2\5\1\0\143\5\1\0\1\5\17\0\2\5\7\0"+
    "\2\5\12\0\3\5\2\0\1\5\20\0\1\5\1\0\36\5\35\0"+
    "\131\5\13\0\1\5\30\0\41\5\11\0\2\5\4\0\1\5\5\0"+
    "\26\5\4\0\1\5\11\0\1\5\3\0\1\5\27\0\31\5\107\0"+
    "\1\5\1\0\13\5\127\0\66\5\3\0\1\5\22\0\1\5\7\0"+
    "\12\5\17\0\7\5\1\0\7\5\5\0\10\5\2\0\2\5\2\0"+
    "\26\5\1\0\7\5\1\0\1\5\3\0\4\5\3\0\1\5\20\0"+
    "\1\5\15\0\2\5\1\0\3\5\16\0\2\5\23\0\6\5\4\0"+
    "\2\5\2\0\26\5\1\0\7\5\1\0\2\5\1\0\2\5\1\0"+
    "\2\5\37\0\4\5\1\0\1\5\23\0\3\5\20\0\11\5\1\0"+
    "\3\5\1\0\26\5\1\0\7\5\1\0\2\5\1\0\5\5\3\0"+
    "\1\5\22\0\1\5\17\0\2\5\43\0\10\5\2\0\2\5\2\0"+
    "\26\5\1\0\7\5\1\0\2\5\1\0\5\5\3\0\1\5\36\0"+
    "\2\5\1\0\3\5\17\0\1\5\21\0\1\5\1\0\6\5\3\0"+
    "\3\5\1\0\4\5\3\0\2\5\1\0\1\5\1\0\2\5\3\0"+
    "\2\5\3\0\3\5\3\0\14\5\26\0\1\5\64\0\10\5\1\0"+
    "\3\5\1\0\27\5\1\0\12\5\1\0\5\5\3\0\1\5\32\0"+
    "\2\5\6\0\2\5\43\0\10\5\1\0\3\5\1\0\27\5\1\0"+
    "\12\5\1\0\5\5\3\0\1\5\40\0\1\5\1\0\2\5\17\0"+
    "\2\5\22\0\10\5\1\0\3\5\1\0\51\5\2\0\1\5\20\0"+
    "\1\5\21\0\2\5\30\0\6\5\5\0\22\5\3\0\30\5\1\0"+
    "\11\5\1\0\1\5\2\0\7\5\72\0\60\5\1\0\2\5\14\0"+
    "\7\5\72\0\2\5\1\0\1\5\2\0\2\5\1\0\1\5\2\0"+
    "\1\5\6\0\4\5\1\0\7\5\1\0\3\5\1\0\1\5\1\0"+
    "\1\5\2\0\2\5\1\0\4\5\1\0\2\5\11\0\1\5\2\0"+
    "\5\5\1\0\1\5\25\0\4\5\40\0\1\5\77\0\10\5\1\0"+
    "\44\5\33\0\5\5\163\0\53\5\24\0\1\5\20\0\6\5\4\0"+
    "\4\5\3\0\1\5\3\0\2\5\7\0\3\5\4\0\15\5\14\0"+
    "\1\5\21\0\46\5\1\0\1\5\5\0\1\5\2\0\53\5\1\0"+
    "\u014d\5\1\0\4\5\2\0\7\5\1\0\1\5\1\0\4\5\2\0"+
    "\51\5\1\0\4\5\2\0\41\5\1\0\4\5\2\0\7\5\1\0"+
    "\1\5\1\0\4\5\2\0\17\5\1\0\71\5\1\0\4\5\2\0"+
    "\103\5\45\0\20\5\20\0\125\5\14\0\u026c\5\2\0\21\5\1\0"+
    "\32\5\5\0\113\5\25\0\15\5\1\0\4\5\16\0\22\5\16\0"+
    "\22\5\16\0\15\5\1\0\3\5\17\0\64\5\43\0\1\5\4\0"+
    "\1\5\103\0\130\5\10\0\51\5\1\0\1\5\5\0\106\5\12\0"+
    "\35\5\63\0\36\5\2\0\5\5\13\0\54\5\25\0\7\5\70\0"+
    "\27\5\11\0\65\5\122\0\1\5\135\0\57\5\21\0\7\5\67\0"+
    "\36\5\15\0\2\5\12\0\54\5\32\0\44\5\51\0\3\5\12\0"+
    "\44\5\153\0\4\5\1\0\4\5\3\0\2\5\11\0\300\5\100\0"+
    "\u0116\5\2\0\6\5\2\0\46\5\2\0\6\5\2\0\10\5\1\0"+
    "\1\5\1\0\1\5\1\0\1\5\1\0\37\5\2\0\65\5\1\0"+
    "\7\5\1\0\1\5\3\0\3\5\1\0\7\5\3\0\4\5\2\0"+
    "\6\5\4\0\15\5\5\0\3\5\1\0\7\5\164\0\1\5\15\0"+
    "\1\5\20\0\15\5\145\0\1\5\4\0\1\5\2\0\12\5\1\0"+
    "\1\5\3\0\5\5\6\0\1\5\1\0\1\5\1\0\1\5\1\0"+
    "\4\5\1\0\13\5\2\0\4\5\5\0\5\5\4\0\1\5\64\0"+
    "\2\5\u0a7b\0\57\5\1\0\57\5\1\0\205\5\6\0\4\5\3\0"+
    "\2\5\14\0\46\5\1\0\1\5\5\0\1\5\2\0\70\5\7\0"+
    "\1\5\20\0\27\5\11\0\7\5\1\0\7\5\1\0\7\5\1\0"+
    "\7\5\1\0\7\5\1\0\7\5\1\0\7\5\1\0\7\5\120\0"+
    "\1\5\u01d5\0\2\5\52\0\5\5\5\0\2\5\4\0\126\5\6\0"+
    "\3\5\1\0\132\5\1\0\4\5\5\0\51\5\3\0\136\5\21\0"+
    "\33\5\65\0\20\5\u0200\0\u19b6\5\112\0\u51cd\5\63\0\u048d\5\103\0"+
    "\56\5\2\0\u010d\5\3\0\20\5\12\0\2\5\24\0\57\5\20\0"+
    "\31\5\10\0\106\5\61\0\11\5\2\0\147\5\2\0\4\5\1\0"+
    "\4\5\14\0\13\5\115\0\12\5\1\0\3\5\1\0\4\5\1\0"+
    "\27\5\35\0\64\5\16\0\62\5\76\0\6\5\3\0\1\5\16\0"+
    "\34\5\12\0\27\5\31\0\35\5\7\0\57\5\34\0\1\5\60\0"+
    "\51\5\27\0\3\5\1\0\10\5\24\0\27\5\3\0\1\5\5\0"+
    "\60\5\1\0\1\5\3\0\2\5\2\0\5\5\2\0\1\5\1\0"+
    "\1\5\30\0\3\5\2\0\13\5\7\0\3\5\14\0\6\5\2\0"+
    "\6\5\2\0\6\5\11\0\7\5\1\0\7\5\221\0\43\5\35\0"+
    "\u2ba4\5\14\0\27\5\4\0\61\5\u2104\0\u016e\5\2\0\152\5\46\0"+
    "\7\5\14\0\5\5\5\0\1\5\1\0\12\5\1\0\15\5\1\0"+
    "\5\5\1\0\1\5\1\0\2\5\1\0\2\5\1\0\154\5\41\0"+
    "\u016b\5\22\0\100\5\2\0\66\5\50\0\14\5\164\0\5\5\1\0"+
    "\207\5\44\0\32\5\6\0\32\5\13\0\131\5\3\0\6\5\2\0"+
    "\6\5\2\0\6\5\2\0\3\5\43\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\2\7"+
    "\2\1\1\10\2\1\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\6\6\2\34"+
    "\2\35\2\0\2\7\1\36\2\0\1\37\1\40\2\0"+
    "\1\41\1\0\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\7\6\1\56"+
    "\1\0\1\36\1\0\1\7\2\41\1\57\1\60\7\6"+
    "\1\61\1\6\1\62\1\6\1\63\3\6\1\64\1\6"+
    "\1\65\1\66\1\6\1\67\2\6\1\70";

  private static int [] zzUnpackAction() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\242\0\330\0\u010e\0\154\0\u0144"+
    "\0\u017a\0\u01b0\0\u01e6\0\u021c\0\u0252\0\u0288\0\u02be\0\154"+
    "\0\154\0\154\0\154\0\u02f4\0\154\0\154\0\154\0\u032a"+
    "\0\154\0\154\0\u0360\0\u0396\0\u03cc\0\u0402\0\u0438\0\u046e"+
    "\0\154\0\154\0\u04a4\0\u04da\0\u0510\0\u0546\0\u057c\0\u05b2"+
    "\0\154\0\242\0\u05e8\0\154\0\u061e\0\u0654\0\u068a\0\u06c0"+
    "\0\u06f6\0\u072c\0\u0762\0\154\0\154\0\u0798\0\u02be\0\154"+
    "\0\u07ce\0\154\0\154\0\154\0\154\0\154\0\u0804\0\154"+
    "\0\154\0\154\0\u083a\0\154\0\154\0\u0870\0\u08a6\0\u08dc"+
    "\0\u0912\0\u0948\0\u097e\0\u09b4\0\u0144\0\u09ea\0\u0a20\0\u0a20"+
    "\0\154\0\u0288\0\u02be\0\154\0\154\0\u0a56\0\u0a8c\0\u0ac2"+
    "\0\u0af8\0\u0b2e\0\u0b64\0\u0b9a\0\154\0\u0bd0\0\u0144\0\u0c06"+
    "\0\u0144\0\u0c3c\0\u0c72\0\u0ca8\0\u0144\0\u0cde\0\u0144\0\u0144"+
    "\0\u0d14\0\u0144\0\u0d4a\0\u0d80\0\u0144";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\3\1\10"+
    "\1\11\2\12\2\10\1\13\1\14\1\10\1\15\1\16"+
    "\1\17\1\3\1\6\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\10"+
    "\1\44\1\10\1\45\1\46\1\10\1\47\1\10\1\50"+
    "\4\10\1\51\1\52\1\5\1\53\20\51\1\54\1\20"+
    "\40\51\67\0\1\5\2\0\1\55\61\0\3\5\1\0"+
    "\20\5\1\0\41\5\3\0\1\6\20\0\1\6\47\0"+
    "\7\10\2\0\1\10\30\0\16\10\10\0\1\56\2\57"+
    "\1\60\2\0\1\61\1\62\44\0\1\62\11\0\3\12"+
    "\3\0\1\61\1\62\44\0\1\62\6\0\1\63\1\0"+
    "\1\63\3\0\2\63\2\0\1\63\30\0\16\63\10\0"+
    "\3\61\73\0\1\64\17\0\1\65\47\0\1\66\43\0"+
    "\3\67\1\0\16\67\1\70\1\71\1\0\41\67\31\0"+
    "\1\72\6\0\1\73\62\0\1\74\70\0\1\75\45\0"+
    "\1\76\17\0\1\77\1\100\64\0\1\101\65\0\1\102"+
    "\2\0\1\103\66\0\1\104\66\0\1\105\26\0\7\10"+
    "\2\0\1\10\30\0\1\10\1\106\14\10\6\0\7\10"+
    "\2\0\1\10\30\0\10\10\1\107\5\10\6\0\7\10"+
    "\2\0\1\10\30\0\12\10\1\110\2\10\1\111\6\0"+
    "\7\10\2\0\1\10\30\0\1\10\1\112\14\10\6\0"+
    "\7\10\2\0\1\10\30\0\6\10\1\113\1\10\1\114"+
    "\5\10\6\0\7\10\2\0\1\10\30\0\2\10\1\115"+
    "\13\10\24\0\1\54\41\0\4\55\1\116\61\55\10\0"+
    "\3\56\3\0\1\61\1\62\44\0\1\62\11\0\1\57"+
    "\1\56\1\57\3\0\1\61\1\62\44\0\1\62\11\0"+
    "\3\60\1\0\1\60\2\0\1\60\30\0\1\60\5\0"+
    "\2\60\4\0\1\60\11\0\3\61\4\0\1\62\44\0"+
    "\1\62\11\0\3\117\5\0\1\120\10\0\1\120\51\0"+
    "\1\121\50\0\22\66\1\122\43\66\22\67\1\123\1\71"+
    "\1\0\41\67\43\0\1\124\65\0\1\125\30\0\7\10"+
    "\2\0\1\10\30\0\2\10\1\126\13\10\6\0\7\10"+
    "\2\0\1\10\30\0\5\10\1\127\10\10\6\0\7\10"+
    "\2\0\1\10\30\0\13\10\1\130\2\10\6\0\7\10"+
    "\2\0\1\10\30\0\10\10\1\131\5\10\6\0\7\10"+
    "\2\0\1\10\30\0\1\132\15\10\6\0\7\10\2\0"+
    "\1\10\30\0\5\10\1\133\10\10\6\0\7\10\2\0"+
    "\1\10\30\0\2\10\1\134\13\10\1\55\1\135\2\55"+
    "\1\116\61\55\10\0\3\117\61\0\7\10\2\0\1\10"+
    "\30\0\3\10\1\136\12\10\6\0\7\10\2\0\1\10"+
    "\30\0\5\10\1\137\10\10\6\0\7\10\2\0\1\10"+
    "\30\0\14\10\1\140\1\10\6\0\7\10\2\0\1\10"+
    "\30\0\14\10\1\141\1\10\6\0\7\10\2\0\1\10"+
    "\30\0\6\10\1\142\7\10\6\0\7\10\2\0\1\10"+
    "\30\0\3\10\1\143\12\10\6\0\7\10\2\0\1\10"+
    "\30\0\1\144\15\10\6\0\7\10\2\0\1\10\30\0"+
    "\4\10\1\145\11\10\6\0\7\10\2\0\1\10\30\0"+
    "\1\10\1\146\14\10\6\0\7\10\2\0\1\10\30\0"+
    "\5\10\1\147\10\10\6\0\7\10\2\0\1\10\30\0"+
    "\14\10\1\150\1\10\6\0\7\10\2\0\1\10\30\0"+
    "\4\10\1\151\11\10\6\0\7\10\2\0\1\10\30\0"+
    "\7\10\1\152\6\10\6\0\7\10\2\0\1\10\30\0"+
    "\11\10\1\153\4\10\6\0\7\10\2\0\1\10\30\0"+
    "\1\10\1\154\14\10\6\0\7\10\2\0\1\10\30\0"+
    "\2\10\1\155\13\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3510];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\3\1\1\11\10\1\4\11\1\1\3\11"+
    "\1\1\2\11\6\1\2\11\6\1\1\11\2\1\1\11"+
    "\2\0\3\1\2\0\2\11\2\0\1\11\1\0\5\11"+
    "\1\1\3\11\1\1\2\11\10\1\1\0\1\1\1\0"+
    "\1\11\2\1\2\11\7\1\1\11\20\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[109];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  public _SquirrelLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _SquirrelLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 1612) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { return QUOTIENT;
          }
        case 57: break;
        case 56: 
          { return FUNCTION;
          }
        case 58: break;
        case 39: 
          { return LESS_OR_EQUAL;
          }
        case 59: break;
        case 38: 
          { return SEND_CHANNEL;
          }
        case 60: break;
        case 28: 
          { yybegin(YYINITIAL); yypushback(yytext().length());
          }
        case 61: break;
        case 18: 
          { return SEMICOLON;
          }
        case 62: break;
        case 30: 
          { yybegin(MAYBE_SEMICOLON); return FLOAT;
          }
        case 63: break;
        case 4: 
          { return NLS;
          }
        case 64: break;
        case 14: 
          { return LBRACE;
          }
        case 65: break;
        case 15: 
          { return LBRACK;
          }
        case 66: break;
        case 33: 
          { yybegin(MAYBE_SEMICOLON); return STRING;
          }
        case 67: break;
        case 29: 
          { yybegin(YYINITIAL); yypushback(yytext().length()); return SEMICOLON_SYNTHETIC;
          }
        case 68: break;
        case 9: 
          { return TokenType.WHITE_SPACE;
          }
        case 69: break;
        case 12: 
          { yybegin(MAYBE_SEMICOLON); return RPAREN;
          }
        case 70: break;
        case 26: 
          { return BIT_XOR;
          }
        case 71: break;
        case 54: 
          { return FALSE;
          }
        case 72: break;
        case 19: 
          { return COMMA;
          }
        case 73: break;
        case 43: 
          { return SHIFT_RIGHT;
          }
        case 74: break;
        case 21: 
          { return LESS;
          }
        case 75: break;
        case 34: 
          { yybegin(MAYBE_SEMICOLON); return PLUS_PLUS;
          }
        case 76: break;
        case 46: 
          { return IN;
          }
        case 77: break;
        case 31: 
          { yybegin(MAYBE_SEMICOLON); return MINUS_MINUS;
          }
        case 78: break;
        case 40: 
          { return SHIFT_LEFT;
          }
        case 79: break;
        case 17: 
          { return COLON;
          }
        case 80: break;
        case 7: 
          { yybegin(MAYBE_SEMICOLON); return INT;
          }
        case 81: break;
        case 50: 
          { return NULL;
          }
        case 82: break;
        case 22: 
          { return NOT;
          }
        case 83: break;
        case 49: 
          { return BLOCK_COMMENT;
          }
        case 84: break;
        case 47: 
          { return CMP;
          }
        case 85: break;
        case 41: 
          { return NOT_EQ;
          }
        case 86: break;
        case 25: 
          { return BIT_AND;
          }
        case 87: break;
        case 20: 
          { return ASSIGN;
          }
        case 88: break;
        case 55: 
          { return TYPEOF;
          }
        case 89: break;
        case 48: 
          { return UNSIGNED_SHIFT_RIGHT;
          }
        case 90: break;
        case 44: 
          { return COND_OR;
          }
        case 91: break;
        case 32: 
          { return MINUS_ASSIGN;
          }
        case 92: break;
        case 10: 
          { yybegin(MAYBE_SEMICOLON); return RBRACE;
          }
        case 93: break;
        case 3: 
          { return LINE_COMMENT;
          }
        case 94: break;
        case 11: 
          { yybegin(MAYBE_SEMICOLON); return RBRACK;
          }
        case 95: break;
        case 1: 
          { return TokenType.BAD_CHARACTER;
          }
        case 96: break;
        case 42: 
          { return GREATER_OR_EQUAL;
          }
        case 97: break;
        case 53: 
          { return LOCAL;
          }
        case 98: break;
        case 23: 
          { return GREATER;
          }
        case 99: break;
        case 6: 
          { yybegin(MAYBE_SEMICOLON); return IDENTIFIER;
          }
        case 100: break;
        case 8: 
          { return MINUS;
          }
        case 101: break;
        case 36: 
          { return DOUBLE_COLON;
          }
        case 102: break;
        case 27: 
          { return REMAINDER;
          }
        case 103: break;
        case 51: 
          { return TRUE;
          }
        case 104: break;
        case 16: 
          { return LPAREN;
          }
        case 105: break;
        case 52: 
          { return CONST;
          }
        case 106: break;
        case 37: 
          { return EQ;
          }
        case 107: break;
        case 24: 
          { return BIT_OR;
          }
        case 108: break;
        case 45: 
          { return COND_AND;
          }
        case 109: break;
        case 13: 
          { return PLUS;
          }
        case 110: break;
        case 5: 
          { return MUL;
          }
        case 111: break;
        case 35: 
          { return PLUS_ASSIGN;
          }
        case 112: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}