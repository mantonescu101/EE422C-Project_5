package assignment5;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	static GridPane worldGrid = new GridPane();
	static GridPane critGrid = new GridPane();
	static AnimationTimer timer = new AnimationTimer() {
		@Override
		public void handle(long now) {
			Critter.displayWorld();
		}
	};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
		primaryStage.setTitle("Critters");

		Stage world = new Stage();
		world.setTitle("World");
		StackPane stackPane = new StackPane();
		ObservableList list = stackPane.getChildren();
		list.addAll(critGrid, worldGrid);
		Scene worldScene = new Scene(stackPane, Params.world_width*(WorldView.tileSize+2), Params.world_height*(WorldView.tileSize+2)); //Fix later
		world.setScene(worldScene);
		world.show();

		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
