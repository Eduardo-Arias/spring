package mx.utng.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="cel_phone")
public class CelPhone {
	@Id @GeneratedValue
	private Long id;
	private String model;
	private String number;
	private String price;
	
	public CelPhone(String model, String number, String price) {
		super();
		this.model = model;
		this.number = number;
		this.price = price;
	}
	
	public CelPhone() {
		this("","","");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CelPhone [id=" + id + ", model=" + model + ", number=" + number + ", price=" + price + "]";
	}
	
	
}
