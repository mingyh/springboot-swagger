package cn.ming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by ASUS on 2020/8/14.
 */
@Configuration
//开启swagger2    http://localhost:8080/swagger-ui.html
@EnableSwagger2
public class SwaggerConfig {

    //绑定更多分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }


    //配置Swagger2的Docket的bean实例
    @Bean
    public Docket docket(){
//    public Docket docket(Environment environment){
//        //设置要显示的swagger环境
//        Profiles profiles = Profiles.of("dev", "test");
//        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) //修改自己默认的信息
                .groupName("dan")
//                .enable(false)    swagger不能再浏览器访问 .enable(flag)
                .select()
                /*RequestHandlerSelectors 配置要扫描接口的方式：
                .basePackage("cn.ming.controller") 指定要扫描的包
                .any() 扫描全部
                .none() 都不扫描
                .withClassAnnotation(GetMapping.class)  扫描类上的注解,参数是注解的反射对象
                .withMethodAnnotation(RestController.class)  扫描方法上的注解*/
                .apis(RequestHandlerSelectors.basePackage("cn.ming.controller"))
//                .paths() 过滤路径
                //.paths(PathSelectors.ant("/ming/**"))
                .build();

    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息  name、url、email
        Contact contact = new Contact("ming","localhost:8080","741168715@qq.com");
        return new ApiInfo(
                "ming的Swagger",
                "努力赚钱！！",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
