// This is a generated file. Not intended for manual editing.
package com.squirrelplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SquirrelVarDeclaration extends PsiElement {

  @Nullable
  SquirrelExpr getExpr();

  @Nullable
  SquirrelVarDeclaration getVarDeclaration();

  @NotNull
  PsiElement getIdentifier();

}