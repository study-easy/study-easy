package org.hohenheim;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
            User usir = new User(); 
			//model.addAttribute("RegUser", new RegUser());
             //model.addAttribute("User", new User());
             model.addAttribute("User", usir);
             usir.setEmail("geil");
             System.out.println(usir.getEmail());
             if (error.isEmpty()){
            	 error ="kein error";
             } else {
            	 error ="Sie haben einen Error"; 
             }
             
             model.addAttribute("error", error);
             System.out.println("start index"); 
        return "index"; 
    }

	private Model addAttribute(String string, User usir) {
		// TODO Auto-generated method stub
		return null;
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
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="password", required=true) String password) {
       System.out.println(bindingResult.hasErrors());
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       if (bname.equals("bname")) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/";
       } else {
    	   System.out.println("ERROR");
    	  return "redirect:/?error=1";
       }
    	   
        //if (bindingResult.hasErrors()) {
         //   return "redirect:/test3.html";
        //}
        //return "redirect:/test2.html";
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
	@RequestMapping(value="/test2",method=RequestMethod.GET)
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

