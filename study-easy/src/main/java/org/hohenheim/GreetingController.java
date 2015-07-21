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
import groupFunctions.Combat;
import sharedAttributes.Pinnwall;
import sharedAttributes.PinnwallElement;
import sharedAttributes.UserPinn;
import users.RegUser;
import users.Admin;
import users.User;
import groupFunctions.Test;
import groupFunctions.TestElement;


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
	 *4. Groupchange  
	 *5. Rechtliches
	 *6. Home
	 *7. Support
	 *8. Admin
	 *9. Snake und Logout
	 *10.Group
	 *11.Suche
	 *12.Profilchange
	 *13.Profilprivat
	 *14. Delete
	 *15.Combat
	 *16.COMBATTEST
	 *17.GAMES
	 *18. GroupHistory 
	 *GANZ UNTEN
	 *FÜR PRÄSENTATION
	 *-WELCOME
	 *-END
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
    		@RequestParam(value="name", required=true, defaultValue="") String bname,
    		@RequestParam(value="password", required=true, defaultValue="") String password) {
		System.out.println(reguser.signIn(password, bname)); 
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       if ((bname.equals("admin")) && (password.equals("admin"))) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/admin";
       } else {
    	   if (bname.equals("bname")) {
    		   return "redirect:/home";
    	   } 
    	   else { System.out.println("ERROR");
    		  return "redirect:/?error=10000";
    	   }
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
         System.out.println("Registrieren"); 
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
    		@RequestParam(value="passwordcheck", required=true) String passwordcheck,
    		@RequestParam(value="check", required=false) Boolean check
    		) {
       System.out.println(registerReguser.register(password, passwordcheck, bname));
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
	 *4. Groupchange
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/groupchange", method=RequestMethod.GET)
    public String profil(Model model,
    		@RequestParam(value="error", required=false, defaultValue="null") String error) {
            RegUser reguser = new RegUser(); 
            Group group = new Group();
			//model.addAttribute("RegUser", new RegUser());
             model.addAttribute("RegUser", reguser);
             model.addAttribute("Group", group);
             model.addAttribute("groupName", "Testgruppe");
             model.addAttribute("name", "Testnutzer");
             System.out.println("Groupchange");
 
             
            
        return "groupchange"; 
    }
	 
	
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
	public String home(@RequestParam(value="name", required=false, defaultValue="Mein Profil") String name, Model model) {
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
	model.addAttribute("name", name);
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
	 *##########################
	 *7. SUPPORT.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/support", method=RequestMethod.GET)
    public String support(Model model) {
            Error reguser = new Error(); 
             model.addAttribute("Error", reguser); 

             
             System.out.println("support");  
        return "support"; 
    }
	/*
	 *##########################
	 *7. SUPPORT.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/support", method=RequestMethod.POST)
    public String senden(@Valid Error error, BindingResult bindingResult,
    		@RequestParam(value="name", required=false) String bname,
    		@RequestParam(value="problem", required=false) String problem,
    		@RequestParam(value="problemort", required=false) String problemort) {
       System.out.println("Support wird bearbeitet");
       
    return "redirect:/";

    	   
        //if (bindingResult.hasErrors()) {
         //   return "redirect:/test3.html";
        //}
        //return "redirect:/test2.html";
    }
	/*
	 *##########################
	 *8. Admin.HTML
	 *Get Aufruf
	 * 
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String adminview(Model model) {
            Admin admin = new Admin(); 
             model.addAttribute("Admin", admin);
             String adminname= "TestAdmin";
             model.addAttribute("name", adminname);
             
             System.out.println("adminseite");  
        return "admin"; 
    } 
	/*
	 *##########################
	 *9. LOGOUT.HTML
	 *Get Aufruf
	 * 
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(Model model, 
    		@RequestParam(value="name", required=false, defaultValue="§") String name,
    		@RequestParam(value="delete", required=false, defaultValue="false") Boolean delete) {
            int lange = name.length();
            if(lange>1) {
            	//mache Logout, bzw speichere alle Daten
            	System.out.println("Du wirst ausgeloggt");
            }

             
             System.out.println("logout");  
        return "logout"; 
    }
	/*
	 *##########################
	 *9. SNAKE.HTML
	 *Get Aufruf
	 * 
	 */
	@RequestMapping(value="/snake", method=RequestMethod.GET)
    public String snake(Model model,
    		@RequestParam(value="name", required=false, defaultValue="TestName") String name) {
        model.addAttribute("name", name);
             System.out.println("snake");
        return "snake"; 
    }
	
	
	/*
	 *##########################
	 *10. Group.HTML
	 *Get Aufruf
	 * 
	 */
	
	@RequestMapping(value="/group", method=RequestMethod.GET)
		public String showGroupInfo(@RequestParam (value="error", required=false, defaultValue= " ") String name, Model model) {
		Group group = new Group();

		model.addAttribute("groupName", "TestGruppe");
		model.addAttribute("members", group.getUserList());
		model.addAttribute("groupDescription", "Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.");
		model.addAttribute("groupPinn", "Eintrag" /**group.getPinnwall().getEntries()*/);
		
			return "group";
		}
	/*
	 *##########################
	 *11. SEARCH.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(@RequestParam(value="name", required=false, defaultValue=" ") String name,
			@RequestParam(value="search", required=false, defaultValue=" ") String search, Model model) {
	model.addAttribute("error", name); 
	//System.out.println("ggg " + search);
	model.addAttribute("name", name); 
	return "search";
	}
	/*
	 *##########################
	 *12. ProfilChange.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/profilchange",method=RequestMethod.GET)
	public String profilget(@RequestParam(value="name", required=false, defaultValue="Testname") String name, Model model) {
	String error = "";
	model.addAttribute("error", error); 
	RegUser reguser = new RegUser();
	model.addAttribute("RegUser", reguser); 
	model.addAttribute("name", name); 
	return "profilchange";
	}
	/*
	 *##########################
	 *12. PROFILCHANGE.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/profilchange", method=RequestMethod.POST)
    public String profilpost(@Valid RegUser reguser, BindingResult bindingResult) {
       System.out.println("Profil gespeichert");
       
    return "redirect:/profil";
	} 
	/*
	 *##########################
	 *12. Profilprivat.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/profilprivat",method=RequestMethod.GET)
	public String profilprivatget(@RequestParam(value="name", required=false, defaultValue="Testname") String name, Model model) {
	RegUser reguser = new RegUser();
	model.addAttribute("RegUser", reguser); 
	model.addAttribute("name", name); 
	return "profilprivat";
	} 
	/* 
	 *##########################
	 *13. PROFILPRIVAT.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/profilprivat", method=RequestMethod.POST)
    public String profilprivatpost(@Valid RegUser reguser, BindingResult bindingResult) {
       System.out.println("Private Daten gespeichert");
       
    return "redirect:/profil";
	}
	/* 
	 *##########################
	 *14. DELETE.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteget(@RequestParam(value="name", required=false, defaultValue=" ") String name, Model model) {
	RegUser reguser = new RegUser();
	model.addAttribute("RegUser", reguser); 
	model.addAttribute("name", name); 
	return "delete";
	}
	/*
	 *##########################
	 *14. DELETE.HTML
	 *Post Aufruf 
	 *
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
    public String deletepost(@Valid RegUser reguser, BindingResult bindingResult,
    		@RequestParam(value="check", required=false) Boolean check
    		) {
		
	if(check==true) {
		//account sperren/löschen lassen
		return "redirect:/logout?delete=true";
	}
       System.out.println("Private Daten gespeichert");
       
    return "redirect:/home";
	}
	/*
	 *##########################
	 *15. Combat.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/combat",method=RequestMethod.GET)
	public String comabt(Model model) {
	RegUser reguser = new RegUser();
	Group group = new Group();
	String status ="Dein status"; //z.b zum aktuellen Combat gehen oder Combat starten
	Combat combat = new Combat ();	
	model.addAttribute("Combat", combat);
	model.addAttribute("status", status);
	model.addAttribute("name", "Testname");
	return "combat";
	}
	/*
	 *##########################
	 *15. COMBAT.HTML
	 *Post Aufruf 
	 * 
	 */
	@RequestMapping(value="/combat", method=RequestMethod.POST)
    public String combatpost(@RequestParam(value="check", required=false) Boolean check
    		) {
	
       
    return "redirect:/combattest?nr=0"; 
	} 
	/*
	 *##########################
	 *16. Combattest.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/combattest",method=RequestMethod.GET)
	public String combattest(Model model,
			@RequestParam(value="nr", required=true) int nr) {
	nr++ ; 
	RegUser reguser = new RegUser();
	Group group = new Group();
	Combat combat = new Combat ();	
	Test test = new Test ();
	TestElement testelement = new TestElement ();
	model.addAttribute("Combat", combat);
	model.addAttribute("TestElement", testelement);
	model.addAttribute("task", "Hier könnte eine Frage stehen");
	model.addAttribute("answer1", "Antwort1");
	model.addAttribute("answer2", "Antwort2");
	model.addAttribute("answer3", "Antwort3");
	model.addAttribute("answer4", "Antwort4");
	 
	return "combattest"; 
	}
	/*
	 *##########################
	 *15. COMBATTEST.HTML
	 *Post Aufruf 
	 *
	 */
	@RequestMapping(value="/combattest", method=RequestMethod.POST)
    public String combattestpost( @RequestParam(value="check", required=false, defaultValue="false") Boolean check,
    		@RequestParam(value="check2", required=false, defaultValue="false") Boolean check2,
    		@RequestParam(value="check3", required=false, defaultValue="false") Boolean check3,
    		@RequestParam(value="check4", required=false, defaultValue="false") Boolean check4
    		) { 
	System.out.println(check);
	System.out.println(check2);
	System.out.println(check3);
	System.out.println(check4);
       
    return "redirect:/combat"; 
	}
	/*
	 *##########################
	 *17.GAMES
	 *GET Aufruf 
	 *
	 */
	@RequestMapping(value="/games",method=RequestMethod.GET)
	public String games(Model model) {
	RegUser reguser = new RegUser();
	model.addAttribute("name", "Testname");
	return "games"; 
	}
	/*
	 *##########################
	 *18.GroupHistory
	 *GET Aufruf 
	 *
	 */
	@RequestMapping(value="/groupHistory", method=RequestMethod.GET)
	public String showGroupHistory(@RequestParam (value="error" , required=false, defaultValue=" ") String name, Model model) {
	model.addAttribute("groupHistory", "Verlauf");
	model.addAttribute("groupName", "Gruppenname");
	return "groupHistory";
}
	/*
	 *##########################
	 *FÜR PRÄSENTATION
	 *WELCOME 
	 *
	 */
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcomeget(Model model) {
	return "welcome";
	}
	/*
	 *##########################
	 *FÜR PRÄSENTATION
	 *WELCOME 
	 * 
	 */
	@RequestMapping(value="/theend",method=RequestMethod.GET)
	public String theend(Model model) {
	return "theend";
	}
	
}
