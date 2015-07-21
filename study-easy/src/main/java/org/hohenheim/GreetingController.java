package org.hohenheim;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import groupFunctions.Group;
import sharedAttributes.Pinnwall;
import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;
import users.RegUser;
import users.User;


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
	 *4. Profil  
	 *5. Rechtliches
	 *6. Home
	 *7. 
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

	/*
	 *##########################
	 *STARTSEITE INDEX.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
    public String login(@Valid RegUser reguser, BindingResult bindingResult,
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="password", required=true) String password) {
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       if (bname.equals("bname")) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/home";
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
	public String registerG(Model model,
		@RequestParam(value="error", required=false, defaultValue="null") String error) {
        RegUser registerRegUser = new RegUser(); 
		//model.addAttribute("RegUser", new RegUser());
         //model.addAttribute("User", new User());
         model.addAttribute("RegUser", registerRegUser);
         registerRegUser.setEmail("Regestrieren");
         System.out.println(registerRegUser.getEmail());
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
         registerRegUser.setEmail("Password vergessen");
         System.out.println(registerRegUser.getEmail());
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
	 *##########################
	 *PROFIL.HTML
	 *POST Aufruf
	 * 
	 * 
	 */
	
	/*
	 *##########################
	 *5. PRIVACY.HTML
	 *Get Aufruf
	 *Besitzt sonst nichts
	 */
	
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
    public String privacy(){	 
        return "privacy";
    } 
	/*
	 *##########################
	 *6. HOME.HTML
	 *Get Aufruf
	 *Da wo die Pinnwand ist
	 */
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(@RequestParam(value="name", required=false, defaultValue=" ") String name, Model model) {
	UserPinn userPinn = new UserPinn();
	Date date = new Date();
	date.setDate(20);
	RegUser testUser = new RegUser();
	Group group = new Group();
	group.setName("TestGruppe");
	testUser.addToGroupList(group);
	testUser.addToGroupList(group);
	PinnwallElement e = new PinnwallElement();
	e.setEntry("Testeintrag");
	e.setCreator(testUser);
	e.setDate(date);
	userPinn.addEntrie(e);
	model.addAttribute("error", name);
	model.addAttribute("userPinn", userPinn.getEntries());
	model.addAttribute("groupList", testUser.getGroupList());
	model.addAttribute("pinnwallOwner", "Hans");
	model.addAttribute("pinnwallOwner", "Testuser 1");
	return "home"; 
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	public String greeting4(@RequestParam(value="name", required=false, defaultValue=" ") String name, Model model) {
	model.addAttribute("name", name);
	
	//System.out.println(name); 
	return"test3";}
	
	
	
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
	
	@RequestMapping(value="/group", method=RequestMethod.GET)
		public String showGroupInfo(@RequestParam (value="error", required=false, defaultValue= " ") String name, Model model) {
		Group group = new Group();

		model.addAttribute("groupName", "TestGruppe");
		model.addAttribute("members", group.getUserList());
		model.addAttribute("groupDescription", "Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.");
		model.addAttribute("groupPinn", "Eintrag" /**group.getPinnwall().getEntries()*/);
		
			return "group";
		}
	@RequestMapping(value="/groupHistory", method=RequestMethod.GET)
		public String showGroupHistory(@RequestParam (value="error" , required=false, defaultValue=" ") String name, Model model) {
		model.addAttribute("groupHistory", "Verlauf");
		model.addAttribute("groupName", "Gruppenname");
		return "groupHistory";
	}
}
