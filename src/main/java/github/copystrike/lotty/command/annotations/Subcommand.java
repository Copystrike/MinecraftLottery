package github.copystrike.lotty.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SubCommand - This will let the command manager know its a subcommand
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:41
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Subcommand {
    String value();
}