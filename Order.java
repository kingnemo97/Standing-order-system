import java.util.List;

public class Order {
	
	private String id;
	private Customer customer;
	private Address address;
	private Product product;
	private Double price;
	private List<Integer> quantities;
	private Integer startDate;
	private Integer endDate;
	private Status status;
	
	public Order(String id, Customer customer, Address address, Product product, Double price, List<Integer> quantities,
			Integer startDate, Integer endDate, Status status) {
		this.id = id;
		this.customer = customer;
		this.address = address;
		this.product = product;
		this.setPrice(price);
		this.quantities = quantities;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Integer> getQuantities() {
		return quantities;
	}
	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
	}
	public Integer getStartDate() {
		return startDate;
	}
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}
	public Integer getEndDate() {
		return endDate;
	}
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity(int index) {
		return quantities.get(index);
	}
	
	public String listQuantities() {
		return "\tMonday: " + quantities.get(0) + "\n\tTuesday: " + quantities.get(1) + "\n\tWednesday: "  + quantities.get(2) + 
				"\n\tThursday: "  + quantities.get(3) + "\n\tFriday: " + quantities.get(4) + "\n\tSaturday: "  + quantities.get(5) + 
				"\n\tSunday: "  + quantities.get(6);
	}
	
	public String toString() {
		String quantities = listQuantities();
		
		return "Id: " + id + "\nCustomer Id: " + customer.getId() + "\nAddress Id: " + address.getId() +
				"\nProduct Id: " + product.getId() + "\nPrice: " + price + "\nQuantities: \n" + quantities + "\nStart date: " + startDate +
				"\nEnd date: " + endDate + "\nStatus: " + status;
	}
	
	
	

}
