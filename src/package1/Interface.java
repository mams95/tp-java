package package1;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

//import javafx.scene.input.KeyCode;
public class Interface extends Application {
	
	
	Translate tz = new Translate();
	   private double mousePosX;
	   private double mousePosY;
@Override
public void start(Stage primaryStage) throws Exception{
	World w = new World("./src/package1/airports.csv");

    primaryStage.setTitle("So world");

    Earth earth = new Earth();
    Scene ihm = new Scene(earth, 800, 600,true);
    
	primaryStage.setTitle("Hello world");
	Group root = new Earth();
	Pane pane = new Pane(root);
	
	primaryStage.setScene(ihm);
	primaryStage.show();
	Rotate rotate_x = new Rotate(0, Rotate.X_AXIS);
	Rotate rotate_y = new Rotate(0, Rotate.Y_AXIS);
	Translate translate = new Translate(0, 0, 1);
	Rotate rotate_z = new Rotate(0, Rotate.Z_AXIS);
	
	
	
	PerspectiveCamera camera = new PerspectiveCamera(true);
	camera.setTranslateZ(-1100);
	camera.setNearClip(0.1);
	camera.setFarClip(2000.0);
	camera.setFieldOfView(40);
	ihm.setCamera(camera);
	
	/*ihm.addEventHandler(MouseEvent.ANY, event -> {
		if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
		System.out.println("Clicked on : ("+ event.getSceneX()+ ", "+ event.getSceneY()+")");
		}
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
		camera.getTransforms().addAll(rotate_x, rotate_y, translate); // A vous de completer
		}
		
		if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
		camera.getTransforms().addAll(rotate_x, rotate_y, new Translate(0,0,-1)); // A vous de completer
		}
		
		
		});*/
	 ihm.addEventHandler(MouseEvent.ANY, event -> {
         if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
             mousePosX = event.getSceneX();
             mousePosY = event.getSceneY();
         }
         if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
             tz.setZ((event.getSceneY() - mousePosY)*0.1);
             camera.getTransforms().add(tz);
         }
     });
	
	
	ihm.addEventHandler(MouseEvent.ANY, event3 -> {
		if (event3.getButton()== MouseButton.SECONDARY && event3.getEventType()==MouseEvent.MOUSE_CLICKED) {
			
			 PickResult pickResult = event3.getPickResult();
             if (pickResult.getIntersectedNode() != null) {
            	 
            	 double X= pickResult.getIntersectedTexCoord().getX();
  				double Y= pickResult.getIntersectedTexCoord().getY();
 					double latitude=-180*(Y-0.5);
 				    double longitude=360*(X-0.5);
                 Point2D click=pickResult.getIntersectedTexCoord();
                 Aéroport a = w.findNearestAirport(longitude,latitude);
                 earth.displayRedSphere(a);
                    
                 System.out.println("x="+longitude+" y ="+latitude);
                 System.out.println(a);
                 
		}
		}});
	
	 primaryStage.setScene(ihm);

     primaryStage.show();
	}


	
public static void main(String[] args) {
	launch(args);
	}
}