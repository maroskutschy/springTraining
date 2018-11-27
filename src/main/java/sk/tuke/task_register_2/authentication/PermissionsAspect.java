package sk.tuke.task_register_2.authentication;

import java.lang.annotation.Annotation;
import java.security.acl.Permission;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import sk.tuke.task_register_2.authentication.annotations.Permissions;




@Configuration
@Aspect
public class PermissionsAspect {
	@Autowired
	public RegisterPermissions permissions;
	
	@Pointcut("execution(@sk.tuke.task_register_2.authentication.annotations.Permissions * *(..))")
	private void mypointcut() {}
	
	@Before("mypointcut()")
	public void checkPermissions(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {	
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Permissions permission = signature.getMethod().getAnnotation(Permissions.class);
		/*
		Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();

		Annotation[] annotations = joinPoint.getTarget().getClass()
				.getMethod(methodName,parameterTypes).getAnnotationsByType(Permissions.class);
				*/
		Role role = permission.role();
		if(!permissions.hasPermissions(role)) {
			throw new SecurityException("User does not have permissions to run this operation");
		}
		
	}
}
