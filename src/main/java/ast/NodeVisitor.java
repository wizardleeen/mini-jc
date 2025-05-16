package ast;

public interface NodeVisitor<R> {

    R visitNode(Node node);

    R visitExpr(Expr expr);

    R visitCallExpr(CallExpr callExpr);

    R visitArrayTypeExpr(ArrayTypeExpr arrayTypeExpr);

    R visitBlock(Block block);

    R visitClassDecl(ClassDecl classDecl);

    R visitDecl(Decl decl);

    R visitExprStat(ExprStat exprStat);

    R visitFile(File file);

    R visitIdent(Ident ident);

    R visitLiteral(Literal literal);

    R visitMethodDecl(MethodDecl methodDecl);

    R visitParamDecl(ParamDecl paramDecl);

    R visitSelectorExpr(SelectorExpr selectorExpr);

    R visitStat(Stat stat);

    R visitTypeNode(TypeNode typeNode);
}
