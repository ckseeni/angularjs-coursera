package com.tutorialspoint;

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
public class StudentController {
   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
      public String addStudent(@ModelAttribute("SpringWeb")Student student, 
   
   ModelMap model) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
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
      Student e1=new Student();  
      e1.setId(student.getId());  
      e1.setName(student.getName());  
      e1.setAge(student.getId());  
        
      session.persist(e1);//persisting the object  
        
      t.commit();//transaction is committed  
      session.close();  
        
      System.out.println("successfully saved");  
      return "result";
   }
}