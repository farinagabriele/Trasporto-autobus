/**
 * 
 * @author skype
 *{@summary Gli oggetti fired sono oggetti funtori uso e getta}
 */
public class AutobusFired implements Task {
	private Autobus autobus;
	private Evento e;
	
	public AutobusFired(Autobus autobus, Evento e) {
		super();
		this.autobus = autobus;
		this.e = e;
	}

	@Override
	public void esegui() {
		
		switch (this.autobus.stato) {
			
			case INAUTORIMESSA:
				// Uscita autorimessa
				if (e.getClass() == Uscita.class && e.getMittente().getClass() == Autista.class) {
					Autista a = (Autista) e.getMittente();
					if (this.autobus.stato == Autobus.Stato.INAUTORIMESSA) {
						if (a.getAutorizzato().contains(this.autobus.getAutorimessa())) {
							// Aggiorno l'associazione autobus-rimessa
							ManagerPosizione.rmPosizione(this.autobus, this.autobus.getAutorimessa());
							this.autobus.at = a;				// Variabile ausiliaria	
							// Aggiorno lo stato
							this.autobus.stato = Autobus.Stato.INSERVIZIO;
						}
					}
				}
				break;
				
			case INSERVIZIO:
				// entrataAutorimessa
				if (e.getClass() == Entrata.class && this.autobus.at == e.getMittente()) {
					Entrata et = (Entrata) e;
					if (this.autobus.stato == Autobus.Stato.INSERVIZIO) {
							if (this.autobus.at.getAutorizzato().contains(this.autobus)) {
								// Aggiorno lo stato
								this.autobus.stato = Autobus.Stato.INAUTORIMESSA;
								// Aggiorno l'associazione autobus-rimessa
								ManagerPosizione.addPosizione(this.autobus, et.getAutorimessa());
								//Entrata ee = new Entrata(this.autobus, et.getMittente(), et.getAutorimessa());
								//EsecuzioneEnvironment.aggiungicoda(ee);
								// Invio messaggi di entrata ad autista e autorimessa
								this.autobus.at.entrata(this.autobus);
								this.autobus.getAutorimessa().entrata(this.autobus);
							}
					}
				}
				break;
				
			case ROTTURA:
				break;
				
			case INMANUTENZIONE:
				break;
			
			default:
				break;
		}
		
		
		
		
		/*
		// rottura
		else if (this.autobus.stato == Autobus.Stato.INSERVIZIO) {
			// Aggiorno lo stato
			this.autobus.stato = Autobus.Stato.ROTTURA;
			// Aggiorno il numero di rotture dell'autista
			this.at.setRotture(this.at.getRotture() + 1);
		}
		// trasportoInAutorimessa
		else if (this.autobus.stato == Autobus.Stato.ROTTURA) {
			// Aggiorno lo stato
			this.autobus.stato = Autobus.Stato.INMANUTENZIONE;
			// Aggiorno l'associazione autobus-rimessa
			ManagerPosizione.addPosizione(this.autobus, e.getOfficina());
		}
		
		// fineManutenzione
		else if (this.autobus.stato == Autobus.Stato.INMANUTENZIONE) {
			this.autobus.stato = Autobus.Stato.INAUTORIMESSA;
			this.autobus.setTimestamp(this.autobus.getTimestamp() + 8000000);
		}
		// Periodica
		else if (this.autobus.stato == Autobus.Stato.INAUTORIMESSA) {
			if (this.autobus.getAutorimessa() != null && this.autobus.getAutorimessa().getClass() == Officina.class) {
				this.autobus.stato = Autobus.Stato.INMANUTENZIONE;
			}
		}
	*/
	}
}
