package entita;

public class Carrello {
public Carrello( String rif_cliente, String rif_volo, Integer codice_id){

	this.rif_cliente= rif_cliente;
	this.rif_volo= rif_volo;
	}



public String getrif_cliente() {
	return rif_cliente;
}
public void setrif_cliente(String rif_cliente) {
	this.rif_cliente = rif_cliente;
}

public String getrif_volo() {
	return rif_volo;
}
public void setrif_volo(String rif_volo) {
	this.rif_volo = rif_volo;
}
	@Override
public String toString() {
	return "Carrello [rif_cliente=" + rif_cliente + ", rif_volo=" + rif_volo + "]";
}
	String rif_cliente;
	String rif_volo;
}
