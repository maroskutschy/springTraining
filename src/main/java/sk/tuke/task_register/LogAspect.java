package sk.tuke.task_register;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class LogAspect {

  //@Pointcut("execution(* sk.tuke.task_register.HelloWorld.*())")
  @Pointcut("execution(* sk.tuke.task_register.*.*(..))")
  public void myPointcut() {}

  @Before("myPointcut()")
  public void logBefore(JoinPoint jointPoint) throws  Throwable {
    //System.out.println("Logging" + jointPoint.toShortString());
    System.out.println("Calling method: " + jointPoint.getSignature().toLongString() +  ", args: " + Arrays.toString(jointPoint.getArgs()  ));
   }

//  @After("execution(void *.sayHello())")
//  public void logAfter(JoinPoint jointPoint) throws  Throwable {
//    //System.out.println("Logging" + jointPoint.toShortString());
//    System.out.println("Calling method: " + jointPoint.getSignature().toLongString());
//  }

  @AfterReturning(value = "myPointcut()",
      returning = "retVal")
  public void logAfter(JoinPoint jointPoint, Object retVal) throws  Throwable {
    //System.out.println("Logging" + jointPoint.toShortString());
    System.out.println("After method call: " + jointPoint.getSignature().toLongString() + ", retVal = "  + retVal + ", args: " + Arrays.toString(jointPoint.getArgs()  ));
  }

  @AfterThrowing(pointcut = "myPointcut()",
        throwing = "ex")
  public void logException(JoinPoint jointPoint, Throwable ex) {
    System.out.println("After method call: " + jointPoint.getSignature().toLongString() + ", exception = "  + ex + ", args: " + Arrays.toString(jointPoint.getArgs()  ));
   }

}
