package ast;

public class StructuralNodeVisitor extends AbstractNodeVisitor<Void> {
    @Override
    public Void visitNode(Node node) {
        node.forEachChild(c -> c.accept(this));
        return null;
    }
}
