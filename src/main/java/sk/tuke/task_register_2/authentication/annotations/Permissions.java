package sk.tuke.task_register_2.authentication.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import sk.tuke.task_register_2.authentication.Role;

@Retention(RetentionPolicy.RUNTIME)
public @interface Permissions {
	Role role();
}
