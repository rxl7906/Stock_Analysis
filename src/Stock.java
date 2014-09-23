import java.math.BigDecimal;
/*
 * Stock.java - Represents a Stock object
 * 
 */


public class Stock {
	private String stockName;
	private String stockSymbol;
	private BigDecimal ask;
	private BigDecimal bid;
	private BigDecimal previousClose;
	private BigDecimal open;
	private BigDecimal dayLow;
	private BigDecimal dayHigh;
	
	public Stock(String stockSymbol, BigDecimal ask, BigDecimal bid, 
			BigDecimal previousClose) {
		//this.stockName = stockName;
		this.stockSymbol = stockSymbol;
		this.ask = ask;
		this.bid = bid;
		this.previousClose = previousClose;
		//this.open = open;
	}
	
	/*public String getstockName() {
		return this.stockName;
	}*/
	
	public String getSymbol() {
		return this.stockSymbol;
	}
	
	public BigDecimal getAsk() {
		return this.ask;
	}
	
	public BigDecimal getBid() {
		return this.bid;
	}
	
	public BigDecimal getpreviousClose() {
		return this.previousClose;
	}
	
	/*public BigDecimal getOpen() {
		try {
			if (open.equals(BigDecimal)){
				return 0.00;
			}
		} catch 
	}*/
	
}
