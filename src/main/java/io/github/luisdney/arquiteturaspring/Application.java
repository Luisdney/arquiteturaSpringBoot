package io.github.luisdney.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

        builder.bannerMode(Banner.Mode.OFF);
        builder.run(args);
        builder.profiles("producao");
//        builder.lazyInitialization(true);

        //builder.
        ConfigurableApplicationContext applicationContext = builder.context();
        //var produtoRepository = applicationContext.getBean("produtoRepository");

        ExemploValue value = applicationContext.getBean(ExemploValue.class);
        value.imprimirVarivel();

        AppPropreties propreties = applicationContext.getBean(AppPropreties.class);
        System.out.println(propreties.getValor1());
    }

}
