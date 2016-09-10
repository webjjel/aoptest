package kr.co.saramin.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	@Before("execution(public ProductVo kr.co.saramin.aoptest.ProductService.findProduct(String))")
	public void before() {
		System.out.println("call [before advice]");
	}
	
	@After("execution(ProductVo kr.co.saramin.aoptest.ProductService.findProduct(String))")
	public void after() {
		System.out.println("call [after advice]");
	}
	
	@AfterReturning("execution(* *..aoptest.ProductService.find*(..))")
	public void afterReturning() {
		System.out.println("call [after returning advice]");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("call [around before advice]");
		Object[] a = {"Camera"};
		Object result = pjp.proceed(a);
		System.out.println("call [around after advice]");
		
		return result;
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("call [after throwing advice] : " + ex);
	}
}
