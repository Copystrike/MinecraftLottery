package github.copystrike.lotty.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Endless - This flag will be handy to create an endless command argument
 *
 * @author Copystrike
 * @since 01/03/2021 @ 14:47
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Endless { }
