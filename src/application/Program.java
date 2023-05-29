package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Email: ");
		String emal = scanner.next();
		
		System.out.println("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(scanner.next(), dateTimeFormatter);
		
		System.out.println("Status: ");
		String statu = scanner.next();
		
		Order order = new Order(OrderStatus.valueOf(statu), new Client(name, emal, birthDate));
		
		System.out.println("How many items to this order?");
		int numberItems = scanner.nextInt();
		
		for (int i = 1; i <= numberItems; i++) {
			System.out.println("Enter #" + i + " item data:");
			
			System.out.print("Product name: ");
			scanner.nextLine();
			String producName = scanner.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = scanner.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = scanner.nextInt();
			
			Product product = new Product(producName, productPrice);
			order.addItem(new OrderItem(quantity, product));
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		scanner.close();
	}
}
