package vn.iotstar.api.bai2ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    /*public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);
        HelloWord obj = (HelloWord) context.getBean("helloWorld");
        obj.getMessage();
        context.close();
    }*/
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWord obj = (HelloWord) context.getBean("helloWorld");
        obj.getMessage();
    }

}
