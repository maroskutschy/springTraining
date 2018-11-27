package sk.tuke.task_register_2;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspect {
	@Pointcut("execution(@sk.tuke.task_register_2.annotation.Log * *(..))")
	private void mypointcut() {}
	
	@Before("mypointcut()")
	public void logBefore(JoinPoint joinPoint) {	
		System.out.println("Calling method " + joinPoint.getSignature() + "with arguments " + Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterReturning(pointcut = "mypointcut()", returning="retVal")
	public void logAfter(JoinPoint joinPoint, Object retVal) {
		System.out.println("Method " + joinPoint.getSignature() + " finished successfuly returning value: " + retVal);
	}
	
	@AfterThrowing(pointcut = "mypointcut()", throwing = "throwing")
	public void logThrow(JoinPoint joinPoint, Throwable throwing) {
		System.out.println("Method " + joinPoint.getSignature() + " failed. Throws: " + throwing);
	}
}
