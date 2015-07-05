package org.hohenheim;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import Users.RegUser;
import Users.User;

@Controller
@RequestMapping("/")
public class GreetingController { 
	/*
	 *  ###### Gehört zur Post Methode der index.html ####
	 *  Referenzen auf andere Dateien src/main/java/Users/RegUser.java
	 *  src/main/webapp/web-inf/templates/index.html
	 */
	/*
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test3").setViewName("test3");
    } 

	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm(Model model,
    		@RequestParam(value="error", required=false, defaultValue="null") String error) {
             //model.addAttribute("RegUser", new RegUser());
             model.addAttribute("User", new User());
             if (error.isEmpty()){
            	 error ="kein error";
             } else {
            	 error ="Sie haben einen Error"; 
             }
             model.addAttribute("error", error);
             System.out.println("start index"); 
        return "index"; 
    }

	//@RequestMapping(value="/", method=RequestMethod.POST)
   // public String checkPersonInfo(@Valid RegUser reguser, BindingResult bindingResult) {
    //   System.out.println(bindingResult.hasErrors());
    //   System.out.println("reguser");
    //    if (bindingResult.hasErrors()) {
    //       return "index";
    //    }
    //    return "redirect:/test2.html";
    //}
	@RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo2(@Valid User user, BindingResult bindingResult,
    		@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="password", required=true) String password) {
       System.out.println(bindingResult.hasErrors());
       System.out.println("Benutzername: " +name);
       System.out.println("Passwort: " +password);
       int große = name.length();
       if (große < 4) {
    	   System.out.println("Badumdz");
    	   return "redirect:/?error=1";
       }
    	   
        if (bindingResult.hasErrors()) {
            return "redirect:/test3.html";
        }
        return "redirect:/test2.html";
    }
	
	/*
	 *  ###### bis hier ####
	 *  die Nachfolgende Methode arbeitet ausschließlich mit dem Beispiel auf den folien mit ?name= 
	
    
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm2(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	model.addAttribute("name", name);
    	return "index";
    }
	@RequestMapping(value="/index.html",method=RequestMethod.GET)
	public String greeting2(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	//System.out.println(name);
	return"index";}
	*/ 
	@RequestMapping(value="/test2.html",method=RequestMethod.GET)
	public String greeting3(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	//System.out.println(name);
	return"test2";}
	
	@RequestMapping(value="/test3.html",method=RequestMethod.GET)
	public String greeting4(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	//System.out.println(name);
	return"test3";}
	
}

