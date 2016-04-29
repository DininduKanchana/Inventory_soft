package hibernateTest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;



/**
 * @author Kanchana
 *
 */
@Entity
public class product {
	@Id
	private int id;
	private String name;
	private int price;
	private String catogory;
	
	public product(){
		id = 0;
		price = 0;
		name = "";
		catogory = "";
	};
	
	public void setId(int newId){
		id = newId;
	};
		
	public int getId(){
		return id;
	};
	
	public void setName(String name){
		this.name = name ;
	};
	
	public String getName(){
		return this.name ;
	};
	
	public void setPrice(int price){
		this.price = price;
	};
	
	public int getPrice(){
		return this.price;
	};
	
	public void setCatogory(String catogory){
		this.catogory = catogory;
	};
	
	public String getCatogory(){
		return this.catogory;
	};
	

}
