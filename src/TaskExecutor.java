
public class TaskExecutor {
	private static TaskExecutor unico;
	
	public static TaskExecutor istanza() {
		if (unico == null)
			unico = new TaskExecutor();
		return unico;
	}
	
	public synchronized void esegui(Task r) {
		r.esegui(); // Fa eseguire nello stesso thread
	}
}
