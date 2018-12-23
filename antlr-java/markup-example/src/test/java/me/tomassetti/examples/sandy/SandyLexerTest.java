package me.tomassetti.examples.sandy;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.junit.Assert;
import org.junit.Test;


public final class SandyLexerTest {

    public final SandyLexer lexerForCode(String code) throws IOException {
        return new SandyLexer((CharStream)(new ANTLRInputStream((Reader)(new StringReader(code)))));
    }


    public final List<String> tokens(SandyLexer lexer) {
        LinkedList<String> tokens = new LinkedList<>();

        Token t;
        do {
            t = lexer.nextToken();
            switch(t.getType()) {
                case -1:
                    tokens.add("EOF");
                    break;
                default:
                    if (t.getType() != 2) {
                        tokens.add(SandyLexer.VOCABULARY.getSymbolicName(t.getType()));
                    }
            }
        } while(t.getType() != -1);

        return tokens;
    }

    @Test
    public final void parseVarDeclarationAssignedAnIntegerLiteral() throws IOException {
        Assert.assertEquals(Arrays.asList("VAR", "ID", "ASSIGN", "INTLIT", "EOF"), tokens(lexerForCode("var a = 1")));
    }

    @Test
    public final void parseVarDeclarationAssignedADecimalLiteral() throws IOException {
        Assert.assertEquals(Arrays.asList("VAR", "ID", "ASSIGN", "DECLIT", "EOF"), tokens(lexerForCode("var a = 1.23")));
    }

    @Test
    public final void parseVarDeclarationAssignedASum() throws IOException {
        Assert.assertEquals(Arrays.asList("VAR", "ID", "ASSIGN", "INTLIT", "PLUS", "INTLIT", "EOF"), tokens(lexerForCode("var a = 1 + 2")));
    }

    @Test
    public final void parseMathematicalExpression() throws IOException {
        Assert.assertEquals(Arrays.asList("INTLIT", "PLUS", "ID", "ASTERISK", "INTLIT", "DIVISION", "INTLIT", "MINUS", "INTLIT", "EOF"),
                tokens(lexerForCode("1 + a * 3 / 4 - 5")));
    }

    @Test
    public final void parseMathematicalExpressionWithParenthesis() throws IOException {
        Assert.assertEquals(Arrays.asList("INTLIT", "PLUS", "LPAREN", "ID", "ASTERISK", "INTLIT", "RPAREN", "MINUS", "DECLIT", "EOF"),
                tokens(lexerForCode("1 + (a * 3) - 5.12")));
    }

    @Test
    public final void parseCast() throws IOException {
        Assert.assertEquals(Arrays.asList("ID", "ASSIGN", "ID", "AS", "INT", "EOF"), tokens(lexerForCode("a = b as Int")));
    }
}
