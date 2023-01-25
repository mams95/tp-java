package package1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
	private ArrayList<Aéroport> list= new ArrayList<Aéroport>();
	public String fileName;
	 String IATA;
	 String Name;
	 String country;
	 double latitude;
	 double longitude;
	
	
		public World (String fileName){
			try{
				
				BufferedReader buf = new BufferedReader(new FileReader(fileName));
				String s = buf.readLine();
				while(s!=null){
					s=s.replaceAll("\"","");
					//Enleve les guillemets qui s´eparent les champs de donn´ees GPS.
					String fields[]=s.split(",");
					// Une bonne id´ee : placer un point d'arr^et ici pour du debuggage.
					if (fields[1].equals("large_airport")){
							IATA=fields[9];
							Name=fields[2];
							country=fields[5];
							latitude=Double.parseDouble(fields[11]);
							longitude=Double.parseDouble(fields[12]);
							Aéroport a=new Aéroport(IATA,Name,country,latitude,longitude);	
							list.add(a);
					}
						s = buf.readLine();
					}
				}
			catch (Exception e){
				System.out.println("Maybe the file isn't there ?");
				System.out.println(list.get(list.size()-1));
				e.printStackTrace();
			}
		}

	
		public ArrayList<Aéroport> getList() {
			return list;
		}
	
		 double distance (double x1, double y1, double x2, double y2){
	        double deltaY = y2-y1;
	        double deltaX = (x2-x1)*Math.cos((y2+y1)/2);
	        return (deltaX*deltaX) + (deltaY*deltaY);

	    }
	
	
	

	
	 public Aéroport findNearestAirport(double lon, double lat){
	        Aéroport aeroport = list.get(0);
	        double d=distance(lon,lat,aeroport.getLongitude(),aeroport.getLatitude());

	        for (Aéroport a : list){
	            if (distance(lon,lat,a.getLongitude(),a.getLatitude())<d)
	            {
	                aeroport=a;
	                d=distance(lon,lat,a.getLongitude(),a.getLatitude());
	            }
	        }

	        return aeroport;


	    }
	public Aéroport findByCode(ArrayList<Aéroport> listAirport,String iata)
	{
		int i = 0 ;
		Aéroport airport = listAirport.get(0);
		while(iata != airport.getIATA() )
		{
			i++;
			airport = listAirport.get(i);
		}
		return airport ;
	}

	
		
	
}
