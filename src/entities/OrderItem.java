package entities;

public class OrderItem {

	private Integer quantite;
	private Double price;
	
	private Product product;

	public OrderItem() {
	}

	public OrderItem(Integer quantite, Product product) {
		this.quantite = quantite;
		this.price = product.getPrice();
		this.product = product;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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
		return this.price * this.quantite;
	}

	@Override
	public String toString() {
		return this.product 
				+ ", quantity: " 
				+ this.quantite
				+ " subtotal: $"
				+ String.format("%.2f", this.subTotal());
	}
	
	
	
}
