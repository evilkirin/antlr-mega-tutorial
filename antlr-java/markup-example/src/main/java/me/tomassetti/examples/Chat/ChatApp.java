package me.tomassetti.examples.Chat;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ChatApp {

    public static class DefaultChatListner extends ChatBaseListener {

    }

    public static void main(String[] args) {
        String input = "john SHOUTS: hello @michael /pink/this will work/ :-) n";

        CharStream stream = CharStreams.fromString(input);
        ChatLexer lexer = new ChatLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ChatParser parser = new ChatParser(tokens);
        parser.setBuildParseTree(true);

        ChatParser.ChatContext chat = parser.chat();
        ParseTreeWalker walker = new ParseTreeWalker();
        DefaultChatListner listener = new DefaultChatListner();
        walker.walk(listener, chat);
    }
}
