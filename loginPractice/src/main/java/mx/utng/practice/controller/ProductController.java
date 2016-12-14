package mx.utng.practice.controller;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import mx.utng.practice.model.Product;
import mx.utng.practice.repository.ProductRepository;



@Named
@ViewScoped
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	private Product product=new Product();
	private List<Product>products;
	private boolean editMode=false;
	
	@PostConstruct
	public void init(){
		setProducts(productRepository.findAll());
	}

	public void save(){
		productRepository.save(product);
		if(!editMode){
			getProducts().add(product);
		}
		product=new Product();
		setEditMode(false);
	}
	
	public void delete(Product product){
		productRepository.delete(product);
		products.remove(product);
	}
	public void update(Product product){
		setProduct(product);
		setEditMode(true);
	}
	public void cancel(){
		product =new Product();
		setEditMode(false);
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
}
