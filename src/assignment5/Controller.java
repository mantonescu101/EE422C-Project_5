package assignment5;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    public void processButton(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(value.equals("Quit")){
            Platform.exit();
        }
        /*
        else if(value.equals("Stats"){

        }*/
    }
}
