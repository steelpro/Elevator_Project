package Elevator;
/*
Zachary Betters
CIS 150
4/13/2016
Elevator Project
This program will show elevator buttons to push
and will give the option to select or deselect them all.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    //2 arrays are created for two vbox's
    int numOfButtons = 9;
    int numOfButtons2 = 10;
    Button[] buttonsArray1 = new Button[numOfButtons2];
    Button[] buttonsArray2 = new Button[numOfButtons2];

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Elevator Buttons");

        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);
        HBox hbox = new HBox(20);
        //vbox's are added to hbox to stack side by size
        hbox.getChildren().addAll(vbox1, vbox2);
        hbox.setPadding(new Insets(20, 20, 20, 20));
        hbox.setPrefHeight(350);

        for (int i = numOfButtons; i >= 0; i -= 2 ) {

            //buttons are set for odd numbers 9-1
            buttonsArray1[i] = new Button(Integer.toString(i));
            buttonsArray1[i].setPrefWidth(100);
            buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            //add them to v_box and set the event handler to them
            vbox1.getChildren().add(buttonsArray1[i]);
            buttonsArray1[i].setOnAction(ButtonHandler1);
        }

        for (int i = numOfButtons2 - 1; i >= 0; i -= 2 ) {

            //buttons set for even numbers 10-2
            buttonsArray2[i] = new Button(Integer.toString(i+1));
            buttonsArray2[i].setPrefWidth(100);
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");

            vbox2.getChildren().add(buttonsArray2[i]);
            buttonsArray2[i].setOnAction(ButtonHandler2);
        }

        //creates test and clear button
        Button testB = new Button("TEST");
        testB.setPrefWidth(100);
        testB.setStyle("-fx-font: 20 arial; -fx-base: Gray");

        Button clearB = new Button("CLEAR");
        clearB.setPrefWidth(100);
        clearB.setStyle("-fx-font: 20 arial; -fx-base: Gray");

        /*test and clear are added to first and second vbox and
        different event handlers*/
        vbox1.getChildren().add(testB);
        testB.setOnAction(TestHandler);

        vbox2.getChildren().add(clearB);
        clearB.setOnAction(ClearHandler);

        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    EventHandler<ActionEvent> ButtonHandler1 = e -> {

        //i is the number button pressed
        Button b = (Button)e.getSource();
        int i = Integer.parseInt(b.getText());

        //change button color to white
        buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: White");
    };

    EventHandler<ActionEvent> ButtonHandler2 = e -> {

        Button b = (Button)e.getSource();
        int i = Integer.parseInt(b.getText());
        buttonsArray2[i-1].setStyle("-fx-font: 22 arial; -fx-base: White");
    };

    EventHandler<ActionEvent> TestHandler = e -> {
        /* if test button if pressed, all buttons
        for both arrays are changed to white */
        for (int i = numOfButtons; i >= 0; i -= 2 )
            buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: White");
        //2 for loops are need for i to match button cases
        for (int i = numOfButtons2 - 1; i >= 0; i -= 2 )
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: White");
    };

    EventHandler<ActionEvent> ClearHandler = e -> {
        for (int i = numOfButtons; i >= 0; i -= 2 )
            buttonsArray1[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
        for (int i = numOfButtons2 - 1; i >= 0; i -= 2 )
            buttonsArray2[i].setStyle("-fx-font: 22 arial; -fx-base: LightGray");
    };

    @Override
    public void stop() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Close Event");
        alert.setHeaderText(null);
        alert.setContentText("Wait, I forgot to give you a hug!");
        alert.showAndWait();
    }
}