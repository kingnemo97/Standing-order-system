import java.util.HashSet;
import java.util.Set;

public class Delivery {

	private String id;
	private Customer customer;
	private Address address;
	private Integer date;
	private Integer dayOfWeek;
	private Set<DeliveryItem> deliveryItems;
	
	public Delivery(String id, Customer customer, Address address, Integer date, DeliveryItem deliveryItem) {
		this.id = id;
		this.customer = customer;
		this.address = address;
		this.date = date;
		this.dayOfWeek = (date.intValue()%7);
		deliveryItems = new HashSet<DeliveryItem>();
		deliveryItems.add(deliveryItem);
	}
	
	public void addDeliveryItem(DeliveryItem deliveryItem) {
		deliveryItems.add(deliveryItem);
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
	public Integer getDate() {
		return date;
	}
	public Integer getDateInt() {
		return date.intValue();
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Set<DeliveryItem> getDelivveryItems() {
		return deliveryItems;
	}
	public void setDelivveryItems(Set<DeliveryItem> delivveryItems) {
		this.deliveryItems = delivveryItems;
	}
	
	public String toString() {
		
		String deliveryItems = "";
		
		for(DeliveryItem d : this.deliveryItems) {
			deliveryItems += d + "\n";
		}
		
		return "Id: " + id + "\nCustomer Id: " + customer.getId() + "\nAddressId: " + address.getId() + 
				"\nDate: " + date.intValue() + "\n" + deliveryItems;
	}
}
