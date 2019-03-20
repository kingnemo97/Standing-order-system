
public class DeliveryItem {
	
	private Order order;
	private Integer quantity;
	private Integer difference;
	
	public DeliveryItem(Order order, Integer quantity, Integer difference) {
		this.order = order;
		this.quantity = quantity;
		this.difference = difference;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getDifference() {
		return difference;
	}
	public void setDifference(Integer difference) {
		this.difference = difference;
	}
	
	public String toString() {
		return "Order Id: " + order.getId() + "\nQuantitiy: " + quantity.intValue() + "\nDifference: " + difference.intValue();
	}
	
}
