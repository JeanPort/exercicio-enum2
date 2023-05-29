package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;

	public OrderItem() {
	}

	public OrderItem(Integer quantite, Product product) {
		this.quantity = quantite;
		this.price = product.getPrice();
		this.product = product;
	}

	public Integer getQuantite() {
		return quantity;
	}

	public void setQuantite(Integer quantite) {
		this.quantity = quantite;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return this.price * this.quantity;
	}

	@Override
	public String toString() {
		return this.product 
				+ ", quantity: " 
				+ this.quantity
				+ " subtotal: $"
				+ String.format("%.2f", this.subTotal());
	}
	
	
	
}
