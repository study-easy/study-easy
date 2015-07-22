package study_easy.org.hohenheim;

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
import study_easy.service.RegUserService;
import study_easy.users.Admin;
import study_easy.users.RegUser;

@Controller
@RequestMapping("/")
public class GreetingController {
	// TODO service objekte autowired hier aufschreiben
	@Autowired
	private RegUserService RUS;
	/*
	 * ########################## INHALTSVERZEICHNIS ##########################
	 * 1. Startseite mit Login 2. Regstrierseite 3. Password vergessen 4. Profil
	 * 5. Rechtliches 6. Home 7. Support 8. Admin 9. Snake 10.Group 11.Suche /*
	 * ########################## 1. STARTSEITE INDEX.HTML Get Aufruf
	 * 
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showForm(Model model,
			@RequestParam(value = "error", required = false, defaultValue = "null") String error) {
		RegUser reguser = new RegUser();
		// model.addAttribute("RegUser", new RegUser());
		model.addAttribute("RegUser", reguser);
		System.out.println("Index-Seite");
		if (error.length() < 5) {
			error = "";
			model.addAttribute("error", error);
		} else {
			error = "Sie haben einen Error";
			model.addAttribute("error", error);
		}

		System.out.println("start index");
		return "index";
	}

	/*
	 * ########################## STARTSEITE INDEX.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@Valid RegUser reguser, BindingResult bindingResult,
			@RequestParam(value = "name", required = true, defaultValue = "") String bname,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		System.out.println(RUS.signIn(password, bname));
		System.out.println("Benutzername: " + bname);
		System.out.println("Passwort: " + password);
		if ((bname.equals("admin")) && (password.equals("admin"))) {
			System.out.println("Sie werden erfolgreich eingeloggt");
			return "redirect:/admin";
		} else {
			if (bname.equals("bname")) {
				return "redirect:/home";
			} else {
				System.out.println("ERROR");
				return "redirect:/?error=10000";
			}
		}

		// if (bindingResult.hasErrors()) {
		// return "redirect:/test3.html";
		// }
		// return "redirect:/test2.html";
	}

	/*
	 * ########################## 2. REGESTRIEREN.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerG(Model model,
			@RequestParam(value = "error", required = false, defaultValue = "null") String error) {
		RegUser registerRegUser = new RegUser();
		// model.addAttribute("RegUser", new RegUser());
		// model.addAttribute("User", new User());
		model.addAttribute("RegUser", registerRegUser);
		System.out.println("Registrieren");
		return "register";
	}

	/*
	 * ########################## REGESTRIEREN.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String regestrieren(@Valid RegUser registerReguser, BindingResult bindingResult,
			@RequestParam(value = "name", required = true) String bname,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "passwordcheck", required = true) String passwordcheck,
			@RequestParam(value = "check", required = false) Boolean check) {
		RUS.register(password, passwordcheck, bname, password, password);
		System.out.println("Benutzername: " + bname);
		System.out.println("Passwort: " + password);
		System.out.println("WPasswort: " + passwordcheck);
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
	 * ########################## 3.PASSWORT VERGESSEN.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String forgot(Model model,
			@RequestParam(value = "error", required = false, defaultValue = "null") String error) {
		RegUser registerRegUser = new RegUser();
		// model.addAttribute("RegUser", new RegUser());
		// model.addAttribute("User", new User());
		model.addAttribute("RegUser", registerRegUser);
		registerRegUser.setEmail("Password vergessen");
		System.out.println(registerRegUser.getEmail());
		if (error.isEmpty()) {

		} else {
			error = "Sie haben einen Error";
			model.addAttribute("error", error);
		}

		System.out.println("start password vergessen");
		return "forgot";
	}

	/*
	 * ########################## PASSWORT VERGESSEN.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgotN(@Valid RegUser reguser, BindingResult bindingResult,
			@RequestParam(value = "name", required = true) String bname,
			@RequestParam(value = "sicherheitsfrage", required = true) String password) {
		System.out.println(bindingResult.hasErrors());
		System.out.println("Benutzername: " + bname);
		System.out.println("Passwort: " + password);
		if (bname.equals("bname")) {
			System.out.println("Sie werden erfolgreich eingeloggt");
			return "redirect:/";
		} else {
			System.out.println("neues Password");
			return "redirect:/?error=10000";
		}

		// if (bindingResult.hasErrors()) {
		// return "redirect:/test3.html";
		// }
		// return "redirect:/test2.html";
	}

	/*
	 * ########################## 4. PROFIL.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profil(Model model,
			@RequestParam(value = "error", required = false, defaultValue = "null") String error) {
		RegUser reguser = new RegUser();
		// model.addAttribute("RegUser", new RegUser());
		model.addAttribute("RegUser", reguser);
		System.out.println("Profil");
		if (error.length() < 5) {
			error = "";
			model.addAttribute("error", error);
		} else {
			error = "Sie haben einen Error";
			model.addAttribute("error", error);
		}

		return "profil";
	}
	/*
	 * ########################## PROFIL.HTML POST Aufruf
	 * 
	 * 
	 */

