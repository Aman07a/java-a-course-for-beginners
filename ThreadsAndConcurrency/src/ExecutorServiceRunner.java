import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Task1());

		executorService.execute(new Thread(new Task2()));

		System.out.print("\nTask3 Kicked Off");

		// Task3 - 301 to 399
		for (int i = 301; i <= 399; i++) {
			System.out.println(i + " ");
		}

		System.out.println("\nTask3 Done");

		System.out.print("\nMain Done");

		executorService.shutdown();

	}

}
