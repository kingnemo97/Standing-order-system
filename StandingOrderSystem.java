import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StandingOrderSystem {
	
	private Set<Product> productList;
	private Set<Customer> customerList;
	private Set<Order> orderList;
	private Set<Delivery> deliveryList;
	private Set<Invoice> invoiceList;
	private Set<Address> addressList;
	
	public StandingOrderSystem(){
		productList = new HashSet<Product>();
		customerList = new HashSet<Customer>();
		orderList = new HashSet<Order>();
		deliveryList = new HashSet<Delivery>();
		invoiceList = new HashSet<Invoice>();
		addressList = new HashSet<Address>();
	}
	
	//function to create a new product and add it to the productList
	public void addProduct(String id, String description) {
		
		boolean productExists = false;
		
		for(Product p : productList) {
			if(p.getId().equals(id)) {
				productExists = true;
				break;
			}
		}
		
		if(productExists == false) {
			Product product = new Product(id, description);
			productList.add(product);
		}
		else {
			System.out.println("Product id is already taken");
		}
	}
	
	//creates  a new customer with at least one delivery address
	public void addCustomer(String customerId, String name, String addressId, String lineOne, String lineTwo, String contactPerson, String contactPhone) {
		boolean customerExists = false;
		boolean addressExists = false;
		
		//check if customer id is already in use
		for(Customer c : customerList) {
			if(c.getId().equals(customerId)) {
				customerExists = true;
			}
		}
		
		//check if address id is already in use
		for(Address a : addressList) {
			if(a.getId().equals(addressId)) {
				addressExists = true;
			}
		}
		
		if(customerExists == false) {
			if(addressExists == false) {
				Address address = new Address(addressId,lineOne, lineTwo, contactPerson, contactPhone);
				addressList.add(address);
				Customer customer = new Customer(customerId, name, address);
				customerList.add(customer);
			}else {
				System.out.println("address id is already in use");
			}
		}else {
			System.out.println("customer id is already in use");
		}
	}
	
	//function to add a delivery address to an existing customer given an customer id
	public void addAddress(String customerId, String addressId, String lineOne, String lineTwo, String contactPerson, String contactPhone) {
		boolean customerExists = false;
		boolean addressExists = false;
		
		//check if address id is already in use
		for(Address a : addressList) {
			if(a.getId().equals(addressId)) {
				addressExists = true;
			}
		}
		
		
		if(addressExists == false) {
			//cycle through customers until customer with customerId is found
			for(Customer c : customerList) {
				if(c.getId().equals(customerId)) {
					Address address = new Address(addressId, lineOne, lineTwo, contactPerson, contactPhone);
					c.addAddress(address);
					addressList.add(address);
					customerExists = true;
				}
			}
			if(customerExists == false) {
				System.out.println("There is no customer with that id");
			}
		}else {
			System.out.println("That address id is already in use");
		}
	}
	
	//add a standing order to an existing customer
	public void addOrder(String orderId, String customerId, String addressId, String productId, Double price, List<Integer> quantity, 
						Integer startDate, Integer endDate, Status status) {
		boolean orderExists = false;
		boolean customerExists = false;
		boolean addressExists = false;
		boolean productExists = false;
		
		for(Order o : orderList) {
			if(o.getId().equals(orderId)) {
				orderExists = true;
			}
		}
		
		if(orderExists == false) {
			//find specified customer
			for(Customer c : customerList) {
				if(c.getId().equals(customerId)) {
					customerExists = true;
					//find specified address
					for(Address a : addressList) {
						if(a.getId().equals(addressId)) {
							addressExists = true;
							//find specified product
							for(Product p : productList) {
								if(p.getId().equals(productId)) {
									productExists = true;
									if(startDate.intValue() < endDate.intValue()) {
										if(quantity.size() == 7) {
											Order order = new Order(orderId, c, a, p, price, quantity, startDate, endDate, status);
											orderList.add(order);
											c.addOrder(order);
										}else {
											System.out.println("you need to enter a quantity for every day of the week");
										}
									}else {
										System.out.println("start date needs to come before end date");
									}
								}
							}
						}
					}
				}
			}
			if(customerExists == false) {
				System.out.println("there is no customer with that id");
			}
			if(customerExists == true) {
				if(addressExists == false) {
					System.out.println("there is no address with that id");
				}
			}
			if(customerExists == true) {
				if(addressExists == true) {
					if(productExists == false) {
						System.out.println("there is no product with that id");
					}
				}
			}
		}else {
			System.out.println("order id is already in use");
		}
		
	}
	
	public ArrayList<Order> listOrders(Integer date) {
		ArrayList<Order> list = new ArrayList<Order>();
		
		for(Order o : orderList) {
			if(o.getStartDate().intValue() < date.intValue()) {
				if(o.getEndDate().intValue() > date.intValue()) {
					list.add(o);
					
				}
			}
		}
		
		list = deliverySortName(list);
		list = deliverySortId(list);
		
		return list;
	}
	
	//method to sort a list of deliveries by name
	public ArrayList<Order> deliverySortName(ArrayList<Order> list){
		
		int index;
		
		for (int i = 0; i < list.size() - 1; i++)
        {
			index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getCustomer().getName().compareTo(list.get(index).getCustomer().getName()) < 0) {
                    index = j;
                }
            }
      
            Order smallerNumber = list.get(index);  
            list.set(index, list.get(i));
            list.set(i, smallerNumber);
        }
		
		return list;
	}
	
