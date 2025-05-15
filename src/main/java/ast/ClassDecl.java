package ast;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClassDecl implements Decl {
    private List<Modifier> mods;
    private String name;
    private List<Decl> members;
}
