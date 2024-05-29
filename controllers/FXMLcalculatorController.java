package calculator.controllers;


import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import calculator.Calculator;
import utils.EvaluateString;


public class FXMLcalculatorController{ //implements Initializable {
    
    private ArrayList <String> calculation_history = new ArrayList<>();
    @FXML
    Label expression;
    
    @FXML
    private Label result;

    
    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
    //}    
        
        
    
    public void insertNumber (String number) {
        expression.setText(expression.getText() + number);
        
    }   
    
    public void addCalculation(String expression, String result){
        this.calculation_history.add(expression + " = " + result);
        
    }
    
    public Label getExpression(){
        return expression;
    }
    
    public Label getResult(){
        return result;
    }
    
    public void setResult(String newResult){

        this.result.setText("= " + newResult);
        
    }
    
    public void openHistoryWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("testing123/resources/history.fxml"));
            Parent root = loader.load();
            
            Testing123.getHistoryStage().setScene(new Scene(root));
            
            historyController historyController = loader.getController();
            historyController.initalizeCalculations(calculation_history);
            
            Testing123.getHistoryStage().show();
            
            
           
        }catch (IOException ex){
            System.out.println(ex);
            
        }
        
    }
    
    public void deleteLast(){
        if (!getExpression().getText().isEmpty()){
            StringBuilder text = new StringBuilder(getExpression().getText());
            text.deleteCharAt(text.length()-1);
            getExpression().setText(text.toString());
            
            
        }
        
    }
    
    public void insertOperator(String operator){
        expression.setText(expression.getText() + " " + operator + " ");   
    }
    
    public void insertAnswer(String answer){
        expression.setText(expression.getText() + answer);
        
        
    }
    
    public void clearExpression(){
        expression.setText("");
    }
        
    @FXML
    public void onMouseClick (MouseEvent mouseEvent){
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        
        

        
        switch(buttonText){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(buttonText);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                insertOperator(buttonText);
                break;
            case "CLEAR":
                clearExpression();
            case "=":
                int result = EvaluateString.evaluate(this.getExpression().getText());
                addCalculation(this.getExpression().getText(), String.valueOf(result));
                setResult(String.valueOf(result));
                break;
            case "ANS":
                insertAnswer(getResult().getText().substring(2));
                break;
            case "DELETE":
                deleteLast();
                break;
            case "HIST":
                openHistoryWindow();
                break;
                

        
                 
        }
       
        
    }
    

}
