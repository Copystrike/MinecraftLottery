package github.copystrike.lotty.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Permission - Use this flag to assign permissions to a command.
 *
 * @author Copystrike
 * @since 01/03/2021 @ 01:53
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Permission {
    String value();
}
