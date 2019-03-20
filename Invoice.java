import java.util.HashSet;
import java.util.Set;

public class Invoice {

	private String id;
	private Integer fromDate;
	private Integer toDate;
	private Customer customer;
	private Set<Delivery> deliveries;
	private Double totalCost;
	private Integer payDate;
	private StatusI status;
	
	public Invoice(String id, Integer fromDate, Integer toDate, Customer customer, Double totalCost, Integer payDate, StatusI status) {
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.customer = customer;
		this.setTotalCost(totalCost);
		this.payDate = payDate;
		this.status = status;
		deliveries = new HashSet<Delivery>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getFromDate() {
		return fromDate;
	}
	public void setFromDate(Integer fromDate) {
		this.fromDate = fromDate;
	}
	public Integer getToDate() {
		return toDate;
	}
	public void setToDate(Integer toDate) {
		this.toDate = toDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Delivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	public Integer getPayDate() {
		return payDate;
	}
	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}
	public StatusI getStatus() {
		return status;
	}
	public void setStatus(StatusI status) {
		this.status = status;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
}
