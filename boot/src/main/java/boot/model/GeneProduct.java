package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="gene_product")
public class GeneProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=128)
	private String symbol;
	@Column(name="dbxref_id")
	private int dbxrefId;
	@Column(name="species_id")
	private int speciesId;
	@Column(name="type_id")
	private int typeId;
	@Column(length=45)
	private String fullName;
	
	
	public GeneProduct(String symbol, int dbxrefId, int speciesId, int typeId, String fullName) {
		super();
		this.symbol = symbol;
		this.dbxrefId = dbxrefId;
		this.speciesId = speciesId;
		this.typeId = typeId;
		this.fullName = fullName;
	}

	public GeneProduct() {
		this("",0,0,0,"");
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public int getDbxrefId() {
		return dbxrefId;
	}


	public void setDbxrefId(int dbxrefId) {
		this.dbxrefId = dbxrefId;
	}


	public int getSpeciesId() {
		return speciesId;
	}


	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	@Override
	public String toString() {
		return "GeneProduct [id=" + id + ", symbol=" + symbol + ", dbxrefId=" + dbxrefId + ", speciesId=" + speciesId
				+ ", typeId=" + typeId + ", fullName=" + fullName + "]";
	}
	
	
	
	

}
