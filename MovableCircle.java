package Stewart.mycompany;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class MovableCircle extends Circle {
    
    private double mouseX;
    private double mouseY;

    //creation and parameters for the new chip
    public MovableCircle(double centerX, double centerY, double radius, Color fill) {
        super(centerX, centerY, radius, fill);

        // event handlers for mouse pressed, dragged, and released events
        setOnMousePressed((event) -> {
            mouseX = event.getSceneX() - getLayoutX();
            mouseY = event.getSceneY() - getLayoutY();
        });
        setOnMouseDragged((event) -> {
            setLayoutX(event.getSceneX() - mouseX);
            setLayoutY(event.getSceneY() - mouseY);
        });
        setOnMouseReleased((event) -> {
        });
    }
}
   
