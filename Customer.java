import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private String id;
	private String name;
	private HashSet<Address> addresses;
	private HashSet<Order> orders;
	
	public Customer(String id, String name, Address address) {
		this.id = id;
		this.name = name;
		addresses = new HashSet<Address>();
		addresses.add(address);
		orders = new HashSet<Order>();
	}
	
	public void addAddress(Address address) {
		addresses.add(address);
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(HashSet<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}
	
	public String toString() {
		String addresses = "";
		String orders = "";
		
		for(Address a : this.addresses) {
			addresses += a + "\n";
		}
		
		for(Order o : this.orders) {
			orders += o + "\n";
		}
		
		return "Id: " + id + "\nName: " + name + "\n" + addresses + "\n" + orders;
	}
}
