package study_easy.org.hohenheim;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import study_easy.groupFunctions.Combat;
import study_easy.groupFunctions.Group;
import study_easy.groupFunctions.Test;
import study_easy.groupFunctions.TestElement;
import study_easy.service.GroupPinnService;
import study_easy.service.PinnwallElementService;
import study_easy.service.RegUserService;
import study_easy.sharedAttributes.PinnwallElement;
import study_easy.sharedAttributes.UserPinn;
import study_easy.users.Admin;
import study_easy.users.RegUser;

@Controller
@RequestMapping("/")
public class GreetingController {
	// TODO service objekte autowired hier aufschreiben
	@Autowired
	private RegUserService RUS;
	
	RegUser guser = new RegUser();
	Group group = new Group();

	@Autowired
	private PinnwallElementService PES;
	@Autowired
	private GroupPinnService GPS;
	/*
	 *##########################
	 *INHALTSVERZEICHNIS
	 *##########################
	 *1. Startseite mit Login
	 *2. Regstrierseite
	 *3. Password vergessen
	 *4. Combat  
	 *5. Profilchange
	 *6. Home
	 *7. Support
	 *8. COMBATTEST
	 *9. Snake und Logout
	 *10.Group
	 *11.Suche
	 *12.Rechtliches
	 *13.Profilprivat
	 *14. Delete
	 *15.Groupchange
	 *16.Admin
	 *17.GAMES
	 *18. GroupHistory 
	 *19. Members
	 *20. Data
	 *GANZ UNTEN
	 *F�R PR�SENTATION
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
    		@RequestParam(value="error", required=false, defaultValue=" ") String error) {
            RegUser reguser = new RegUser(); 
            if(error.equals("1")) {
            	model.addAttribute("error", "Eingabe falsch");
            }
            if(error.equals("2")) {
            	model.addAttribute("error", "Erfolgreich Registriert");
            }
             model.addAttribute("RegUser", reguser);         
             System.out.println("Index-Seite");
        return "index"; 
    }

	/*
	 *##########################
	 *STARTSEITE INDEX.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
    public String login(RegUser reguser,
    		@RequestParam(value="name", required=true, defaultValue="") String bname,
    		@RequestParam(value="password", required=true, defaultValue="") String password) {
		System.out.println(RUS.signIn(password, bname)); 
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password);
       if ((bname.equals("admin")) && (password.equals("admin"))) {
    	   System.out.println("Sie werden erfolgreich eingeloggt");
    	   return "redirect:/admin";
       } else {
    	   if (RUS.signIn(password, bname)) {
    		   String redirect = "redirect:/home?user=" +bname;
    		   return redirect;
    	   } 
    	   else { System.out.println("ERROR");
    		  return "redirect:/?error=1";
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
    public String regestrieren( RegUser registerReguser,
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="password", required=true) String password,
    		@RequestParam(value="passwordcheck", required=true) String passwordcheck,
    		@RequestParam(value="sicherheitsfrage", required=true) String sicherheitsfrage,
    		@RequestParam(value="sicherheitsfragecheck", required=true) String sicherheitsantwort,
    		@RequestParam(value="check", required=false, defaultValue="false") Boolean check
    		) {
		if(check == false) {
			return "redirect:/register?error=1";
		}
       //System.out.println(RUS.register(password, passwordcheck, bname, sicherheitsfrage, sicherheitsantwort ));
       System.out.println("Benutzername: " +bname);
       System.out.println("Passwort: " +password); 
       System.out.println("WPasswort: " +passwordcheck);
       System.out.println("Aktzeptiert: " + check);
       if (RUS.register(password, passwordcheck, bname, sicherheitsfrage, sicherheitsantwort )) {
		   return "redirect:/?error=2"; 
       } else {
    	   System.out.println("ERROR");
    	   return "redirect:/register?error=1";
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
    public String forgotN(RegUser reguser,
    		@RequestParam(value="name", required=true) String bname,
    		@RequestParam(value="sicherheitsfrage", required=true) String password) {
       
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
	 *4. Combat.HTML
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
	 *4. COMBAT.HTML
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
	 *5. ProfilChange.HTML
	 *Get Aufruf
	 *
	 */
	@RequestMapping(value="/profilchange",method=RequestMethod.GET)
	public String profilget(@RequestParam(value="user", required=true) String name, Model model) {
	//String error = "";
	//model.addAttribute("error", error);
	System.out.println(name); 
	RegUser reguser = new RegUser();
	reguser.setPassword(RUS.getThisUser(name).getPassword());
	reguser.setHobby(RUS.getThisUser(name).getHobby());
	reguser.setSchool(RUS.getThisUser(name).getSchool());
	reguser.setName(name);
	System.out.println(reguser.getName());
	model.addAttribute("RegUser", reguser); 
	model.addAttribute(reguser);
	model.addAttribute("name", name); 
	return "profilchange";
	}
	/*
	 *##########################
	 *5. PROFILCHANGE.HTML
	 *Post Aufruf
	 *
	 */
	@RequestMapping(value="/profilchange", method=RequestMethod.POST)
    public String profilpost(RegUser RegUser,
    		@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="email", required=false) String email,
    		@RequestParam(value="school", required=false) String school,
    		@RequestParam(value="quotes", required=false) String quotes) {
	
		if(email.isEmpty()) {
			
		} else { RegUser.setEmail(email);
		}
		if(school.isEmpty()) {
			
		} else {
			RegUser.setSchool(school);
		}
		//RUS.updateRegUser(reguser);
		System.out.println(RegUser.getName());
		String user= RegUser.getName();
       System.out.println("Profil speichern");
       String redirect = "redirect:/home?user=" +user;
    return redirect;
	} 
	
	
	
	/*
	 *##########################
	 *6. HOME.HTML
	 *Get Aufruf
	 *Da wo die Pinnwand ist
	 */
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(@RequestParam(value="user", required=true) String name, Model model) {
	//alle drei haben den gleichen Wert
	model.addAttribute("name", name);
	model.addAttribute("user", name);
	model.addAttribute("pinnwallOwner", name);
	model.addAttribute("wert","");
		UserPinn userPinn = new UserPinn();
	PinnwallElement element = new PinnwallElement();
	Date date = new Date();
	date.setDate(20);
	RegUser testUser = new RegUser();
	Group group = new Group();
	PinnwallElement e = new PinnwallElement();
	model.addAttribute("PinnwallElement", element);
	return "home"; 
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	public String greeting4(@RequestParam(value="name", required=false, defaultValue=" ") String name, Model model) {
	model.addAttribute("name", name);
	Integer wert = 64;
	model.addAttribute("wert", wert);
	
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
    public String senden(Error error,
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
	 *8. Combattest.HTML
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
	model.addAttribute("task", "Hier k�nnte eine Frage stehen");
	model.addAttribute("answer1", "Antwort1");
	model.addAttribute("answer2", "Antwort2");
	model.addAttribute("answer3", "Antwort3");
	model.addAttribute("answer4", "Antwort4");
	 
	return "combattest"; 
	}
	/*
	 *##########################
	 *8. COMBATTEST.HTML
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
	 *9. LOGOUT.HTML
	 *Get Aufruf
	 * 
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(Model model, 
    		@RequestParam(value="name", required=false, defaultValue="�") String name,
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
		public String showGroupInfo(@RequestParam (value="error", required=false, defaultValue= " ") String name, Model model,
									@RequestParam (value="entry", required=true, defaultValue="") String entry) {
		Group group = new Group();
		PinnwallElement element = new PinnwallElement();
		
		model.addAttribute("PinnwallElement", element);
		model.addAttribute("groupName", "TestGruppe");

		model.addAttribute("groupDescription", "Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.Das ist eine Testgruppe.");
		model.addAttribute("groupPinn", "Eintrag" /**group.getPinnwall().getEntries()*/);
		model.addAttribute("name", "Testuser");
		//hahahha
			return "group";
		}
	
	@RequestMapping(value="/group", method=RequestMethod.POST)
		public String saveEntry(@RequestParam (value="entry", required=true, defaultValue="") String entry) {
			
		}
	/*
	 * TRENNLINIE
	 * 
	 * 
	 */
	
	
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
	 *12. PRIVACY.HTML
	 *Get Aufruf
	 *Besitzt sonst nichts
	 */
	
	@RequestMapping(value="/privacy", method=RequestMethod.GET)
    public String privacy(){	 
        return "privacy";
    } 
	/*
	 *##########################
	 *13. Profilprivat.HTML
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
    public String profilprivatpost(RegUser reguser) {
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
    public String deletepost(RegUser reguser,
    		@RequestParam(value="check", required=false) Boolean check
    		) {
		
	if(check==true) {
		//account sperren/l�schen lassen
		return "redirect:/logout?delete=true";
	}
       System.out.println("Private Daten gespeichert");
       
    return "redirect:/home";
	}
	/*
	 *##########################
	 *15. Groupchange
	 *Get Aufruf
	 *POST-AUfruf zum speichern fehlt
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
	 *16. Admin.HTML
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
	model.addAttribute("name", "TestUser");
	return "groupHistory";
}
	/*
	 *##########################
	 *19. Members
	 *Gruppenmember
	 *
	 */
	@RequestMapping(value="/members", method=RequestMethod.GET)
	public String showMembers(@RequestParam (value="error" , required=false, defaultValue=" ") String name, Model model) {
	model.addAttribute("groupHistory", "Verlauf");
	model.addAttribute("groupName", "Testgruppe");
	model.addAttribute("name", "Testuser");
	return "members";
	}
	/*
	 *##########################
	 *20. Members
	 *Gruppenmember
	 * 
	 */
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public String showData(@RequestParam (value="error" , required=false, defaultValue=" ") String name, Model model) {
	model.addAttribute("groupHistory", "Verlauf");
	model.addAttribute("groupName", "Testgruppe");
	model.addAttribute("name", "Testuser");
	return "data";
	}
	/*
	 *##########################
	 *F�R PR�SENTATION
	 *WELCOME 
	 *
	 */
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcomeget(Model model) {
	return "welcome";
	}
	/*
	 *##########################
	 *F�R PR�SENTATION
	 *WELCOME 
	 * 
	 */
	@RequestMapping(value="/theend",method=RequestMethod.GET)
	public String theend(Model model) {
	return "theend";
	}
	
	
}
