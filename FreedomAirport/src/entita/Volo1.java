package entita;

public class Volo1 {
	
	public Volo1(String codice_id){

		this.codice_id= codice_id;
	}

	



	@Override
	public String toString() {
		return "Volo1 [codice_id=" + codice_id + "]";
	}





	public String getCodice_id() {
		return codice_id;
	}
	public void setCodice_id(String codice_id) {
		this.codice_id = codice_id;
	}

	private String codice_id;
	private String ora_partenza;
}
