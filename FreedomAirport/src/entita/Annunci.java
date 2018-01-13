package entita;

public class Annunci {

	
	
	
	
	
	public Annunci(int codice_id, String luogo, String tipo){

		this.codice_id= codice_id;
		this.luogo= luogo; 
	    this.tipo=tipo;
	}
	public Annunci(String luogo, String tipo){

		this.luogo= luogo; 
	    this.tipo=tipo;
	}
	public Annunci(int codice_id){

		this.codice_id= codice_id;
	
	}
	
	public int getCodice_id() {
		return codice_id;
	}
	public void setCodice_id(int codice_id) {
		this.codice_id = codice_id;
	}

	public String getluogo() {
		return luogo;
	}
	public void setluogo(String luogo) {
		this.luogo = luogo;
	}

	public String getTipo() {
		return tipo;
	}
	public void settipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	@Override
	public String toString() {
		return "Annunci [tipo=" + tipo + ", codice_id=" + codice_id + ", luogo=" + luogo + "]";
	}


	private String tipo;
	private int codice_id;
	private String  luogo;
}
