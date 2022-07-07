import java.util.Calendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create product object and manage product related operations*/

public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	
	
	//construct product
	public Product(String sName, java.util.Calendar sDate, double price) {
		productName = sName;
		saleDate = sDate;
		this.price = price;
	}
	//get productName
	public String getProductName() {
		return productName;
	}
	//set productName
	public void setProductName(String productName) {
		this.productName = productName;
	}
	//get saleDate
	public java.util.Calendar getSaleDate() {
		return saleDate;
	}
	//set saleDate
	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}
	//get price
	public double getPrice() {
		return price;
	}
	//set price
	public void setPrice(double price) {
		this.price = price;
	}
	//return string information about product
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", transactionDate=" + saleDate.get(Calendar.DATE) + "/" + (saleDate.get(Calendar.MONTH) + 1) + "/" + saleDate.get(Calendar.YEAR) + ", price=" + price + "]";
	}
	
	
}
