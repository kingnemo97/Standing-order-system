
public class Address {
	
	private String id;
	private String lineOne;
	private String lineTwo;
	private String contactPerson;
	private String contactPhone;
	
	public Address(String id, String lineOne, String lineTwo, String contactPerson, String contactPhone) {
		this.id = id;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.contactPerson = contactPerson;
		this.contactPhone = contactPhone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLineOne() {
		return lineOne;
	}
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	public String getLineTwo() {
		return lineTwo;
	}
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	public String toString() {
		return "Id: " + id + "\nLine 1: " + lineOne + "\nLine two: " + lineTwo + "\nContact Person: " + contactPerson +
				"\nContact phone: " + contactPhone;
	}
}
