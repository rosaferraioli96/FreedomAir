package entita;

public class Biglietto {
 

	
	
	public Biglietto(String intestatario, int numero_posto){
		this.intestatario= intestatario;
		
	    this.numero_posto=numero_posto;
		
	}
	public Biglietto(int codice_id, String intestatario, int numero_posto){
		this.intestatario= intestatario;
		this.codice_id= codice_id;
	    this.numero_posto=numero_posto;
		
	}
	public Biglietto(Integer codice_id,  String intestatario, int numero_posto, String rif_cliente , String rif_volo){
		this.intestatario= intestatario;
		this.codice_id= codice_id;
	    this.numero_posto=numero_posto;
	    this.rif_cliente = rif_cliente;
	   this.rif_volo= rif_volo;
		
	}
	
	
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public int getNumero_posto() {
		return numero_posto;
	}
	public void setNumero_posto(int numero_posto) {
		this.numero_posto = numero_posto;
	}

	public Integer getCodice_id() {
		return codice_id;
	}
	public void setCodice_id(Integer codice_id) {
		this.codice_id = codice_id;
	}

	public String getRif_cliente() {
		return rif_cliente;
	}
	public void setRif_cliente(String rif_cliente) {
		this.rif_cliente = rif_cliente;
	}
	public int getRif_carta() {
		return rif_carta;
	}
	public void setRif_carta(int rif_carta) {
		this.rif_carta = rif_carta;
	}
	public String getRif_volo() {
		return rif_volo;
	}
	public void setRif_volo(String rif_volo) {
		this.rif_volo = rif_volo;
	}




	@Override
	public String toString() {
		return "Biglietto [codice_id=" + codice_id + ", intestatario=" + intestatario + ", rif_cliente=" + rif_cliente
				+ ", numero_posto=" + numero_posto + "]";
	}






	private Integer codice_id;
	private String intestatario;
	
	private String rif_cliente;
	private String rif_volo;
	private int numero_posto;
	private int rif_carta;


	
	
}
