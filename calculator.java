package calculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class calculator extends Application {
    
    private static Stage historyStage = null;


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/FXMLcalculator.fxml"));
        //fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        createHistoryStage();
   
    
    }
    
    public void createHistoryStage(){
        historyStage = new Stage();
        historyStage.setTitle("Calculation History");
        historyStage.setAlwaysOnTop(true);
        historyStage.setResizable(false);
        historyStage.initModality(Modality.APPLICATION_MODAL);
       

    }
    
    public static Stage getHistoryStage(){
        return historyStage;
    }
    
    public static void main(String [] args){
        launch (args);
    }
    
}
