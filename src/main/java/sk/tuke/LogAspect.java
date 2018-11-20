package sk.tuke;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspect {

  @Pointcut("execution(* sk.tuke.HelloWorld.*())")
  public void myPointcut() {}

  @Before("myPointcut()")
  public void logBefore(JoinPoint jointPoint) throws  Throwable {
    //System.out.println("Logging" + jointPoint.toShortString());
    System.out.println("Calling method: " + jointPoint.getSignature().toLongString());
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
    System.out.println("After method call: " + jointPoint.getSignature().toLongString() + ", retVal = "  + retVal);
  }

  @AfterThrowing(pointcut = "myPointcut()",
        throwing = "ex")
  public void logException(JoinPoint jointPoint, Throwable ex) {
    System.out.println("After method call: " + jointPoint.getSignature().toLongString() + ", exception = "  + ex);
   }

}
