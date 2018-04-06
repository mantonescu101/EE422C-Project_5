package assignment5;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    public GridPane grid;
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
            Critter.displayWorld();
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
        else if(value.equals("Step")){
            Critter.worldTimeStep();
        }
        else if(value.equals("Start")){
            if(Main.timerN == 1){
                Main.timer.start();
            }
            else if(Main.timerN == 2){
                Main.timer2.start();
            }
            else if(Main.timerN == 3){
                Main.timer3.start();
            }
        }
        else if(value.equals("Stop")){
            Main.timer.stop();
            Main.timer2.stop();
            Main.timer3.stop();
        }
        else if(value.equals("Speed 1")){
            Main.timerN = 1;
        }
        else if(value.equals("Speed 2")){
            Main.timerN = 2;
        }
        else if(value.equals("Speed 3")){
            Main.timerN = 3;
        }
    }
}
