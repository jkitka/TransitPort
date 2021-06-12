package bdbt_proj_2;

public class Reservation {
	
	private String reservation_start;
	private String reservation_end;
	private int number_of_containers;
	
	Port port = new Port();
	private int reservedPort_id = port.getID_portu();
	
	public Reservation() {
		
	}
	
	public Reservation(String reservation_start, String reservation_end, int number_of_containers,  int reservedPort_id) {
		super();
		this.reservation_start = reservation_start;
		this.reservation_end = reservation_end;
		this.number_of_containers = number_of_containers;
		this.reservedPort_id = reservedPort_id;
		

	}



	public int getReservedPort_id() {
		return reservedPort_id;
	}



	public void setReservedPort_id(int reservedPort_id) {
		this.reservedPort_id = reservedPort_id;
	}



	public String getReservation_start() {
		return reservation_start;
	}



	public void setReservation_start(String reservation_start) {
		this.reservation_start = reservation_start;
	}



	public String getReservation_end() {
		return reservation_end;
	}



	public void setReservation_end(String reservation_end) {
		this.reservation_end = reservation_end;
	}



	public int getNumber_of_containers() {
		return number_of_containers;
	}



	public void setNumber_of_containers(int number_of_containers) {
		this.number_of_containers = number_of_containers;
	}



	@Override
	public String toString() {
		return "Reservation [reservation_start=" + reservation_start + ", reservation_end=" + reservation_end
				+ ", number_of_containers=" + number_of_containers + ", reservedPort_id=" + reservedPort_id + "]";
	}



	
	
}
