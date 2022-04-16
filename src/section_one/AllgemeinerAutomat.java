//package section_one;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * ein allgemeiner endlicher Automat, bei dem man die 
// * Zustands�bergangsfunktion im Konstruktor angeben kann
// * @author Doro
// *
// */
//public class AllgemeinerAutomat implements EndlicherAutomat {
//
//	private int zustand;
//	private int[] akzeptierend;
//	private Map<Integer, Map<Character, Integer>> funktion
//		= new HashMap<>();
//	
//	/**
//	 * erstellt den Automaten, Startzustand ist immer 0
//	 * @param uebergang �bergangsfunktion in folgendem Format:
//	 * 					uebergang[i] enth�lt die �berg�nge f�r den Zustand i
//	 * 					Aufbau von uebergang[i]:
//	 * 						zeichen1->folgezustand, zeichen2->folgezustand, zeichen3->folgezustand,...
//	 * 					-1 kann dabei als Fehlerzustand ohne Folgezust�nde angegeben werden
//	 * 					fehlende �berg�nge f�r nicht im zu pr�fenden String erlaubte Zeichen d�rfen weggelassen werden
//	 * @param akzeptierend Liste der akzeptierenden Zust�nde
//	 * @throws IndexoutOfBoundsException, falls die Strings der
//	 * 									�bergangsfunktion nicht korrekt aufgebaut sind
//	 * @throws NumberFormatException, falls ein Folgeszustand nicht als Int-Zahl angegeben wurde
//	 */
//	public AllgemeinerAutomat(String[] uebergang, int[] akzeptierend)
//	{
//		this.akzeptierend = akzeptierend;
//		for(int z = 0; z < uebergang.length; z++)
//		{
//			Map<Character, Integer> vonZAus = new HashMap<>();
//			String[] zerlegt = uebergang[z].split(", ");
//			for(int einzeln =0; einzeln < zerlegt.length; einzeln++)
//			{
//				char zeichen = zerlegt[einzeln].charAt(0);
//				int folgezustand = Integer.parseInt(zerlegt[einzeln].substring(3));
//				vonZAus.put(zeichen, folgezustand);
//			}
//			funktion.put(z, vonZAus);
//		}
//		
//	}
//	
//	@Override
//	public void starten() {
//		zustand = 0;
//	}
//
//	@Override
//	public void zustandswechsel(char zeichen) {
//		try {
//			zustand = funktion.get(zustand).get(zeichen);
//		} catch (NullPointerException e)
//		{
//			zustand = -1;
//		}
//
//	}
//
//	@Override
//	public boolean akzeptiert() {
//		for(int i=0; i< akzeptierend.length; i++)
//			if(zustand == akzeptierend[i])
//				return true;
//		return false;
//	}
//
//}