	/*
	 * ########################## 5. PRIVACY.HTML Get Aufruf Besitzt sonst
	 * nichts
	 */

	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public String privacy() {
		return "privacy";
	}

	/*
	 * ########################## 6. HOME.HTML Get Aufruf Da wo die Pinnwand ist
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(@RequestParam(value = "error", required = false, defaultValue = " a") String name,
			@RequestParam(value = "error", required = false, defaultValue = "") String error, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("name", name);
		return "home";
	}

	/*
	 * ########################## 7. SUPPORT.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/support", method = RequestMethod.GET)
	public String support(Model model) {
		Error reguser = new Error();
		model.addAttribute("Error", reguser);

		System.out.println("support");
		return "support";
	}

	/*
	 * ########################## 7. SUPPORT.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/support", method = RequestMethod.POST)
	public String senden(@Valid Error error, BindingResult bindingResult,
			@RequestParam(value = "name", required = false) String bname,
			@RequestParam(value = "problem", required = false) String problem,
			@RequestParam(value = "problemort", required = false) String problemort) {
		System.out.println("Support wird bearbeitet");

		return "redirect:/";

		// if (bindingResult.hasErrors()) {
		// return "redirect:/test3.html";
		// }
		// return "redirect:/test2.html";
	}

	/*
	 * ########################## 8. Admin.HTML Get Aufruf
	 * 
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminview(Model model) {
		Admin admin = new Admin();
		model.addAttribute("Admin", admin);
		String adminname = "Der BABO-Admin";
		model.addAttribute("name", adminname);

		System.out.println("adminseite");
		return "admin";
	}

	/*
	 * ########################## 9. LOGOUT.HTML Get Aufruf
	 * 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, @RequestParam(value = "name", required = false, defaultValue = "§") String name,
			@RequestParam(value = "delete", required = false, defaultValue = "false") Boolean delete) {
		int lange = name.length();
		if (lange > 1) {
			// mache Logout, bzw speichere alle Daten
			System.out.println("Du wirst ausgeloggt");
		}

		System.out.println("logout");
		return "logout";
	}

	/*
	 * ########################## 9. SNAKE.HTML Get Aufruf
	 * 
	 */
	@RequestMapping(value = "/snake", method = RequestMethod.GET)
	public String snake(Model model, @RequestParam(value = "name", required = false, defaultValue = "s ") String name) {
		model.addAttribute("name", name);
		System.out.println("snake");
		return "snake";
	}

	/*
	 * ########################## 10. Group.HTML Get Aufruf
	 * 
	 */
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String group(@RequestParam(value = "name", required = false, defaultValue = " ") String name, Model model) {
		model.addAttribute("error", name);
		return "group";
	}

