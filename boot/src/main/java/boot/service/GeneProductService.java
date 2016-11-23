package boot.service;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.GeneProductRepository;
import boot.model.GeneProduct;

@Service @Transactional
public class GeneProductService {
	private final GeneProductRepository geneProductRepository;
	
	public GeneProductService(GeneProductRepository geneProductRepository) {
		super();
		this.geneProductRepository = geneProductRepository;
	}
	
	public List<GeneProduct> findAll(){
		List<GeneProduct> geneProducts = new ArrayList<GeneProduct>();
		for(GeneProduct geneProduct : geneProductRepository.findAll()){
			geneProducts.add(geneProduct);
		}
		return geneProducts;
	}
	
	public void save(GeneProduct geneProduct){
		geneProductRepository.save(geneProduct);
	}
	
	public void delete(int id){
		geneProductRepository.delete(id);
	}
	
	public GeneProduct findGeneProduct(int id){
		return geneProductRepository.findOne(id);
	}
}
