package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.GeneProduct;
import boot.service.GeneProductService;


@Controller
public class GenProductController {
	@Autowired
	private GeneProductService geneProductService;
	
	@GetMapping("/all-geneProducts")
	public String allGeneProducts(HttpServletRequest request){
		request.setAttribute("geneProducts", geneProductService.findAll());
		request.setAttribute("mode", "MODE_GENE_PRODUCTS");
		return "geneProduct";
	}
	
	@GetMapping("/new-geneProduct")
	public String newGeneProduct(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "geneProduct";
	}
	
	@PostMapping("/save-geneProduct")
	public String saveGeneProduct(@ModelAttribute GeneProduct geneProduct, BindingResult bindingResult, HttpServletRequest request){
		geneProductService.save(geneProduct);
		request.setAttribute("geneProducts", geneProductService.findAll());
		request.setAttribute("mode", "MODE_GENE_PRODUCTS");
		return "geneProduct";
	}
	
	@GetMapping("/update-geneProduct")
	public String updateGeneProduct(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("geneProduct", geneProductService.findGeneProduct(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "geneProduct";
	}
	
	@GetMapping("/delete-geneProduct")
	public String deleteGeneProduct(@RequestParam int id, HttpServletRequest request){
		geneProductService.delete(id);
		request.setAttribute("geneProducts", geneProductService.findAll());
		request.setAttribute("mode", "MODE_GENE_PRODUCTS");
		return "geneProduct";
	}
}
