import java.util.concurrent.CompletableFuture;

public class AsyncTask {
	
	public void sendData() {
		 CompletableFuture.supplyAsync(this::findReceiver)
         .thenApply(this::sendMsg)
         .thenAccept(this::notify);
	}

	public String findReceiver(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("findReceiver...");
		return "findReceiver";
	}
	
	public String sendMsg(String obj) {
		System.out.println("sendMsg: " + obj);
		return "sendMsg";
		
	}
	
	public void notify(String msg) {
		System.out.println("notify: " + msg);
	}
	
}
