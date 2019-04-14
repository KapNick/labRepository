package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Label lbl1 = new Label();
        Label lbl2 = new Label();
        lbl1.setText("Метры");
        lbl2.setText("Дюймы");
        TextField txt1 = new TextField();
        TextField txt2 = new TextField();
        Button btn1, btn2;
        btn1 = new Button();
        btn2 = new Button();
        btn1.setText("Метры в дюймы");
        btn2.setText("Дюймы в метры");
        GridPane grd = new GridPane();
        grd.setVgap(5);
        grd.setHgap(15);
        grd.add(lbl1, 1,1);
        grd.add(lbl2,3,1);
        grd.add(txt1, 1,3);
        grd.add(txt2, 3, 3);
        grd.add(btn1,1,5);
        grd.add(btn2, 3,5);
        btn1.setOnAction(event  ->
        {
            String a= txt1.getText();
            if(isDouble(a)) {
                double num1 = Double.parseDouble(a);
                num1 *= 39.37;
                txt2.setText(String.valueOf(num1));
            }
            else{
                txt2.setText(String.valueOf("Ошибка ввода числа"));
            }
        });
        btn2.setOnAction(event  ->
        {
            String b= txt2.getText();
            if(isDouble(b)){
                double num2 = Double.parseDouble(b);
                num2*=0.0254;
                txt1.setText(String.valueOf(num2));
            }
            else{
                txt1.setText(String.valueOf("Ошибка ввода текста"));
            }
        });
        primaryStage.setTitle("Laba 1");
        primaryStage.setScene(new Scene(grd, 500, 300));
        primaryStage.show();
    }

    private boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch(Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
