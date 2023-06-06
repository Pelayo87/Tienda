package Tienda;

public class StockInsuficiente extends Exception {
	private static final long serialVersionUID = 1L;

	public StockInsuficiente(String message) {
        super(message);
    }
}
