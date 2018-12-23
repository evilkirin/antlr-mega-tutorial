package me.tomassetti.examples.sandy.ast;

import me.tomassetti.examples.sandy.SandyParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.Token.EOF;

public class AstUtils {
    public static final Position pos(int startLine, int startCol, int endLine, int endCol) {
        return new Position(new Point(startLine, startCol), new Point(endLine, endCol));
    }

    /**
     * fun StatementContext.toAst(considerPosition: Boolean = false) : Statement = when (this) {
     *     is VarDeclarationStatementContext -> VarDeclaration(varDeclaration().assignment().ID().text, varDeclaration().assignment().expression().toAst(considerPosition), toPosition(considerPosition))
     *     is AssignmentStatementContext -> Assignment(assignment().ID().text, assignment().expression().toAst(considerPosition), toPosition(considerPosition))
     *     is PrintStatementContext -> Print(print().expression().toAst(considerPosition), toPosition(considerPosition))
     *     else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
     * }
     * @param context
     * @return
     */
    static SandyFile toAst(SandyParser.SandyFileContext context, boolean consider) {
        return new SandyFile(context.line().stream()
                .map(l -> toAst(l.statement(), consider))
                .collect(Collectors.toList()), toPosition(context, consider));
    }

    private static Statement toAst(SandyParser.StatementContext statement, boolean consider) {
        if (statement instanceof SandyParser.VarDeclarationStatementContext) {
            SandyParser.VarDeclarationContext varDeclarationContext = ((SandyParser.VarDeclarationStatementContext) statement).varDeclaration();
            return new VarDeclaration(varDeclarationContext.assignment().ID().getText(), toAst(varDeclarationContext.assignment().expression(), consider),
                    toPosition(statement, consider));
        }

        if (statement instanceof SandyParser.AssignmentStatementContext) {
            SandyParser.AssignmentContext assignment = ((SandyParser.AssignmentStatementContext) statement).assignment();
            return new Assignment(assignment.ID().getText(), toAst(assignment.expression(), consider), toPosition(statement, consider));
        }

        if (statement instanceof SandyParser.PrintStatementContext) {
            return new Print(toAst(((SandyParser.PrintStatementContext) statement).print().expression(), consider), toPosition(statement, consider));
        }

        throw new UnsupportedOperationException(statement.getClass().getCanonicalName());
    }

    /**
     * fun  ExpressionContext.toAst(considerPosition: Boolean = false) : Expression = when (this) {
     *     is BinaryOperationContext -> toAst(considerPosition)
     *     is IntLiteralContext -> IntLit(text, toPosition(considerPosition))
     *     is DecimalLiteralContext -> DecLit(text, toPosition(considerPosition))
     *     is ParenExpressionContext -> expression().toAst(considerPosition)
     *     is VarReferenceContext -> VarReference(text, toPosition(considerPosition))
     *     is TypeConversionContext -> TypeConversion(expression().toAst(considerPosition), targetType.toAst(considerPosition), toPosition(considerPosition))
     *     else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
     * }
     * @param expression
     * @param consider
     * @return
     */
    private static Expression toAst(SandyParser.ExpressionContext expression, boolean consider) {
        if (expression instanceof SandyParser.BinaryOperationContext) {

        }

        if (expression instanceof SandyParser.IntLiteralContext) {

        }

        if (expression instanceof SandyParser.DecimalLiteralContext) {

        }

        if (expression instanceof SandyParser.ParenExpressionContext) {

        }

        if (expression instanceof SandyParser.VarReferenceContext) {

        }

        if (expression instanceof SandyParser.TypeConversionContext) {

        }

        throw new UnsupportedOperationException(expression.getClass().getCanonicalName());
    }

    /**
     * fun TypeContext.toAst(considerPosition: Boolean = false) : Type = when (this) {
     *     is IntegerContext -> IntType(toPosition(considerPosition))
     *     is DecimalContext -> DecimalType(toPosition(considerPosition))
     *     else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
     * }
     * @param type
     * @param consider
     * @return
     */
    private static Type toAst(SandyParser.TypeContext type, boolean consider) {
        if (type instanceof SandyParser.IntegerContext) {

        }

        if (type instanceof SandyParser.DecimalContext) {

        }

        throw new UnsupportedOperationException(type.getClass().getCanonicalName());
    }

    /**
     * fun  BinaryOperationContext.toAst(considerPosition: Boolean = false) : Expression = when (operator.text) {
     *     "+" -> SumExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
     *     "-" -> SubtractionExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
     *     "*" -> MultiplicationExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
     *     "/" -> DivisionExpression(left.toAst(considerPosition), right.toAst(considerPosition), toPosition(considerPosition))
     *     else -> throw UnsupportedOperationException(this.javaClass.canonicalName)
     * }
     * @param bo
     * @param consider
     * @return
     */
    private static BinaryExpression toAst(SandyParser.BinaryOperationContext bo, boolean consider) {
        switch (bo.getText()) {
            case "+":
                break;
            case "-":
                break;
            case "*":
                break;
            case "/":
                break;
        }

        throw new UnsupportedOperationException(bo.getClass().getCanonicalName());
    }


    /**
     * fun SandyFileContext.toAst(considerPosition: Boolean = false) : SandyFile = SandyFile(this.line().map { it.statement().toAst(considerPosition) }, toPosition(considerPosition))
     *
     * fun Token.startPoint() = Point(line, charPositionInLine)
     *
     * fun Token.endPoint() = Point(line, charPositionInLine + text.length)
     *
     * fun ParserRuleContext.toPosition(considerPosition: Boolean) : Position? {
     *     return if (considerPosition) Position(start.startPoint(), stop.endPoint()) else null
     * }
     * @param token
     * @return
     */
    static Point startPoint(Token token) {
        return new Point(token.getLine(), token.getCharPositionInLine());
    }

    static Point endPoint(Token token) {
        return new Point(token.getLine(), token.getCharPositionInLine() + token.getType() == EOF ? 0 : token.getText().length());
    }

    static Position toPosition(ParserRuleContext ctx, boolean consider) {
        if (consider) {
            return new Position(startPoint(ctx.start), endPoint(ctx.stop));
        }
        return null;
    }



}
