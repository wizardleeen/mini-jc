package ast;

import java.util.function.Consumer;

public interface Node {

    <R> R accept(NodeVisitor<R> visitor);

    void forEachChild(Consumer<? super Node> action);

}
