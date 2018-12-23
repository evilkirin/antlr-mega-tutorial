package me.tomassetti.examples.sandy;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;

import org.junit.Test;

public final class SandyParserTest {

    public final SandyLexer lexerForCode(String code) throws IOException {
        return new SandyLexer((CharStream) (new ANTLRInputStream((Reader) (new StringReader(code)))));
    }


    public final SandyLexer lexerForResource(String resourceName) throws IOException {
        return new SandyLexer((CharStream) (new ANTLRInputStream(this.getClass().getResourceAsStream('/' + resourceName + ".sandy"))));
    }


    public final List tokens(SandyLexer lexer) {
        LinkedList tokens = new LinkedList();

        Token t;
        do {
            t = lexer.nextToken();
            switch (t.getType()) {
                case -1:
                    tokens.add("EOF");
                    break;
                default:
                    if (t.getType() != 2) {
                        tokens.add(lexer.getRuleNames()[t.getType() - 1]);
                    }
            }
        } while (t.getType() != -1);

        return (List) tokens;
    }


    public final SandyParser.SandyFileContext parse(SandyLexer lexer) {
        SandyParser.SandyFileContext var10000 = (new SandyParser((TokenStream) (new CommonTokenStream((TokenSource) lexer)))).sandyFile();
        return var10000;
    }


    public final SandyParser.SandyFileContext parseResource(String resourceName) throws IOException {
        SandyParser.SandyFileContext fileContext = (new SandyParser((TokenStream) (new CommonTokenStream((TokenSource) this.lexerForResource(resourceName))))).sandyFile();
        return fileContext;
    }
}

