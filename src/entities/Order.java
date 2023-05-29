package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();

	public Order(OrderStatus status, Client client) {
		this.moment = LocalDateTime.now();
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}


	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removerItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public double total() {
		double sum = 0.00;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		
		String strItem = "";
		for (OrderItem item : items) {
			strItem += item + "\n";
		}
		return "Order moment: "
				+ moment.format(dtf)
				+ "\n"
				+ "Order Statud: " + this.status
				+ "\n"
				+ "Client: " + this.client
				+ "\n"
				+ "Order Items: \n"
				+ strItem
				+ "Total price: $" + String.format("%.2f", this.total());
	}
	
	
}
