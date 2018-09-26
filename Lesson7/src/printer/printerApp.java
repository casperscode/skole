package printer;

public class printerApp {

	public static void main(String[] args) {
		
		Printer kopi = new Printer();
		kopi.insertPaper(20);
		System.out.println("Number of pages in printer: " + kopi.getPaperCount());
		kopi.makeCopy(5);
		System.out.println("Number of pages in printer: " + kopi.getPaperCount());
	}

}
