
public class VagonePassegeri extends Vagone{
	private int maxPassegeri;
	private int passegeriAttuali;
	public VagonePassegeri(String matricola, int lungh, double pesoQ, int maxPassegeri, int passegeriAttuali) {
		super(matricola, lungh, pesoQ);
		this.maxPassegeri = maxPassegeri;
		this.passegeriAttuali = passegeriAttuali;
	}
	
	public VagonePassegeri() {
		this.setMatricola("VagonePassegeri");
		this.setLungh(500);
		this.setPesoQ(15.0);
		this.maxPassegeri = 60;
		this.passegeriAttuali = 39;
	}

	public int getMaxPassegeri() {
		return maxPassegeri;
	}
	public void setMaxPassegeri(int maxPassegeri) {
		this.maxPassegeri = maxPassegeri;
	}
	public int getPassegeriAttuali() {
		return passegeriAttuali;
	}
	public void setPassegeriAttuali(int passegeriAttuali) {
		if (passegeriAttuali >= 0 && passegeriAttuali <= 60) this.passegeriAttuali = passegeriAttuali;
		else System.out.println("Numero di passegeri non accettabile");
	}
	 public double getPeso() {
        return getPassegeriAttuali() * 70;
    }
	@Override
	public String toString() {
        return super.toString() + ", Num. Massimo Passeggeri: " + maxPassegeri + ", Num. Attuale Passeggeri: " + passegeriAttuali;
    }
}
