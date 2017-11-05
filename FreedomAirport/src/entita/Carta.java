package entita;

public class Carta {

	
	
	
public Carta(int numero_carta , String tipo, String nominativo, String validità ){
		
		this.numero_carta= numero_carta;
		this.tipo= tipo; 
		this.nominativo=nominativo;
	    this.validità=validità;

	}
	
public int getNumero_carta() {
	return numero_carta;
}
public void setNumero_carta(int numero_carta) {
	this.numero_carta = numero_carta;
}

public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}

public String getNominativo() {
	return nominativo;
}
public void setNominativo(String nominativo) {
	this.nominativo = nominativo;
}
public String getValidità() {
	return validità;
}
public void setValidità(String validità) {
	this.validità = validità;
}


	@Override
public String toString() {
	return "Carta [numero_carta=" + numero_carta + ", tipo=" + tipo + ", nominativo=" + nominativo + ", validità="
			+ validità + "]";
}






	private int numero_carta ;
	private String tipo ;
	private String nominativo ;
	private String validità;
}
