package org.hohenheim;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import users.RegUser;


@Controller
@RequestMapping("/")
public class GreetingController { 
	/*
	 *##########################
	 *INHALTSVERZEICHNIS
	 *##########################
	 *1. Startseite mit Login
	 *2. Regstrierseite
	 *3. Password vergessen
	 *4. Profil bearbeiten
	 */
	/*
	 *##########################
	 *1. STARTSEITE INDEX.HTML
	 *Get Aufruf
	 * 
	 */

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String showForm(Model model,
    		@RequestParam(value="error", required=false, defaultValue="null") String error) {
            RegUser reguser = new RegUser(); 
			//model.addAttribute("RegUser", new RegUser());
             model.addAttribute("RegUser", reguser);         
             System.out.println("Index-Seite");
             if (error.length() < 5){
            	 error ="";
            	 model.addAttribute("error", error);
             } else {
            	 error ="Sie haben einen Error"; 
            	 model.addAttribute("error", error);
             }
             
            
             System.out.println("start index"); 
        return "index"; 
    }

	//private Model addAttribute(String string, User usir) {
		// TODO Auto-generated method stub
	//	return null;
	//}


	/*
	 *##########################
	 *STARTSEITE INDEX.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
    public String checkPersonInfo2(@Valid RegUser reguser, BindingResult bindingResult,
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
    	  return "redirect:/?error=10000";
       }
    	   
        //if (bindingResult.hasErrors()) {
         //   return "redirect:/test3.html";
        //}
        //return "redirect:/test2.html";
    }
	
	
	
	/*
	 *##########################
	 *2. REGESTRIEREN.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String greeting3(Model model,
		@RequestParam(value="error", required=false, defaultValue="null") String error) {
        RegUser registerRegUser = new RegUser(); 
		//model.addAttribute("RegUser", new RegUser());
         //model.addAttribute("User", new User());
         model.addAttribute("RegUser", registerRegUser);
         if (error.isEmpty()){
    
         } else {
        	 error ="Sie haben einen Error"; 
        	 model.addAttribute("error", error);
         }
         
         
         System.out.println("start index"); 
    return "register"; 
	}
	/*
	 *##########################
	 *REGESTRIEREN.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
    public String regestrieren(@Valid RegUser registerReguser, BindingResult bindingResult,
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="password", required=true) String password,
    		@RequestParam(value="name", required=true) String passwordcheck,
    		@RequestParam(value="check", required=false) Boolean check
    		) {
       System.out.println(bindingResult.hasErrors());
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       System.out.println("WPasswort: " +passwordcheck);
       System.out.println("Aktzeptiert: " + check);
       if (bname.equals("bname")) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/register"; 
       } else {
    	   System.out.println("ERROR");
    	  return "redirect:/";
       }
       }
	/*
	 *##########################
	 *3.PASSWORT VERGESSEN.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/forgot",method=RequestMethod.GET)
	public String forgot(Model model,
		@RequestParam(value="error", required=false, defaultValue="null") String error) {
        RegUser registerRegUser = new RegUser(); 
		//model.addAttribute("RegUser", new RegUser());
         //model.addAttribute("User", new User());
         model.addAttribute("RegUser", registerRegUser);
         if (error.isEmpty()){
    
         } else {
        	 error ="Sie haben einen Error"; 
        	 model.addAttribute("error", error);
         }
         
         
         System.out.println("start password vergessen"); 
    return "forgot"; 
	}
	
	
	
	/*
	 *##########################
	 *PASSWORT VERGESSEN.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/forgot", method=RequestMethod.POST)
    public String forgotN(@Valid RegUser reguser, BindingResult bindingResult,
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="sicherheitsfrage", required=true) String password) {
       System.out.println(bindingResult.hasErrors());
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       if (bname.equals("bname")) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/";
       } else {
    	   System.out.println("neues Password");
    	  return "redirect:/?error=10000";
       }
     
        //if (bindingResult.hasErrors()) {
         //   return "redirect:/test3.html";
        //} 
        //return "redirect:/test2.html";
    }
	
	
	
	
	
	@RequestMapping(value="/test3.html",method=RequestMethod.GET)
	public String greeting4(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	//System.out.println(name);

	return"index";
	

	
	}
	/*
	 *##########################
	 *4. PROFIL.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/profil", method=RequestMethod.GET)
    public String profil(Model model,
    		@RequestParam(value="error", required=false, defaultValue="null") String error) {
            RegUser reguser = new RegUser(); 
			//model.addAttribute("RegUser", new RegUser());
             model.addAttribute("RegUser", reguser);         
             System.out.println("Profil");
             if (error.length() < 5){
            	 error ="";
            	 model.addAttribute("error", error);
             } else {
            	 error ="Sie haben einen Error"; 
            	 model.addAttribute("error", error);
             }
             
            
        return "profil"; 
    }
	
	/*
	 *
	@RequestMapping(value="/", method=RequestMethod.GET)
   public String showForm2(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
   	model.addAttribute("name", name);
   	return "index";
   }

	
	*/ 
	//@RequestMapping(value="/", method=RequestMethod.POST)
	   // public String checkPersonInfo(@Valid RegUser reguser, BindingResult bindingResult) {
	    //   System.out.println(bindingResult.hasErrors());
	    //   System.out.println("reguser");
	    //    if (bindingResult.hasErrors()) {
	    //       return "index";
	    //    }
	    //    return "redirect:/test2.html";
	    //}
}

