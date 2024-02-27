
public class VagoneMerci extends Vagone{
	private double maxPesoQ;
	private double pesoAttualeQ;
	
	public VagoneMerci(String matricola, int lungh, double pesoQ, double maxPesoQ, double pesoAttualeQ) {
		super(matricola, lungh, pesoQ);
		this.maxPesoQ = maxPesoQ;
		this.pesoAttualeQ = pesoAttualeQ;
	}
	public VagoneMerci() {
		this.setMatricola("VagoneMerci");
		this.setLungh(500);
		this.setPesoQ(15.0);
		this.maxPesoQ =  50.0;
		this.pesoAttualeQ = 10.0;
	}
	public double getMaxPesoQ() {
		return maxPesoQ;
	}
	public void setMaxPesoQ(double maxPesoQ) {
		if (maxPesoQ > 0) this.maxPesoQ = maxPesoQ;
		else System.out.println("Peso inserito non accettabile, poiché minore di 0");
	}
	public double getPesoAttualeQ() {
		return pesoAttualeQ;
	}
	public void setPesoAttualeQ(double pesoAttualeQ) {
		if (pesoAttualeQ > 0) this.pesoAttualeQ = pesoAttualeQ;
		else System.out.println("Peso inserito non accettabile, poiché minore di 0");
	}
	public double getPeso() {
        return getPesoAttualeQ();
    }
	@Override
	public String toString() {
        return super.toString() + ", Carico Massimo: " + maxPesoQ + ", Carico Attuale: " + pesoAttualeQ;
    }
	
	
}
