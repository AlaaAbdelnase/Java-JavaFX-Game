package application;

import game.animations.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WariningEntity extends HBox{
	private final ImageView imageView;
	private static Image WaringIcon;
	private Label label;
	private static final int COLUMNS  =  1;
    private static final int COUNT    =  3;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 14;
    private static final int HEIGHT   = 16;
    private static final Image IMAGE = new Image("file:Images/Death.png");
	    
	static {
		try {
			WaringIcon = new Image("file:Images/zombie_normal.gif");
			//translate = new Translate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public WariningEntity(String string) {
		this.getStylesheets().add(getClass().getResource("Error.css").toExternalForm());
		label = new Label();
		label.setText(string);
		this.setLayoutX(0);
		imageView = new ImageView(IMAGE);
		
        this.getChildren().addAll(imageView,label);
        
	}
	public WariningEntity(String string,AnchorPane pane) {
		this.getStylesheets().add(getClass().getResource("Error.css").toExternalForm());
		label = new Label();
		label.setText(string);
		this.setLayoutX(100);
		FadeTransition fade=new FadeTransition();
		fade.setDuration((Duration.seconds(3)));
		fade.setNode(this);
		fade.setCycleCount(1);  
		fade.setFromValue(0);  
        fade.setToValue(10); 
		fade.play();
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration((Duration.seconds(10)));
		transition.setNode(this);
		transition.setCycleCount(Timeline.INDEFINITE);
		transition.setFromY(0);;
		transition.setToY(100);
		transition.setAutoReverse(true);
		transition.play();
		imageView = new ImageView(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(900),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        imageView.setFitHeight(16*1.5) ;
        imageView.setFitWidth(14*1.5) ;
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        this.getChildren().addAll(imageView,label); 
        pane.getChildren().add(this);
	}
	public void play(AnchorPane Pane) {
		imageView.setImage(IMAGE);
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        imageView.setFitHeight(800) ;
        imageView.setFitWidth(1490) ;
        animation.setCycleCount(1);
        animation.play();
		Pane.getChildren().add(this);
		FadeTransition fade=new FadeTransition();
		fade.setDuration((Duration.seconds(2)));
		fade.setNode(this);
		fade.setCycleCount(1);  
		fade.setFromValue(10);  
        fade.setToValue(0); 
		fade.play();
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration((Duration.seconds(2)));
		transition.setNode(this);
		transition.setCycleCount(1);
		transition.setFromY(0);;
		transition.setToY(-25);
		transition.play();
		transition.setOnFinished(e->Pane.getChildren().remove(this));
	}
}
