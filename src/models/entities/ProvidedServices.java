package models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.entities.enums.Providers;

public class ProvidedServices {
	
	private Client client;
	private Providers provider;
	private Double comission;
	private Date date;
	private List<ListOfServices> list = new ArrayList<>();
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<ListOfServices> getList() {
		return list;
	}

	public void setList(List<ListOfServices> list) {
		this.list = list;
	}

	public ProvidedServices() {
	}
		
	public ProvidedServices(Client client, Providers provider, Date date) {
		this.client = client;
		this.provider = provider;
		this.date = date;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Providers getProvider() {
		return provider;
	}

	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	private Double total() {
		Double total = 0.0;
		for (ListOfServices i : list) {
			total += i.getSubTotal();
		}
		return total;
	}

	public Double getTotal() {
		return total();
	}


	public Double getComission() {
		return comission;
	}

	public void setComission(Double comission) {
		this.comission = comission;
	}


	
	 
}
