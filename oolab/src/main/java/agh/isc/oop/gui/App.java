package agh.isc.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static java.lang.System.out;

public class App extends Application implements IPositionChangeObserver{

    GrassField map;
    GridPane grid;
    Thread engineThread;
    SimulationEngine engine;
    TextField textField;

    public void init(){
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
            engine = new SimulationEngine(map, positions,this, 300);
    }

    public void start(Stage primaryStage) throws FileNotFoundException {

        grid = new GridPane();
        textField = new TextField();
        Button button = new Button("Start");
        HBox hbox = new HBox(textField, button);
        VBox vbox = new VBox(grid, hbox);
        Scene scene = new Scene(vbox, 550, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
        gridMap(grid);
        button.setOnAction(event -> onClick());
    }
    public void gridMap(GridPane grid) throws FileNotFoundException {
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        grid.setGridLinesVisible(true);

        Vector2d ll = map.getll();
        Vector2d ur = map.getur();
        for (int i = ur.y + 1; i >= ll.y; i--){
            for (int j = ll.x-1; j <= ur.x; j++){
                if (i== ur.y + 1 && j == ll.x -1){
                    Label label = new Label("y/x");
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,0,1,1);
                    grid.getRowConstraints().add(new RowConstraints(40));
                    grid.getColumnConstraints().add(new ColumnConstraints(40));
                }
                else if (i == ur.y+1){
                    Label label = new Label(Integer.toString(j));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,j-ll.x+1,0,1,1);
                    grid.getColumnConstraints().add(new ColumnConstraints(40));
                }
                else if (j == ll.x -1){
                    Label label = new Label(Integer.toString(i));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,ur.y-i+1,1,1);
                    grid.getRowConstraints().add(new RowConstraints(40));
                }
                else{
                    if(map.isOccupied(new Vector2d(j,i))){
                        GuiElementBox labelObject = new GuiElementBox(map.objectAt(new Vector2d(j,i)));
                        grid.add(labelObject.box,j-ll.x+1,ur.y-i+1,1,1);
                        GridPane.setHalignment(labelObject.box, HPos.CENTER);
                    }
                }

            }
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            try {
                gridMap(grid);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            };
        });
    }
    public void onClick(){
        engine.setDirections(textField.getText());
        engineThread = new Thread((Runnable) engine);
        engineThread.start();
    }
}
