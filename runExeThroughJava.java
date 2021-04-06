import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		int flag = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the path to Python -> ");
		String pyPath = in.nextLine();
		//C:\Program Files\Python\Python37\Python.exe 
		
		ProcessBuilder builder = new ProcessBuilder(pyPath, "-m", "timeit", "-r", "10");
		
		builder.redirectErrorStream(true);
		
	    Process process = builder.start();
	    MyThread thread = new MyThread();
	    thread.flag = 1;
	    thread.start();
	   	    
	    //����� ����������
	    try ( BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())) ) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	    }
	    
	    process.waitFor();
	    thread.flag = 2;
	    
	}
}

class MyThread extends Thread {
	
	public int flag;
	public long start;  
	MyThread(){
		start = System.currentTimeMillis();
	}
	
	public void run() {
		try {
			while (flag == 1) {
			
			long finish = System.currentTimeMillis();
			long elapsed = finish - start;
			System.out.println("������ �������, ���: " + elapsed/1000);
			Thread.sleep(1000);
			}
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
