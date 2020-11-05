package hcmiu.thesis.configurations;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		
		root.scan("hcmiu.thesis.configurations");
		sc.addListener(new ContextLoaderListener(root));
		
		ServletRegistration.Dynamic appServlet = sc.addServlet("SpringDispatcher", new DispatcherServlet(root));
		
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
	
	
}
