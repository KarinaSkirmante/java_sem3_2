package lv.venta.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.demo.model.Product;
import lv.venta.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class ProductCRUDController {
	
	@Autowired
	private ICRUDProductService prodService;
	
	@GetMapping("/all") //localhost:8080/product/all
	public String getProductAll(Model model)
	{
		ArrayList<Product> list = prodService.readAllProducts();
		model.addAttribute("package", list);
		return "all-prod-page";//parāda all-prod-page.html lapu
	}
	
	@GetMapping("/one")//localhost:8080/product/one?id=10000
	public String getProductOne(@RequestParam(name="id") int id,
			Model model)
	{
		try {
			Product temp = prodService.readById(id);
			model.addAttribute("package", temp);
			return "prod-page";//parāda prod-page.html lapu ar package
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";//atvērs error-page.html lapu
		}

	}
	
	@GetMapping("/all/{id}") //localhost:8080/product/all/1
	public String getProductById(@PathVariable(name="id") int id,
			Model model)
	{
		try {
			Product temp = prodService.readById(id);
			model.addAttribute("package", temp);
			return "prod-page";//parāda prod-page.html lapu ar package
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";//atvērs error-page.html lapu
		}
	}
	
	//1.getMapping - lai parādītu html lapu
	@GetMapping("/add") //localhost:8080/product/add
	public String getProductAdd(Product product)//tukšs produkts tiek iedots uz html lapu
	{
		return "add-prod-page";//atveram add-prod-page.html lapu ar tukšu Product objektu
	}
	//2.uztiasītr ;lapu ar ievadwes laukiem
	//3.nolasit datus no frontend bckendā - postMapping 
	@PostMapping("/add")//localhost:8080/product/add
	public String postProductAdd(Product product)//aizpildīts produkts tiek saņemts no html lapas
	{
		Product prod = prodService.createProduct(product);
		//return "redirect:/product/all";
		return "redirect:/product/all/"+prod.getId();//izsauks /product/all/4
	}
	
}
