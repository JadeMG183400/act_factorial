package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25,25,25,25));
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(grid,400,400);
			
			Label etiqueta = new Label("Número");
			grid.add(etiqueta, 0, 1);
			
			TextField numero = new TextField();
			grid.add(numero, 1, 1);
			
			Button factorial = new Button("Factorial");
			grid.add(factorial, 1, 2);
			
			Label numFactorial = new Label();
			grid.add(numFactorial, 3, 1);
			
			factorial.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					int valor = Integer.parseInt(numero.getText());
					int valorFactorial = 1;
					
					for(int i=valor; i>=1; i--) {
						valorFactorial *= i;
					}
					String resultado = String.valueOf(valorFactorial);
					numFactorial.setText(resultado);
				}
			});
			
			Label resultado = new Label();
			grid.add(resultado, 2, 1);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
