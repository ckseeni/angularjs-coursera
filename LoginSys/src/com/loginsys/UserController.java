package com.loginsys;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;



@Controller
public class UserController {
	public static int i=2;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView user() {
	      return new ModelAndView("user", "command", new User());
	   }
	   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	      public String addStudent(@ModelAttribute("SpringWeb")User user, 
	   
	   ModelMap model) {
	      model.addAttribute("username", user.getUsername());
	      model.addAttribute("password", user.getPassword());
	    //creating configuration object  
	      Configuration cfg=new Configuration();  
	      cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	        
	      //creating seession factory object  
	      SessionFactory factory=cfg.buildSessionFactory();  
	        
	      //creating session object  
	      Session session=factory.openSession();  
	        
	      //creating transaction object  
	      Transaction t=session.beginTransaction();  
	       //System.out.println("up to connection");     
	      User u=new User();
	      u.setId(i);
	      u.setUsername(user.getUsername());  
	      u.setPassword(user.getPassword());    
	        
	      session.persist(u);//persisting the object  
	        
	      t.commit();//transaction is committed  
	      session.close();  
	        
	      System.out.println("successfully saved");  
	      return "result";
	   }

}
