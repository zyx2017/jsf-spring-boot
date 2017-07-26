package org.myacs;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@SpringBootApplication
public class Application implements ServletContextInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		servletRegistrationBean.setName("myservlet");
		System.err.println("----------------myservlet--------------------");
		return servletRegistrationBean;
    }

	@Bean
    public ServletListenerRegistrationBean<ConfigureListener> servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<ConfigureListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
        return servletListenerRegistrationBean;
    }
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.err.println("------------------------------------");
        //servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		//servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
    }

}