public ArrayList<Order> deliverySortId(ArrayList<Order> list){
		
		int index;
		
		for (int i = 0; i < list.size() - 1; i++)
        {
			index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getCustomer().getName().compareTo(list.get(index).getCustomer().getName()) == 0) {
                	if (list.get(j).getCustomer().getId().compareTo(list.get(index).getCustomer().getId()) < 0) {
                        index = j;
                    }
                }
            }
      
            Order smallerNumber = list.get(index);  
            list.set(index, list.get(i));
            list.set(i, smallerNumber);
        }
		
		return list;
	}
	
	public void addDelivery(String deliveryId, String customerId, String addressId, Integer date, String orderId, Integer quantity) {
		
		boolean deliveryExists = false;
		boolean customerExists = false;
		boolean addressExists = false;
		boolean orderExists = false;
		
		for(Delivery d : deliveryList) {
			if(d.getId().equals(deliveryId)) {
				deliveryExists = true;
			}
		}
		
		if(deliveryExists == false) {
			
			for(Customer c : customerList) {
				if(c.getId().equals(customerId)) {
					customerExists = true;
					for(Address a : addressList) {
						if(a.getId().equals(addressId)) {
							addressExists = true;
							for(Order o : orderList) {
								if(o.getId().equals(orderId)) {
									orderExists = true;
									DeliveryItem deliveryItem = new DeliveryItem(o, quantity, (o.getQuantity(date%7)- quantity));
									Delivery delivery = new Delivery(deliveryId, c, a, date, deliveryItem);
									deliveryList.add(delivery);
								}
							}
						}
					}
				}
			}
			if(!customerExists) {
				System.out.println("There is no customer with that id");
			}
			if(customerExists) {
				if(!addressExists) {
					System.out.println("There is no address with that id");
				}
			}
			if(customerExists) {
				if(addressExists) {
					if(!orderExists) {
						System.out.println("There is no order with that id");
					}
				}
			}
		}else {
			System.out.println("there is already a delivery with that id");
		}		
	}
	
	public Set<Product> getProductList() {
		return productList;
	}
	public void setProductList(Set<Product> productList) {
		this.productList = productList;
	}
	public Set<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(Set<Customer> customerList) {
		this.customerList = customerList;
	}
	public Set<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<Order> orderList) {
		this.orderList = orderList;
	}
	public Set<Delivery> getDeliveryList() {
		return deliveryList;
	}
	public void setDeliveryList(Set<Delivery> deliveryList) {
		this.deliveryList = deliveryList;
	}
	public Set<Invoice> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(Set<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	public Set<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}
	
	public String toString() {
		String display = "";
		
		for(Product p : productList) {
			display += p + "\n"; 
		}
		display += "\n";
		
		for(Customer c : customerList) {
			display += c + "\n";
		}
		display += "\n";
		
		for(Delivery d : deliveryList) {
			display += d + "\n";
		}
		display += "\n";
		
		
		for(Invoice i : invoiceList) {
			display += i + "\n";
		}
		display += "\n";
		
		return display;
	}

}
