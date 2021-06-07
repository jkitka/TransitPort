package bdbt_proj_2;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

public class Port {

	private int ID_portu;
	private String Nazwa;
	private int Powierzchnia;
	private String Data_zalozenia;
	private String Osrodek_ratownictwa;
	private int ID_adresu;

	public Port() {

	}

	public Port(int ID_portu, String Nazwa, int Powierzchnia, String Data_zalozenia,
			String Osrodek_ratownictwa, int ID_adresu) {
		super();
		this.ID_portu = ID_portu;
		this.Nazwa = Nazwa;
		this.Powierzchnia = Powierzchnia;
		this.Data_zalozenia = Data_zalozenia;
		this.Osrodek_ratownictwa = Osrodek_ratownictwa;
		this.ID_adresu = ID_adresu;
	}



	public int getID_portu() {
		return ID_portu;
	}

	public void setID_portu(int iD_portu) {
		ID_portu = iD_portu;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public int getPowierzchnia() {
		return Powierzchnia;
	}

	public void setPowierzchnia(int powierzchnia) {
		Powierzchnia = powierzchnia;
	}

	public String getData_zalozenia() {
		return Data_zalozenia;
	}

	public void setData_zalozenia(String data_zalozenia) {
		Data_zalozenia = data_zalozenia;
	}

	public String getOsrodek_ratownictwa() {
		return Osrodek_ratownictwa;
	}

	public void setOsrodek_ratownictwa(String osrodek_ratownictwa) {
		Osrodek_ratownictwa = osrodek_ratownictwa;
	}

	public int getID_adresu() {
		return ID_adresu;
	}

	public void setID_adresu(int iD_adresu) {
		ID_adresu = iD_adresu;
	}

	@Override
	public String toString() {
		return "Port [ID_portu=" + ID_portu + ", Nazwa=" + Nazwa + ", Powierzchnia=" + Powierzchnia
				+ ", Data_zalozenia=" + Data_zalozenia + ", Osrodek_ratownictwa=" + Osrodek_ratownictwa + ", ID_adresu="
				+ ID_adresu + "]";
	}


	
	
}
