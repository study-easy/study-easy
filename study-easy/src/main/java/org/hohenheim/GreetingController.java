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
	
	@RequestMapping(value = "/index.html" ,method=RequestMethod.GET)
	public String greeting2(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	return"index";}
	
	@RequestMapping(value = "/test2.html" , method=RequestMethod.POST)
	public String testen(Model model ,@RequestParam(value="bar", required=false ,defaultValue="h") String name){
		System.out.println(name);
		model.addAttribute("name2", name);
		 return"test2";
	}
	
	@RequestMapping(value = "/test2.html" , method=RequestMethod.GET)
	public String greeting3(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	return"test2";}
	
	@RequestMapping(value = "/test3.html" , method=RequestMethod.GET)
	public String greeting4(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	model.addAttribute("name", name);
	return"test3";}
	
}

