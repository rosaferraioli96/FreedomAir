package entita;

public class Volo {


	
	public Volo(String codice_id, String luogo_partenza, String data_partenza, String ora_partenza,  String luogo_arrivo, String  data_arrivo, String ora_arrivo, float costo){

		this.codice_id= codice_id;
		this.luogo_partenza= luogo_partenza; 
		this.data_partenza=data_partenza;
		this.ora_partenza=ora_partenza;
		this.luogo_arrivo= luogo_arrivo; 
		this.data_arrivo=data_arrivo;
		this.ora_arrivo=ora_arrivo;
		this.costo=costo;
	}
	public Volo(String luogo_partenza, String data_partenza, String ora_partenza,  String luogo_arrivo, String  data_arrivo, String ora_arrivo, float costo){

		this.luogo_partenza= luogo_partenza; 
		this.data_partenza=data_partenza;
		this.ora_partenza=ora_partenza;
		this.luogo_arrivo= luogo_arrivo; 
		this.data_arrivo=data_arrivo;
		this.ora_arrivo=ora_arrivo;
		this.costo=costo;

	}


	public Volo(String luogo_partenza, String luogo_arrivo, String data_partenza, String data_arrivo ){
		this.luogo_partenza= luogo_partenza; 
		this.data_partenza=data_partenza;
		this.luogo_arrivo= luogo_arrivo; 
		this.data_arrivo=data_arrivo;
	}
	
	public Volo(String codice_id){

		this.codice_id= codice_id;
	}


	
	public String getCodice_id() {
		return codice_id;
	}
	public void setCodice_id(String codice_id) {
		this.codice_id = codice_id;
	}

	public String getLuogo_partenza() {
		return luogo_partenza;
	}
	public void setLuogo_partenza(String luogo_partenza) {
		this.luogo_partenza=  luogo_partenza;
	}

	public String getData_partenza() {
		return data_partenza;
	}
	public void setData_partenza(String data_partenza) {
		this.data_partenza=  data_partenza;
	}

	public String getOra_partenza() {
		return ora_partenza;
	}
	public void setOra_partenza (String ora_partenza) {
		this.ora_partenza=  ora_partenza;
	}


	public String getLuogo_arrivo() {
		return luogo_arrivo;
	}
	public void setLuogo_arrivo(String luogo_arrivo) {
		this.luogo_arrivo=  luogo_arrivo;
	}

	public String getData_arrivo () {
		return data_arrivo;
	}
	public void setData_arrivo (String data_arrivo ) {
		this.data_arrivo =  data_arrivo ;
	}

	public String getOra_arrivo() {
		return ora_arrivo;
	}
	public void setOra_arrivo(String ora_arrivo) {
		this.ora_arrivo=  ora_arrivo;
	}




	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo=  costo;
	}




	@Override
	public String toString() {
		return "Volo [codice_id=" + codice_id + ", luogo_partenza=" + luogo_partenza + ", data_partenza="
				+ data_partenza + ", ora_partenza=" + ora_partenza + ", luogo_arrivo=" + luogo_arrivo + ", data_arrivo="
				+ data_arrivo + ", ora_arrivo=" + ora_arrivo + ", costo=" + costo + "]";
	}








	private String codice_id;
	private String  luogo_partenza; 
	private String data_partenza;
	private String ora_partenza;
	private String luogo_arrivo;
	private String  data_arrivo ;
	private String  ora_arrivo;
	private float costo;

}

