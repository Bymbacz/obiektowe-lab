package agh.isc.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.System.out;

public class App extends Application{

    GrassField map;

    public void init(){
        String[] s = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(s);
        map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    public void start(Stage primaryStage){

        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));
        grid.setGridLinesVisible(true);

        Vector2d ll = map.getll();
        Vector2d ur = map.getur();
        for (int i = ur.y + 1; i >= ll.y; i--){
            for (int j = ll.x-1; j <= ur.x; j++){
                if (i== ur.y + 1 && j == ll.x -1){
                    Label label = new Label("y/x");
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,0,1,1);
                }
                else if (i == ur.y+1){
                    Label label = new Label(Integer.toString(j));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,j-ll.x+1,0,1,1);
                    grid.getColumnConstraints().add(new ColumnConstraints(30));
                }
                else if (j == ll.x -1){
                    Label label = new Label(Integer.toString(i));
                    GridPane.setHalignment(label, HPos.CENTER);
                    grid.add(label,0,ur.y-i+1,1,1);
                    grid.getRowConstraints().add(new RowConstraints(30));
                }
                else{
                    if(map.isOccupied(new Vector2d(j,i))){
                        Label labelObject = new Label(map.objectAt(new Vector2d(j,i)).toString());
                        grid.add(labelObject,j-ll.x+1,ur.y-i+1,1,1);
                        GridPane.setHalignment(labelObject, HPos.CENTER);

                    }
                }

            }
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
