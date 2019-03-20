public class Product {

	private String id;
	private String description;
	
	public Product(String id, String description) {
		this.setId(id);
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
		return "Id: " + id + "\nDescription: " + description;
	}
	
}
