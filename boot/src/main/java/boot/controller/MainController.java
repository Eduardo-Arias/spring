package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Exam;
import boot.model.GeneProduct;
import boot.model.Task;
import boot.service.ExamService;
import boot.service.GeneProductService;
import boot.service.TaskService;

@Controller
public class MainController {
  
	
	
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_TASK");
		return "task";
	}
	
	@GetMapping("exam")
	public String exam(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_EXAM");
		return "exam";
	}
	
	@GetMapping("geneProduct")
	public String geneProduct(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME_GENEPRODUCT");
		return "geneProduct";
	}
 }
