# attività atomiche

## Definizione di una attività atomica

```java
public class Periodica implements Task{
	
	@Override
	public synchronized void esegui() {
		// Istruzioni attività atomica
	}
}
```

## Invocazione dell'attività atomica
```java
	Periodica p = new Periodica(autobus);
	TaskExecutor.getIstance().esegui(p);
```
