package org.jzy.bookmanager;


import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class Knife4JConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("图书管理系统")
                .description("简单的图书管理系统")
                .contact(new Contact("Fresh0range", null, "1834888164@qq.com"))
                .version("0.0.1")
                .build();
    }
}
