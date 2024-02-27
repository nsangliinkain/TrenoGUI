
public abstract class Vagone {
	protected String matricola;
	protected int lungh;
	protected double pesoQ;
	public Vagone() {
		this.matricola = "Vagone1";
		this.lungh = 500;
		this.pesoQ = 15.0;
	}
	public Vagone(String matricola, int lungh, double pesoQ) {
		this.matricola = matricola;
		this.lungh = lungh;
		this.pesoQ = pesoQ;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public int getLungh() {
		return lungh;
	}
	public void setLungh(int lungh) {
		this.lungh = lungh;
	}
	public double getPesoQ() {
		return pesoQ;
	}
	public void setPesoQ(double pesoQ) {
		this.pesoQ = pesoQ;
	}
	public abstract double getPeso();
	@Override
	public String toString() {
        return "Matricola: " + matricola + ", Lunghezza: " + lungh + ", Peso Vuoto: " + pesoQ;
    }
}
