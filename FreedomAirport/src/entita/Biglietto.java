package entita;

public class Biglietto {
 

	
	
	public Biglietto( Integer codice_id , String intestatario, String compagnia_aerea , String classe ,int numero_posto, float costo, String rif_cliente, int rif_carta,int rif_volo){
		
		this.intestatario= intestatario;
		this.compagnia_aerea= compagnia_aerea; 
		this.classe=classe;
	    this.numero_posto=numero_posto;
		this.costo=costo;
	    this.codice_id = codice_id;
	    this.rif_cliente = rif_cliente;
	    this.rif_carta = rif_carta;
	    this.rif_volo = rif_volo;


	}
	
	
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public String getCompagnia_aerea() {
		return compagnia_aerea;
	}
	public void setCompagnia_aerea(String compagnia_aerea) {
		this.compagnia_aerea=  compagnia_aerea;
	}

	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe=  classe;
	}
	public int getNumero_posto() {
		return numero_posto;
	}
	public void setNumero_posto(int numero_posto) {
		this.numero_posto=  numero_posto;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo=  costo;
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
	public int getRif_volo() {
		return rif_volo;
	}
	public void setRif_volo(int rif_volo) {
		this.rif_volo = rif_volo;
	}





	@Override
	public String toString() {
		return "Biglietto [codice_id=" + codice_id + ", intestatario=" + intestatario + ", compagnia_aerea="
				+ compagnia_aerea + ", classe=" + classe + ", numero_posto=" + numero_posto + ", costo=" + costo
				+ ", rif_cliente=" + rif_cliente + ", rif_carta=" + rif_carta + ", rif_volo=" + rif_volo + "]";
	}





	private Integer codice_id;
	private String intestatario;
	
	private String  compagnia_aerea ;
	private String classe;
    
	private int numero_posto;
	private float costo;

	private String rif_cliente;
	private int rif_carta;
	private int rif_volo;

	
	
}
