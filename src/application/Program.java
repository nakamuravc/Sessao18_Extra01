package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Client;
import models.entities.ListOfServices;
import models.entities.ProvidedServices;
import models.entities.Services;
import models.entities.enums.Providers;
import models.entities.enums.TypeOfServices;
import models.services.PrimeComission;
import models.services.ProvisionService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<ListOfServices> list = new ArrayList<>();
		
		System.out.println("Enter client data: ");
		System.out.print("Client Name: ");
		String name = sc.next();
		System.out.print("Client Age: ");
		int age = sc.nextInt();
		System.out.print("Client Gender (M/F): ");
		char gender = sc.next().charAt(0);
		sc.nextLine();
		
		System.out.println("Enter services data: ");
		System.out.print("Date of services: ");
		Date date = sdf.parse(sc.nextLine());
		System.out.println("Name of attendant: ");
		String provider = sc.next();
		ProvidedServices pS = new ProvidedServices(new Client(name, age, gender), Providers.valueOf(provider), date);
		System.out.print("Number of services provided: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print("Type of #" + i + " service: ");
			String typeOfService = sc.next();
			System.out.print("Price per hour: ");
			double price = sc.nextDouble();
			System.out.print("Time of service: ");
			double time = sc.nextDouble();
			Services services = new Services(TypeOfServices.valueOf(typeOfService), price);
			ListOfServices lOS = (new ListOfServices(services, time)); 
			list.add(lOS);
		}
		pS.setList(list);
		ProvisionService provisionService = new ProvisionService(pS, new PrimeComission());
		
		provisionService.processingComission(pS);
		
		System.out.println("Summary of Provided Services: ");
		for (ListOfServices l : list) {
			System.out.printf("Provider: %s, service: %s, time: %.1f, subtotal: %.2f%n"
								,pS.getProvider()
								,l.getService().getTypeOfService()
								,l.getTime()
								,l.getSubTotal());
		}
		System.out.printf("TOTAL : $%.2f%n", pS.getTotal());
		System.out.println();
		System.out.println("Gerential Summary: ");
		System.out.print("Paid Comissions: ");
		System.out.printf("%s%.2f",pS.getProvider(), pS.getComission());
		
		sc.close();
	}

}
