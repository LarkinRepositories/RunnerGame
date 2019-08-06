package Lesson_7.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI/Fxml/ChatWindow.fxml"));
        primaryStage.setTitle("zChat pre alpha");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setResizable(false);
        primaryStage.show();


//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        Parent root = FXMLLoader.load(getClass().getResource("UI/Fxml/ChatWindow.fxml"));
//        Scene scene = new Scene(root);
//        scene.setFill(Color.TRANSPARENT);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
