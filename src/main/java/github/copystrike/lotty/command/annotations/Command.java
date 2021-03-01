package github.copystrike.lotty.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command - This will let the commandManager know its an command.
 *
 * @author Copystrike
 * @since 28/02/2021 @ 22:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {

    String value();
}
