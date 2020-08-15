package aop.aspects;

import beans.AopBean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {

    @Before("execution(public * beans.AopBean+.add*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before: Executing method {" + joinPoint.getSignature().getName() + "}");
    }


    @Before("execution(public * beans.AopBean+.add*(..)) && args(value1,value2) && target(aopBean)")
    public void beforeAdviceWithoutJoinPoint(String value1, String value2, AopBean aopBean) {
        System.out.println("Before: Executing method of class {" + aopBean.getClass().getName() + "} with arguments {" + value1 + "," + value2 + "}");
    }

    @AfterReturning(value = "execution(* beans.AopBean+.get*(..))", returning = "message")
    public void afterReturningAdvice(JoinPoint joinPoint, String message) {
        System.out.println("After Returning: Executed method {" + joinPoint.getSignature().getName() + "} successfully");
        System.out.println("After Returning: Got result from message {" + message + "}");
    }


    @AfterThrowing(value = "execution(* beans.AopBean+.*(..))", throwing = "e")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception e) {
        System.out.println("After Throwing: Method {" + joinPoint.getSignature().getName() + "} execution failed");
        System.out.println("After Throwing: Got exception {" + e.getMessage() + "}");
    }

    @After(value = "execution(* beans.AopBean+.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After: Executed method {" + joinPoint.getSignature().getName() + "}");
    }


    @Around(value = "aop.pointcuts.AroundPointcut.getPointCut() || aop.pointcuts.AroundPointcut.addPointCut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long then = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } finally {
            long now = System.currentTimeMillis();
            System.out.println("Around: Method {" + joinPoint.getSignature().getName() + "} took " + (now - then) + " ms");
        }
    }

}
