package aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class AroundPointcut {

    @Pointcut("execution(* beans.AopBean+.get*(..))")
    public void getPointCut() {
    }

    @Pointcut("execution(* beans.AopBean+.add*(..))")
    public void addPointCut() {
    }
}
