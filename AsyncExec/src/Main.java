
public class Main {

	public static void main(String[] args) {
		
		System.out.println("start...");
		
		new AsyncTask().sendData();
		
		System.out.println("end...");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("terminate...");
	}

}
