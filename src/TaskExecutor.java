/**
 * 
 * @author skype
 * E' un tornello unico da cui passano le attività atomiche periodica
 * e rottura, garantendo che non vengano eseguite contemporaneamente
 * e che abbiano quindi accesso in muta esclusività alle classi dati.
 */
public class TaskExecutor {
	private static TaskExecutor unico;
	
	private TaskExecutor() {}
	
	/**
	 * @author skype
	 * {@summary Garantisce che vi sia un unico oggetto della classe Task Executor.}
	 */
	public static TaskExecutor getIstance() {
		if (TaskExecutor.unico == null)
			TaskExecutor.unico = new TaskExecutor();
		return TaskExecutor.unico;
	}
	
	/**
	 * @author skype
	 * @param r
	 * {@summary Esegue una r all'interno dello stesso Thread}
	 * 
	 */
	public synchronized void perform(Task r) {
		r.esegui(); // Fa eseguire nello stesso thread
	}
}
