package lv.venta.demo.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String postProductAdd(@Valid Product product, BindingResult result)//aizpildīts produkts tiek saņemts no html lapas
	{
		//ja dati ir ievadīti pēc visiem vlidācijas noteikumiem
		if(!result.hasErrors())
		{
			Product prod = prodService.createProduct(product);
			//return "redirect:/product/all";
			return "redirect:/product/all/"+prod.getId();//izsauks /product/all/4
		}
		else
			return "add-prod-page";
		}
	
	//1.getMapping funkcija ar id
	//1.1. atlasīt konkrēto produktu, kuru vēlas updeitot
	//un to caur modeli ielik frontendā
	@GetMapping("/update/{id}")
	public String getProductUpdate(@PathVariable(name="id") int id,
			Model model)
	{
		try {
			Product prod = prodService.readById(id);
			model.addAttribute("product", prod);
			return "update-prod-page";
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error-page";//atvērs error-page.html lapu
		}
		
	}
	
	//2.izveidot html lapu (th:action- mainisies)
	
	//3.postMapping - caur servisu veicam produkta redigešanu
	//3.1.redirect uz ku citu url
	//3.2. redirect uz kāu citu error url
	@PostMapping("/update/{id}")
	public String postProductUpdate(@PathVariable(name="id") int id, 
			Product product)//redigetais produkts
	{
		try {
			prodService.updateById(id, product);
			return "redirect:/product/all/"+id;
		} catch (Exception e) {
			return "redirect:/product/all";
		}
	}
	//delete kontrolieris - pēc id
	@GetMapping("/delete/{id}")//localhost:8080/product/delete/1
	public String getProductDelete(@PathVariable(name="id") int id,
			Model model)
	{
		try {
			prodService.deleteById(id);
			model.addAttribute("package", prodService.readAllProducts());
			return "all-prod-page";
		} catch (Exception e) {
			e.printStackTrace();
			return "error-page";//parādām error-page.html
		}
	}
	//TODO - uztaisīt kontrolieru klasi ar kontrlolieru funkcijām
	//filtracijas servisu nodrošīnāšanai
	
	
}
