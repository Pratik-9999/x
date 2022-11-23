
public class Table {

/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the address
	 */
	public int getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(int address) {
		this.address = address;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

String symbol;
int address;
int index;


public Table(String symbol, int address, int index) {
	
	this.symbol = symbol;
	this.address = address;
	this.index = index;
}

public Table(String symbol, int address) {
	
	this.symbol = symbol;
	this.address = address;
	index=0;
}


}
