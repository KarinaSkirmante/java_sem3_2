package lv.venta.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

	@GetMapping("/simple") //localhost:8080/simple
	public String simpleFunc()
	{
		System.out.println("Kontrolieris nostrādāja");
		return "home";//ielādēs home.html lapu
	}
	
	@GetMapping("/msg")
	public String msgFunc(Model model)//vjaga, lai sūtītu datus no backend uz frontend
	{
		model.addAttribute("package", "Ziņa no JAVA Backend puses");
		System.out.println("msg kontrolieris ir izasukts");
		return "msg-page";//ielādējam msg-page.html lapu
	}
	
}
