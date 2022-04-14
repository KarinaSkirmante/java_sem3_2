package lv.venta.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.demo.model.Product;

@Controller
public class SimpleController {

	private ArrayList<Product> allProducts = new ArrayList<>(
			Arrays.asList(
					new Product("Maize", 2.13f, 3), 
					new Product("Ūdens", 0.56f, 100), 
					new Product("Telefons", 600.99f, 2) ));
	
	
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
	
	@GetMapping("/object")//localhost:8080/object
	public String objectFunc(Model model)
	{
		Product product = new Product("Abols", 0.99f, 100);
		model.addAttribute("package", product);
		return "prod-page";//ielādējām prod-page.html lapu ar package sūtījumu
	}
	@GetMapping("/list")//localhost:8080/list
	public String listFunc(Model model)
	{
		model.addAttribute("package", allProducts);
		return "all-prod-page";//ielādēs all-prod-pge.html lapu
	}
	//all-prod-page
	
	
	//@requestParam   url-> /all-product?id=1
}
