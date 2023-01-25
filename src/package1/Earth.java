package package1;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Earth extends Group {
	private double radius=300;
	public  Sphere sph= new Sphere(radius);
	public Image img=new Image("/earth_lights_4800.png");
	PhongMaterial material=new PhongMaterial();
	public double R=300;
	private ArrayList<Sphere> yellowSphere;
	
	public Sphere createSphere(Aéroport a,Color color)
	{
		Color red = color.RED;
		color=red;
		 Sphere sphere = new Sphere(2);
		double longitude=Math.toRadians(a.getLongitude());
		double latitude= Math.toRadians(a.getLatitude());
		
		double X = R*Math.cos(longitude - 0.65)*Math.sin(latitude);
		double Y = -R*Math.sin(longitude-0.65) ;
		double Z = -R*Math.cos(longitude-0.65)*Math.cos(latitude);
		
		sphere.setTranslateX(X);
		sphere.setTranslateY(Y);
		sphere.setTranslateZ(Z);
		
		PhongMaterial ph=new PhongMaterial();
		sphere.setMaterial(ph);
		
		
		 
		return sphere; 
	}
	
	public  void displayRedSphere(Aéroport a)
	{
		this.getChildren().add(createSphere(a,Color.RED));
		
	}
	
	public void displayYellowSphere(ArrayList<Flight> list){
        PhongMaterial yellow = new PhongMaterial();
        yellow.setSpecularColor(Color.YELLOW);
        yellow.setDiffuseColor(Color.YELLOW);
        yellowSphere.clear();
        for (Flight b : list){
            if (b.getDeparture()!=null)
            {
                Sphere current = createSphere(b.getDeparture(),Color.YELLOW);
                this.getChildren().add(current);
            }
        }
	}
	
	

	public Earth() {
		super();
		
		this.getChildren().add(sph);
		sph.setMaterial(material);
		material.setDiffuseMap(img);
		
		Rotate rotate_y = new Rotate(150, Rotate.Y_AXIS);
		this.getTransforms().add(rotate_y);
		
		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long time) {
				//System.out.println("Valeur de time : " + time);
				//sph.getTransforms().add(new Rotate(-1,rotate)));
				rotate_y.setAngle(time*1e-8); // A completer
			}
		};
		animationTimer.start();
	}

	
	

	
	

}
