package models.services;

import models.entities.ProvidedServices;


public class ProvisionService {

	private ProvidedServices providedServices;
	private ProviderComission providerComission;
	
	public ProvisionService() {
		}
	
	public ProvisionService(ProvidedServices providedServices, ProviderComission providerComission) {
		this.providedServices = providedServices;
		this.providerComission = providerComission;
	}
	
	public void processingComission(ProvidedServices providedServices) {
		String provider = String.valueOf(providedServices.getProvider());
		Double percentage;
		if (provider == "SAMANTHA") {
			percentage = 0.5;	
		}
		else if (provider == "AVA") {
			percentage = 0.4;
		}
		else {
			percentage = 0.35;
		}
		
		Double total = providedServices.getTotal();
		
		Double comission = providerComission.comission(total, percentage);
		
		providedServices.setComission(comission);

	}
}
