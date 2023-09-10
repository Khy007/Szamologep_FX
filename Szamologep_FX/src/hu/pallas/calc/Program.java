package hu.pallas.calc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Program {
	
	static Resource resource= new ClassPathResource("applicationContext.xml");
	static BeanFactory factory = new XmlBeanFactory(resource);

	public static void main(String[] args) {
		
		new Menu();
		
	}

}

