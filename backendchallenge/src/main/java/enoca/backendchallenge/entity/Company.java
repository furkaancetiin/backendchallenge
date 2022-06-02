package enoca.backendchallenge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity 
@Data
@Table(name="companies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Company {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="adress")
	private String adress;
	
	@Column(name="website")
	private String website;
	
	@OneToMany(mappedBy="company")
	private List<Employee> employees;  
	
	public Company() {
		
	}
	
	public Company(int id, String name, String adress, String website) {		
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.website = website;
	}
	
	
}
