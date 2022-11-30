package agh.isc.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox{
    public VBox box;
    public GuiElementBox (IMapElement el) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(el.resourceName()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label;
        if(el.toString().equals("*")) label = new Label("Trawa");
        else label = new Label("Z: "+el.getPosition().toString());
        box = new VBox(imageView, label);
        box.setAlignment(Pos.CENTER);
    }
}
