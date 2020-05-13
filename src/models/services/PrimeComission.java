package models.services;

public class PrimeComission implements ProviderComission {

	@Override
	public double comission(Double totalAmmount, Double percentage) {
		return totalAmmount * percentage;
	}
}
