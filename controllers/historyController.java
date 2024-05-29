package calculator.controllers;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class historyController {
    @FXML
    private ListView historyList;
    
    
    public void initalizeCalculations(ArrayList<String> calculation_history){
        calculation_history.forEach((calculation) ->{
            historyList.getItems().add(calculation);
        });
        
    }
    
    
}
