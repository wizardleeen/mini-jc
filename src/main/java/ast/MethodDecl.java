package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MethodDecl implements Decl {
    private List<Modifier> mods;
    private TypeNode retType;
    private String name;
    private List<ParamDecl> params;
    private Block body;
}
