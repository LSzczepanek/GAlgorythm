package mainModule;

public class Individual {

	
	Chromosom chromosom;
	
	public Individual(byte chromosom) {
		
		this.chromosom = new Chromosom(chromosom);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return chromosom.toString();
	}
}
