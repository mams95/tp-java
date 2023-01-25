package package1;

public class Aéroport {
	private String IATA;
	private String Name;
	private String country;
	private double latitude;
	private double longitude;
	
	
	
	public Aéroport(String iATA, String name, String country, double latitude, double longitude) {
		super();
		this.IATA = iATA;
		this.Name = name;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public void Aeroport() {
	}
	public String getIATA() {
		return IATA;}
	public double getLatitude() {
		return latitude;}
	public double getLongitude() {
		return longitude;}
	
	
	@Override
	public String toString() {
		return "Aéroport [IATA=" + IATA + ", Name=" + Name + ", country=" + country + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	public String getName() {
		return Name;
	}
	public String getCountry() {
		return country;
	}
	

}
