package org.hohenheim;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GreetingController { 
	@RequestMapping(method=RequestMethod.GET)
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	//System.out.println(name);
	return"index";}
	
}

