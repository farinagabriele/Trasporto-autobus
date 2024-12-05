# Schema comportamento
- Creo un Thread per ogni oggetto reattivo (devono essere tutti indipendenti gli uni dagli altri).
- Ogni messaggio è un evento: Estendono dalla classe Event che come campi ha mittente e destinatario.
- Ogni oggetto che può ricevere un messaggio implementa l'interfaccia Listener
- Devo gestire una coda degli eventi
## Invio di un messaggio
L'oggetto che vuole inviare un messaggio inserisce un evento nella coda, firmandosi come mittente
## Ricezione di un messaggio
Il Thread dell'oggetto reattivo legge continuamente la coda degli eventi in attesa di un messaggio diretto a lui.

- Se lo trova chiama il metodo fired passandogli come argomento l'evento.

- Altrimenti si mette in attesa.

## Sincronizzazione 

