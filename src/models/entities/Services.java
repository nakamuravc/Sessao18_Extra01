package models.entities;

import models.entities.enums.TypeOfServices;

public class Services {

	private TypeOfServices typeOfService;
	private Double price;
	
	
	public Services() {
	}

	public Services(TypeOfServices typeOfService, Double price) {
		this.typeOfService = typeOfService;
		this.price = price;
	}

	public TypeOfServices getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(TypeOfServices typeOfService) {
		this.typeOfService = typeOfService;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
