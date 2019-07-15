
public class test2 implements Runnable{
	private Thread t;
	private String threadName;
	
	public test2(String threadName) {
		super();
		this.threadName = threadName;
		StringBuilder s;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			System.out.print(threadName);
		
	}
	/*public static void main(String[] 	 args) {
		
	}*/
	
	public void start(){
		if(t== null)
		{
			t= new Thread(this,threadName);
			t.start();
		}
	}

}
