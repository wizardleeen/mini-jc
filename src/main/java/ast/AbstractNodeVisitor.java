package ast;

public abstract class AbstractNodeVisitor<R> implements NodeVisitor<R> {

    @Override
    public R visitExpr(Expr expr) {
        return visitNode(expr);
    }

    @Override
    public R visitCallExpr(CallExpr callExpr) {
        return visitExpr(callExpr);
    }

    @Override
    public R visitArrayTypeExpr(ArrayTypeExpr arrayTypeExpr) {
        return visitExpr(arrayTypeExpr);
    }

    @Override
    public R visitBlock(Block block) {
        return visitNode(block);
    }

    @Override
    public R visitClassDecl(ClassDecl classDecl) {
        return visitDecl(classDecl);
    }

    @Override
    public R visitDecl(Decl decl) {
        return visitNode(decl);
    }

    @Override
    public R visitExprStat(ExprStat exprStat) {
        return visitStat(exprStat);
    }

    @Override
    public R visitFile(File file) {
        return visitNode(file);
    }

    @Override
    public R visitIdent(Ident ident) {
        return visitExpr(ident);
    }

    @Override
    public R visitLiteral(Literal literal) {
        return visitExpr(literal);
    }

    @Override
    public R visitMethodDecl(MethodDecl methodDecl) {
        return visitDecl(methodDecl);
    }

    @Override
    public R visitParamDecl(ParamDecl paramDecl) {
        return visitDecl(paramDecl);
    }

    @Override
    public R visitSelectorExpr(SelectorExpr selectorExpr) {
        return visitExpr(selectorExpr);
    }

    @Override
    public R visitStat(Stat stat) {
        return visitNode(stat);
    }

    @Override
    public R visitTypeNode(TypeNode typeNode) {
        return visitNode(typeNode);
    }
}
