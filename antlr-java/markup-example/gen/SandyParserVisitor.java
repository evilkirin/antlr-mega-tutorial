// Generated from /Users/zac-tse/Development/github/antlr-mega-tutorial/antlr-java/markup-example/src/main/antlr4/me/tomassetti/examples/sandy/SandyParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SandyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SandyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SandyParser#sandyFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSandyFile(SandyParser.SandyFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SandyParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(SandyParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclarationStatement}
	 * labeled alternative in {@link SandyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationStatement(SandyParser.VarDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStatement}
	 * labeled alternative in {@link SandyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(SandyParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link SandyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(SandyParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SandyParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SandyParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SandyParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(SandyParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SandyParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SandyParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(SandyParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpression}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpression(SandyParser.MinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(SandyParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(SandyParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperation}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(SandyParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeConversion}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConversion(SandyParser.TypeConversionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varReference}
	 * labeled alternative in {@link SandyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarReference(SandyParser.VarReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integer}
	 * labeled alternative in {@link SandyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(SandyParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimal}
	 * labeled alternative in {@link SandyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal(SandyParser.DecimalContext ctx);
}