package com.itheima.springbootenable;

import com.itheima.config.MyImportBeanDefinitionRegistrar;
import com.itheima.domain.Row;
import com.itheima.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @ComponentScan 扫描范围 是在当前引导类及其子包下边
 *  1.使用@componentscan 扫描一下  解决 No bean named 'user' available
 *  2.可以使用@Import 加载类 ，这些类都会被spring创建并放入ioc容器
 *  3. 对@import进行一个封装 ,在提供方自定一个注解加上import和元注解
 */

/**
 * @Import 的四种用法
 * 1. 导入bean
 * 2. 导入配置类 @Import(User.class)
 * 3.  导入ImportSelector的实现类
 * 4.导入ImportBeanDefinitionRegistrar 实现类
 */
@SpringBootApplication
//@ComponentScan("com.itheima.config")
//@Import(UserConfig.class)
//@EnableUser
//@Import(User.class)
//@Import(UserConfig.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

//        //1.获取到一个bean
//        Object user = context.getBean("user");
//        System.out.println(user);

        User bean = context.getBean(User.class);
        System.out.println(bean);
//        Map<String, User> beansOfType = context.getBeansOfType(User.class);
//        System.out.println(beansOfType);


        Row row = context.getBean(Row.class);
        System.out.println(row);
    }

}
