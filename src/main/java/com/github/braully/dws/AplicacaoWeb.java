package com.github.braully.dws;

import com.sun.faces.config.ConfigureListener;
import static controlizinho.ClienteDao.listarCliente;

import controlizinho.TabelaVendaLojaSemestre;
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
import org.springframework.web.context.ServletContextAware;

/**
 *
 * @author braully
 */
@SpringBootApplication
public class AplicacaoWeb implements ServletContextAware {

    public static void main(String... args) throws Exception  {
        SpringApplication.run(AplicacaoWeb.class, args);
        ArrayList<Cliente1> listona = listarCliente();
        System.out.println(listona.get(0).getNomeCliente());
        ArrayList<TabelaVendaLojaSemestre> tt = ValorVendasLojaSemestre();
        System.out.println(tt.get(0).getNomeLoja());
        Object[] valorQuantidade = QtdeVendasSemestre();
        System.out.println(valorQuantidade[0] + "  "+ valorQuantidade[1]);
        int quantidadeLoja = QuantidadeLoja();
        System.out.println("essa é qtd loja "+ quantidadeLoja);
  
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
