package br.edu.ufcg.computacao.si1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import br.edu.ufcg.computacao.si1.util.TokenFilter;

@SpringBootApplication
public class InitialPoint {

    public static void main(String[] args) {
        SpringApplication.run(InitialPoint.class, args);
    }

    @Bean
    public FilterRegistrationBean filtroJwt() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new TokenFilter());
        filter.addUrlPatterns("/auth/*");
        return filter;
    }

}
