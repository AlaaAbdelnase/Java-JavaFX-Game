package application;



import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class ErrorEntity extends HBox {
	public ErrorEntity(String message) {
		super();
		Label text = new Label();
		text.setText(message);
		this.getStylesheets().add(getClass().getResource("Error.css").toExternalForm());
		
		this.setLayoutX(400);
		this.setLayoutY(10);
		this.setCache(true);
        //g.setEffect(new Bloom());
        Bloom bloom = new Bloom();
        bloom.setThreshold(1.0);
        this.setEffect(bloom);
        this.setTranslateX(350);
        this.getChildren().add(text);
	}
	public void play(AnchorPane Pane) {
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
