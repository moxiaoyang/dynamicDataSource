package aop;




import datasource.DataSource;
import datasource.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 莫小阳
 */
@Aspect
@Component
public class DataSourceInterceptor {

    @Pointcut("execution (* dao.UserMapper.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrowing() {
        System.out.println("异常通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        DataSource annotation = method.getAnnotation(DataSource.class);
        if (annotation != null) {
            DynamicDataSourceHolder.setDataSourceType(annotation.value());
        }
        return pjp.proceed();
    }


}
