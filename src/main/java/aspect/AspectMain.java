package aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import aspectTarget.ServiceOne;
import config.AspectConfig;

public class AspectMain {
	public static void main(String [] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ServiceOne serviceOne = context.getBean(ServiceOne.class);
        serviceOne.annotation();
        ((AbstractApplicationContext) context).close();
	}
}
