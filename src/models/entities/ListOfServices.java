package models.entities;

public class ListOfServices {
	
	private Services service;
	private Double time;
	
	public ListOfServices() {
		}

	public ListOfServices(Services service, Double time) {
		this.service = service;
		this.time = time;
	}

	public Double getTime() {
		return time;
	}

	public void setHours(Double time) {
		this.time = time;
	}

	public void setService(Services service) {
		this.service = service;
	}
	
	public Services getService() {
		return service;
	}

	private Double subTotal() {
		return service.getPrice() * time;
	}
	
	public Double getSubTotal() {
		return subTotal();
	}
}
