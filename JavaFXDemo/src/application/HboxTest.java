package application;

import java.nio.channels.ShutdownChannelGroupException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


public class HboxTest extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hbox = new HBox();
			
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(10));
			
			TextField filePath = new TextField();
			Button select = new Button("选择");
			Button upload = new Button("上传");
			hbox.getChildren().addAll(filePath, select, upload);
			//设置textfield自动填充宽度
			HBox.setHgrow(filePath, Priority.ALWAYS);
			
			Scene scene = new Scene(hbox, 400, 40);
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
