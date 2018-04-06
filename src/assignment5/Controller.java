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
            Main.timer.stop();
            Platform.exit();
        }

        else if(value.equals("Seed")){
            Critter.setSeed(Critter.getRandomInt(100));
        }

        else if(value.equals("Show")){
            Main.timer.start();
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
        else if(value.equals("Step 1")){
            Critter.worldTimeStep();
        }
        else if(value.equals("Step 5")){
            for (int i = 0; i < 5; i++) {
                Critter.worldTimeStep();
            }
        }
        else if(value.equals("Step 10")){
            for (int i = 0; i < 10; i++) {
                Critter.worldTimeStep();
            }
        }
        else if(value.equals("Step 50")){
            for (int i = 0; i < 50; i++) {
                Critter.worldTimeStep();
            }
        }
        else if(value.equals("Step 100")){
            for (int i = 0; i < 100; i++) {
                Critter.worldTimeStep();
            }
        }
        else if(value.equals("Step 1000")){
            for (int i = 0; i < 1000; i++) {
                Critter.worldTimeStep();
            }
        }

    }
}
