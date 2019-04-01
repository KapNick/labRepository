package sample;

import Items.Food;
import Items.GetTaste;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main (String[] args) {
        Application.launch(args);
    }


    @Override
    public void start (Stage primaryStage) {
        HBox root = new HBox();
        VBox Vcook = new VBox();
        VBox Vproger = new VBox();

        Button cook = new Button("Приготовить");
        Button eatProger = new Button("Есть");
        Button eatCook = new Button("Есть");
        Button code = new Button ("Писать код");

        cook.setMinWidth(150);
        eatProger.setMinWidth(150);
        eatCook.setMinWidth(150);
        code.setMinWidth(150);

        Handle Handle = new Handle();

        TextField TfoodName = new TextField("");
        TfoodName.setPrefSize(150, 15);

        TextArea console = new TextArea("Место для кода");
        console.setMinSize(150, 200);
        console.setWrapText(true);

        ListView<String> ListFood = new ListView<String>();
        ListFood.setMinSize(150, 150);

        ObservableList<String> List = FXCollections.observableArrayList();

        Vcook.getChildren().addAll (ListFood, TfoodName, cook, eatCook);
        Vproger.getChildren().addAll(console, code, eatProger);
        root.getChildren().addAll(Vcook, Vproger);

        cook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (TfoodName.getText().equals("")) {
                    ShowFoodAlert();
                }
                else {
                    Handle.cook(TfoodName.getText());
                    List.add (TfoodName.getText());
                    ListFood.setItems(List);
                    TfoodName.setText("");
                }
            }
        }));

        eatCook.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!Handle.getStackList().isEmpty()) {
                    ShowCookTasteAlert(Handle.eatCook(), Handle);
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));

        eatProger.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (!Handle.getStackList().isEmpty()) {
                    ShowProgerTasteAlert(Handle.eatProger(), Handle);
                    List.remove(List.size()-1);
                    ListFood.setItems(List);
                }
            }
        }));

        code.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                console.setText (Handle.coding());
            }
        }));

        TfoodName.setOnKeyPressed((new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode()== KeyCode.ENTER) {
                    if (TfoodName.getText().equals("")) {
                        ShowFoodAlert();
                    }
                    else {
                        Handle.cook(TfoodName.getText());
                        List.add (TfoodName.getText());
                        TfoodName.setText("");
                        ListFood.setItems(List);
                    }
                }
            }
        }));

        Scene scene = new Scene (root, 300, 250);
        primaryStage.setTitle("Laba2");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void ShowFoodAlert() {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText("Не указано название блюда!");
        alert.showAndWait();
    }

    private void ShowProgerTasteAlert(Food food, Handle Handle) {
        GetTaste taste = new GetTaste();
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Есть");
        alert.setHeaderText(null);
        alert.setContentText("Вкус блюда: " + taste.tasteToString(food).toLowerCase()+"\n"+
                "Программист "+ Handle.getnameProg()+" съел блюдо");
        alert.showAndWait();
    }

    private void ShowCookTasteAlert(Food food, Handle Handle) {
        GetTaste taste = new GetTaste();
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Есть");
        alert.setHeaderText(null);
        alert.setContentText("Вкус блюда: " + taste.tasteToString(food).toLowerCase()+"\n"+
                "Повар "+ Handle.getnameCook()+" сьел блюдо");
        alert.showAndWait();
    }
}