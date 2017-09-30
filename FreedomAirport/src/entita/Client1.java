package entita;

public class Client1 {
	public Client1(String username){
		this.username= username;
	}
	
	public Client1(String username, String password, String nome, String cognome,  String date, String paese,
			String indirizzo, String codice_fiscale, String carta_identita, String passaporto, String email, String numero_telefono) {
		this.username= username;
		this.password= password;
		this.nome= nome;
		this.cognome= cognome;
		this.data_nascita= date;
		this.paese= paese;
		this.indirizzo= indirizzo;
		this.codice_fiscale= codice_fiscale;
		this.carta_identita= carta_identita;
		this.passaporto= passaporto;
		this.email= email;
		this.numero_telefono= numero_telefono;
	}

	public void setUsername(String username){
		this.username=  username;
	}
	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password= password;
	}

	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=  nome;
	}

	public String getCognome(){
		return cognome;
	}
	public void setCognome(String cognome){
		this.cognome=  cognome;
	}

	public String getDataNascita(){
		return data_nascita;
	}
	public void setDataNascita(String data_nascita){
		this.data_nascita=  data_nascita;
	} 

	public String getPaese(){
		return paese;
	}
	public void setPaese(String paese){
		this.paese=  paese;
	}

	public String getInd(){
		return indirizzo;
	}
	public void setInd(String indirizzo){
		this.indirizzo=  indirizzo;
	}
	public String getCF(){
		return codice_fiscale;
	}
	public void setCF(String codice_fiscale){
		this.codice_fiscale=  codice_fiscale;
	}

	public String getCI(){
		return carta_identita;
	}
	public void setCI(String carta_identita){
		this.carta_identita=  carta_identita;
	}

	public String getPassaporto(){
		return passaporto;
	}
	public void setPassaporto(String passaporto){
		this.passaporto=  passaporto;
	}

	public String getMail(){
		return email;
	}
	public void setMail(String email){
		this.email=  email;

	}public String getTel(){
		return numero_telefono;
	}
	public void setTel(String numero_telefono){
		this.numero_telefono=  numero_telefono;
	}




	@Override
	public String toString() {
		return "Client1 [username=" + username + "]";
	}

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String data_nascita; 
	private String paese;
	private String indirizzo;
	private String codice_fiscale;
	private String carta_identita;
	private String passaporto;
	private String email;
	private String numero_telefono; 
}
