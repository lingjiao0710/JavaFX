package application;
	
import java.nio.channels.ShutdownChannelGroupException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	String[] imageUrls = {
			"application/res/2.jpg",
			"application/res/hangmu.jpg",
			"application/res/kongjing500.jpg",
			"application/res/tiangong.jpg",
		};
		Image[] images = new Image[4];
		ImageView imageView = new ImageView();
		
		int curIndex = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//增加标签
			//Label label = new Label("标签1");
			//root.setCenter(label);
			
			//增加按钮
			/*Button button = new Button("点我");
			button.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("被点了一下");
				}
				
			});
			root.setCenter(button);
			*/
			
			//显示图片
			//Image image = new Image("http://afanihao.cn/tu.jpg");
			/*Image image = new Image("application/res/2.jpg");
			ImageView imageView = new ImageView(image);
			root.setCenter(imageView);
			
			double width = image.getWidth();
			double height = image.getHeight();
			System.out.println("图片宽 "+width+" 图片高 "+height);
			Scene scene = new Scene(root,width,height);*/
			Button button = new Button("下一张");
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					showNext();
				}
				
			});
			
			for (int i = 0; i < images.length; i++) {
				images[i] = new Image(imageUrls[i]);
			}
			
			imageView.setPreserveRatio(true);
			imageView.setFitHeight(400);
			imageView.setFitWidth(400);
			imageView.setImage(images[curIndex]);
			root.setTop(button);
			root.setCenter(imageView);
			
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showNext() {
		curIndex ++;
		if(curIndex >= 4) curIndex = 0;
		imageView.setImage(images[curIndex]);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
