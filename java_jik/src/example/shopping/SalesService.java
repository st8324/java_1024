package example.shopping;

import java.util.List;
import java.util.function.Predicate;

public interface SalesService {
	
	Sales inputSales(String type);

	void printByYear(List<Sales> salesList);
	
	void printByMonth(List<Sales> salesList);
	
	void printByDay(List<Sales> salesList);

	void printSales(List<Sales> salesList, Predicate<Sales> p);

}
