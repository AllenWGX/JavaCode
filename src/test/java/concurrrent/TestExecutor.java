package concurrrent;

import org.junit.*;
import java.util.concurrent.*;

class MyJob implements Runnable{
	private String typeName;
	
	public MyJob(String typeName){
		this.typeName = typeName;
	}
	
	@Override
	public void run() {
		synchronized(this){
			System.out.println(typeName);
			System.out.println(Thread.currentThread().getId());
		}
	}
	
}
/***
 *	Test Different Thread Pool 
 */
public class TestExecutor {
	private static int NUM_CORE = 2;
	@Test
	public void testFixExecutor(){
		ExecutorService executor = Executors.newFixedThreadPool(NUM_CORE);
		for(int i = 0; i < NUM_CORE; ++i){
			executor.execute(new MyJob("Fix"));
		}
		executor.shutdown();
	}
	
	@Test
	public void testCachedExecutor(){
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i < NUM_CORE; ++i){
			executor.execute(new MyJob("Cache"));
		}
		executor.shutdown();
	}
	
	@Test
	public void testSingleExecutor(){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i = 0; i < NUM_CORE; ++i){
			executor.execute(new MyJob("Single"));
		}
		executor.shutdown();
	}
	
	@Test
	public void testScheduleExecutor() throws InterruptedException{
		ExecutorService executor = Executors.newScheduledThreadPool(NUM_CORE);
		executor.awaitTermination(10, TimeUnit.SECONDS);
		for(int i = 0; i < NUM_CORE; ++i){
			executor.execute(new MyJob("Schedule"));
		}
		executor.shutdown();
	}
}
