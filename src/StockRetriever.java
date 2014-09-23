import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Scanner;

/*
 * StockRetriever.java - Uses I/O to retrieve stock information
 * from Yahoo Finance API. 
 */

public class StockRetriever {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a quote: ");
		String quote = input.next();

		try {
			// Create URL connection
			URL yahooAPI = new URL("http://finance.yahoo.com/d/quotes.csv?s="+quote+"&f=sabp");
			URLConnection connection = yahooAPI.openConnection(); 
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			
			// Parse CSV Into Array
			String line = br.readLine(); 
			String[] stockinfo = line.split(","); 
			
			// Take care of N/A number values
			//System.out.println("Stock Name: "+stockinfo[0]);
			System.out.println("Quote: "+stockinfo[0]);
			System.out.println("Ask: "+stockinfo[1]);
			System.out.println("Bid: "+stockinfo[2]);
			System.out.println("Previous Close: "+stockinfo[3]);
			
			// change to Big Decimal
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator(',');
			symbols.setDecimalSeparator('.');
			String pattern = "#,##0.0#";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
			decimalFormat.setParseBigDecimal(true);
			
			BigDecimal ask = (BigDecimal) decimalFormat.parse(stockinfo[1]);
			BigDecimal bid = (BigDecimal) decimalFormat.parse(stockinfo[2]);
			BigDecimal previousClose = (BigDecimal) decimalFormat.parse(stockinfo[3]);
			//BigDecimal open = (BigDecimal) decimalFormat.parse(stockinfo[5]);
			//BigDecimal fiftydayMV = (BigDecimal) decimalFormat.parse(stockinfo[4]);
			
			
			//System.out.println("Market Cap: "+stockinfo[3]);
			//System.out.println("50 Day MV: "+stockinfo[4]);
			//System.out.println("Market Cap: " + Long.valueOf(stockinfo[3]).longValue());
			
			// Make Stock object
			Stock stock = new Stock(stockinfo[0], ask, bid,previousClose);
			
			// Print stock details
			//System.out.println("Stock Name: "+stock.getstockName());
			System.out.println("Quote: "+stock.getSymbol());
			System.out.println("Ask: "+stock.getAsk());
			System.out.println("Bid: "+stock.getBid());
			System.out.println("Previous Close: "+stock.getpreviousClose());
			//System.out.println("Open: "+stock.getOpen());

		}
		catch (IOException io) {
        	System.err.println(io);
        	System.exit(0);
        } catch (ParseException e) {
        	System.err.println(e);
        	System.exit(0);
		}
		
	}
}
