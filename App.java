/******************************************************************************************
* Final Exam Project
* Author: Javon Stewart
* Project Purpose: Bingo Game
* Input: A button to call random numbers, make chips, change the called number, and call for Bingo 
* Desired Output: Random numbers generated, and the Bingo game with all images present
* Variables and Classes: 1 main, 2 classes
* Testing: When the program is run the user can play bingo successfully
* April 23, 2023
**********************************************************************************************/

package Stewart.mycompany;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;  
import javafx.scene.image.ImageView; 
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;

public class App extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
       launch(args);
   }  
   
    @Override
   public void start(Stage primaryStage)
   {     
       //Adding all of the images used
       Image bingoImage = new Image("file:/Users/javon/OneDrive/Documents/NetBeansProjects/Bingo/src/Bingo1.jpg");
       Image titleImage = new Image("file:/Users/javon/OneDrive/Documents/NetBeansProjects/Bingo/src/BingoTitle.jpg");
       Image winnerImage = new Image("file:/Users/javon/OneDrive/Documents/NetBeansProjects/Bingo/src/Winner.jpg", 800,700,false,false);
       Image backgroundImage = new Image("file:/Users/javon/OneDrive/Documents/NetBeansProjects/Bingo/src/Background.jpg", 1920,1400,false,false);
       
       ImageView bingoView = new ImageView(bingoImage);
       ImageView titleView = new ImageView(titleImage);
       ImageView winnerView = new ImageView(winnerImage);
       ImageView backgroundView = new ImageView(backgroundImage);
       
       //Setting the Bingo card image parameters
       bingoView.setFitWidth(600);
       bingoView.setPreserveRatio(true);
       bingoView.setX(150);
       bingoView.setY(220);
       
       //Setting the Title Card image parameters
       titleView.setFitWidth(600);
       titleView.setPreserveRatio(true);
       titleView.setX(170);
       
       //Setting the Winner image parameters
       winnerView.setX(40);
       winnerView.setY(250);
       
       //Setting the Background image parameters
       backgroundView.setX(-200);
       backgroundView.setY(0);
       
      // Constants for the scene size
      final double SCENE_WIDTH = 950.0;
      final double SCENE_HEIGHT = 1300.0;
      
      // Create the Bingo chip
      Circle chips = new Circle(100,100,40, Color.PURPLE);

      // Event Handler for mouse dragged
      chips.setOnMouseDragged(event ->
      {
      // Get the mouse cursor's coordinates.
         double x = event.getSceneX();
         double y = event.getSceneY();
         
      // Move the Bingo chip
         chips.setCenterX(x);
         chips.setCenterY(y);
      });
      
      //Creating and positioning CallNumber button
      Button callNumber = new Button ("Call Number");
      callNumber.setMinWidth(200);
      callNumber.setMinHeight(200);
      callNumber.setLayoutX(150);
      callNumber.setLayoutY(1000);
      
      //Creating and positioning Bingo button
      Button Bingo = new Button ("Bingo!");
      Bingo.setMinWidth(200);
      Bingo.setMinHeight(200);
      Bingo.setLayoutX(550);
      Bingo.setLayoutY(1000);
      
      //Creating and position the Chip button
      Button Chip = new Button("New Chip");
      Chip.setLayoutX(730);
      Chip.setLayoutY(1270);
      
      //Creating and positioning Label for random number
      Label NumberText = new Label();
      NumberText.setFont(new Font("Arial", 45));
      NumberText.setTranslateY(1070);
      NumberText.setTranslateX(420);
      
      //Text field to change the Label for cheating
      TextField textField = new TextField();
      textField.setTranslateX(800);
      textField.setTranslateY(1270);
      textField.textProperty().addListener((observable, oldValue, newValue) -> {
            NumberText.setText(newValue);
        });
      
      //Using the number generator class
      NumberGenerator r = new NumberGenerator();
      
      // Adding all items to the pane
      Pane pane = new Pane(backgroundView,titleView,bingoView,chips,callNumber,Chip,Bingo,NumberText,textField);
      
      //Action for the callnumber button
      //Both makes a chip and calls a number
      callNumber.setOnAction(e -> {
           for (int i = 0; i < 1; i++) {
              NumberText.setText("" +r.generateRandomNumber());
              MovableCircle square = new MovableCircle(100, 100, 40, Color.PURPLE);
              pane.getChildren().add(square);
        }
        pane.getChildren().add(callNumber);        
      });
      
      //Action for the Bingo button
      //Displays the winner image when pressed
      Bingo.setOnAction(e -> {
          pane.getChildren().add(winnerView);
      });
      
      //Action for the New Chip button
      Chip.setOnAction(e -> {
          MovableCircle square = new MovableCircle(100, 100, 40, Color.PURPLE);
              pane.getChildren().add(square);
              pane.getChildren().add(Chip);
   });
      
      // Create a Scene and display it
      Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
      primaryStage.setTitle("Bingo Game");
      primaryStage.setScene(scene);
      primaryStage.show();      
   }
}