	/*
	 * ########################## 11. SEARCH.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "name", required = false, defaultValue = " ") String name, Model model) {
		model.addAttribute("error", name);
		model.addAttribute("name", name);
		return "search";
	}

	/*
	 * ########################## 12. ProfilChange.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/profilchange", method = RequestMethod.GET)
	public String profilget(@RequestParam(value = "name", required = false, defaultValue = " ") String name,
			Model model) {
		model.addAttribute("error", name);
		RegUser reguser = new RegUser();
		model.addAttribute("RegUser", reguser);
		model.addAttribute("name", name);
		return "profilchange";
	}

	/*
	 * ########################## 12. PROFILCHANGE.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/profilchange", method = RequestMethod.POST)
	public String profilpost(@Valid RegUser reguser, BindingResult bindingResult) {
		System.out.println("Profil gespeichert");

		return "redirect:/profil";
	}

	/*
	 * ########################## 12. ProfilChange.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/profilprivat", method = RequestMethod.GET)
	public String profilprivatget(@RequestParam(value = "name", required = false, defaultValue = " ") String name,
			Model model) {
		model.addAttribute("error", name);
		RegUser reguser = new RegUser();
		model.addAttribute("RegUser", reguser);
		model.addAttribute("name", name);
		return "profilprivat";
	}

	/*
	 * ########################## 12. PROFILPRIVAT.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/profilprivat", method = RequestMethod.POST)
	public String profilprivatpost(@Valid RegUser reguser, BindingResult bindingResult) {
		System.out.println("Private Daten gespeichert");

		return "redirect:/profil";
	}

	/*
	 * ########################## 13. DELETE.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteget(@RequestParam(value = "name", required = false, defaultValue = " ") String name,
			Model model) {
		RegUser reguser = new RegUser();
		model.addAttribute("RegUser", reguser);
		model.addAttribute("name", name);
		return "delete";
	}

	/*
	 * ########################## 13. DELETE.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletepost(@Valid RegUser reguser, BindingResult bindingResult,
			@RequestParam(value = "check", required = false) Boolean check) {

		if (check == true) {
			// account sperren/löschen lassen
			return "redirect:/logout?delete=true";
		}
		System.out.println("Private Daten gespeichert");

		return "redirect:/home";
	}

	/*
	 * ########################## 14. Combat.HTML Get Aufruf
	 *
	 */
	@RequestMapping(value = "/combat", method = RequestMethod.GET)
	public String comabt(Model model) {
		RegUser reguser = new RegUser();
		Group group = new Group();
		String status = "Dein status"; // z.b zum aktuellen Combat gehen oder
										// Combat starten
		Combat combat = new Combat();
		model.addAttribute("Combat", combat);
		model.addAttribute("status", status);
		return "combat";
	}

	/*
	 * ########################## 13. DELETE.HTML Post Aufruf
	 *
	 */
	@RequestMapping(value = "/combat", method = RequestMethod.POST)
	public String combatpost(@RequestParam(value = "check", required = false) Boolean check) {

		if (check == true) {
			// account sperren/löschen lassen
			return "redirect:/logout?delete=true";
		}
		System.out.println("Private Daten gespeichert");

		return "redirect:/home";
	}
	/*
	 *
	 * @RequestMapping(value="/", method=RequestMethod.GET) public String
	 * showForm2(@RequestParam(value="name", required=false,
	 * defaultValue="World") String name, Model model) {
	 * model.addAttribute("name", name); return "index"; }
	 * 
	 */
	// @RequestMapping(value="/", method=RequestMethod.POST)
	// public String checkPersonInfo(@Valid RegUser reguser, BindingResult
	// bindingResult) {
	// System.out.println(bindingResult.hasErrors());
	// System.out.println("reguser");
	// if (bindingResult.hasErrors()) {
	// return "index";
	// }
	// return "redirect:/test2.html";
	// }

	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String greeting4(@RequestParam(value = "name", required = false, defaultValue = " ") String name,
			Model model) {
		model.addAttribute("name", name);

		// System.out.println(name);
		return "test3";
	}
}
