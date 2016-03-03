package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspects {
	@Around("@annotation(aspect.Time)")
	public Object consejoE(ProceedingJoinPoint pjp) throws Throwable{
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		time_end = System.currentTimeMillis();
		System.out.println("-------> Tiempo Transcurrido ---->"+(time_end-time_start)+"  ms");
		return obj;
	}
}
