package hello.pcore.beanfind;

import hello.pcore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findALlBean(){
        String[] beanDifinitionNames=ac.getBeanDefinitionNames();

        for(String beanDifinitionName:beanDifinitionNames){
            Object bean = ac.getBean(beanDifinitionName);
            System.out.println("name = "+beanDifinitionName+" Object = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDifinitionNames=ac.getBeanDefinitionNames();

        for(String beanDifinitionName:beanDifinitionNames){
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDifinitionName);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("name = "+beanDifinitionName + "  beanDefinition = " + beanDefinition);
            }

        }
    }
}
