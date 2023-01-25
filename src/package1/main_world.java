package package1;

import java.util.ArrayList;

public class main_world {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "./src/package1/airports.csv";
		World w =new World(fileName);
		ArrayList<Aéroport> liste_airport=new ArrayList<Aéroport>();
		liste_airport=w.getList();
		System.out.println(liste_airport.toString());
		System.out.println("Found "+w.getList().size()+" Airports");
		Aéroport a1 = liste_airport.get(10);
		Aéroport a2 = liste_airport.get(2);
		System.out.println(a1.toString());

		// test de la fonction distance 
		double lon1 = a1.getLongitude() ;
		double lat1 = a1.getLatitude();
		double lon2 = a2.getLongitude();
		double lat2 = a2.getLatitude();
		double dist = w.distance(lon1,lat1,lon2,lat2);
		System.out.println("La distance entre a1 et a2 est : "+ dist);

		// test de la fonction findNearest 
		lon1 = 2.316 ; 
		lat1 = 48.866 ; 
		//System.out.println("listAirport.size() = "+listAirport.size());
		Aéroport nearestAirport = w.findNearestAirport(lon1,lat1);
		System.out.println("nearestAirport = "+nearestAirport);
		
		// test de la fonction findByCode 
		String iata = nearestAirport.getIATA() ;
		Aéroport magicAirport = w.findByCode(liste_airport,iata);
		System.out.println("magicAirport founded by the code iata "+iata+" is : "+magicAirport);
		
	}

}
