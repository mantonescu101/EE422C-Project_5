package assignment5;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    public ChoiceBox Critters;
    public Text output;

    public void processButton(ActionEvent event){

        String value = ((Button)event.getSource()).getText();
        if(value.equals("Quit")){
            Platform.exit();
        }

        else if(value.equals("Seed")){
            Critter.setSeed(Critter.getRandomInt(100));
        }

        else if(value.equals("Show")){
            Critter.displayWorld();
        }
        else if(value.equals("Make")){
            String cr = "";
            cr += "assignment5." + Critters.getSelectionModel().getSelectedItem().toString();

            try{
                Critter.makeCritter(cr);
            } catch(InvalidCritterException e){
                System.out.println("u f up");
            }
        }

        else if(value.equals("Stats")){
            List<Critter> list = new ArrayList<Critter>();
            String cr = "";
            cr += "assignment5." + Critters.getSelectionModel().getSelectedItem().toString();

            try {
                list = Critter.getInstances(cr);
                Class c = Class.forName(cr);
                Method method = c.getMethod("runStats", List.class);
                output.setText((method.invoke(c, list)).toString());

            } catch (InvalidCritterException | ClassNotFoundException |
                    NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                System.out.println("u f up");
            }
        }

    }
}
