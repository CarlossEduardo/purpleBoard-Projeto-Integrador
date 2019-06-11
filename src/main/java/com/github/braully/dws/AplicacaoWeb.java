package com.github.braully.dws;

import com.sun.faces.config.ConfigureListener;
import static controlizinho.ClienteDao.listarCliente;

import modelinho.TabelaVendaLojaSemestre;
import controlizinho.ConsultasDao;
import static controlizinho.ConsultasDao.QtdeVendasSemestre;
import static controlizinho.ConsultasDao.QuantidadeLoja;
import static controlizinho.ConsultasDao.ValorVendasLojaSemestre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import modelinho.Cliente1;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.context.ServletContextAware;



import com.sun.faces.config.ConfigureListener;
import static controlizinho.ConsultasDao.GerarTabela2;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import modelinho.TabelaConsulta2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.context.ServletContextAware;

/**
 *
 * @author braully
 */
@EnableWebSecurity
@SpringBootApplication
public class AplicacaoWeb extends WebSecurityConfigurerAdapter implements ServletContextAware {

    public static void main(String... args) throws Exception  {
        SpringApplication.run(AplicacaoWeb.class, args);
        
       // ArrayList<TabelaConsulta2> listona = GerarTabela2("2019", "1");
        //System.out.println(listona.get(0).getNome());
       // System.out.println(listona.get(0).getNomeCliente());
       // ArrayList<TabelaVendaLojaSemestre> tt = ValorVendasLojaSemestre();
       // System.out.println(tt.get(0).getNomeLoja());
       // Object[] valorQuantidade = QtdeVendasSemestre();
       // System.out.println(valorQuantidade[0] + "  "+ valorQuantidade[1]);
       // int quantidadeLoja = QuantidadeLoja();
       // System.out.println("essa é qtd loja "+ quantidadeLoja);
  
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
       // UserDetails user = User.withUsername("usuario")
       //         .password(passwordEncoder().encode("usuario"))
       //         .roles("USER").build();

        UserDetails admin = User.withUsername("gerente")
                .password(passwordEncoder().encode("gerente"))
                .roles("gerente").build();
        return new InMemoryUserDetailsManager(admin);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception  {
         http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/cliente.xhtml").hasRole("gerente")
                .anyRequest().permitAll().and()
                .formLogin().permitAll().and()
                .logout().permitAll();
        http.csrf().disable();
    }
    
    
    

    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> escopos = new HashMap<>();
        escopos.put("view", new ViewScope());
        configurer.setScopes(escopos);
        return configurer;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<ConfigureListener>(
                new ConfigureListener());
    }

   
    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
    }
    
        
}
