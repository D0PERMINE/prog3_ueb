package section_one;
/**
 * stellt einen deterministischen endlichen Automaten dar
 * @author Doro
 *
 */
public interface EndlicherAutomat {
	/**
	 * startet den Automaten, setzt ihn also in den Startzustand
	 * @return
	 */
	void starten();
	
	/**
	 * f�hrt einen Zustands�bergang vom aktuellen Zustand zum n�chsten
	 * aus gem�� dem �bergebenen Zeichen 
	 * @param zeichen das aktuell gelesene Zeichen des Eingabewortes
	 */
	void zustandswechsel(char zeichen);
	
	/**
	 * pr�ft, ob der Automat sich aktuell in einem akzeptierenden
	 * Zustand befindet
	 * @return true, wenn der aktuelle Zustand akzeptierend ist
	 */
	boolean akzeptiert();

	default boolean testen(String wort) {
		// erste starten
		// fuer jeden Buchstaben im Wort den Zustandswechsel durchfuehren
		// ist ein akzeptierender Zustand erreicht?
		
		starten();
		for (int i = 0; i < wort.length(); i++) {
			zustandswechsel(wort.charAt(i));			
		}
		return akzeptiert();
	}
}
