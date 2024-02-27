import java.util.ArrayList;

public class Treno {
	private ArrayList<Vagone> treno;
	public Treno() {
		this.treno = new ArrayList<Vagone>();
	}
	/**
	 * Metodo per aggiungere vagoni al treno
	 * @param v
	 * */
	public void addVagone(Vagone v) {
		treno.add(v);
	}
	/**
	 * Metodo per vedere la lista dei vagoni nel treno
	 * @return
	 * */
	public String vagoniList() {
		String str = "";
		for(Vagone v : treno) {
			str+= v.toString()+"\n";
		}
		return str;
	}
	/**
	 * Metodo per avere la lunghezza totale del treno
	 * @return
	 * */
	public int getLunghTot() {
		int sum = 0;
		for (Vagone v : treno) {
			sum+=v.getLungh();
		}
		return sum;
	}
	/**
	 * Metodo per avere il peso totale del treno
	 * @return
	 * */
	public double getPesoTot() {
	    double sum = 0;
	    for (Vagone v : treno) {
	        sum += v.getPeso();
	    }
	    return sum;
	}
	/*
	 * Metodo per eliminare tutti i vagoni del treno
	 * **/
	public void resetTreno() {
		treno.clear();
	}
}
