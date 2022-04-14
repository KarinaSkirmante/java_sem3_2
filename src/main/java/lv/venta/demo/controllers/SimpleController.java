package lv.venta.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/simple") //localhost:8080/simple
	public String simpleFunc()
	{
		System.out.println("Kontrolieris nostrādāja");
		return "home";//ielādēs home.html lapu
	}
	
}
