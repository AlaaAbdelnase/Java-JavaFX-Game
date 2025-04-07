package application;

import java.util.Collection;

import game.animations.SpriteAnimation;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class TitanEntity extends VBox{
	private static int posX;
	private int distance;
//	final private double[] LocationArray= {0,130,260,390,520,650,780,910,1040,1170,1300};
	private static Image PureTitanImg;
	private static Image AbnormalTitanImg;
	private static Image ArmoredTitanImg;
	private static Image ColossalTitanImg;
	private static Image AttackImg;
	private static Image DeathImg;
	
	private static final int COLUMNS  =  13;
    private static final int COUNT    =  13;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 22;
    private static final int HEIGHT   = 33;
    
    private static final int COLUMNS2  =  18;
    private static final int COUNT2    =  18;
    private static final int OFFSET_X2 =  0;
    private static final int OFFSET_Y2 =  0;
    private static final int WIDTH2    = 43;
    private static final int HEIGHT2   = 37;
	
	private ImageView titanImage;
	private ProgressBar healthBar;
	public TranslateTransition transition;
	private Timeline timeline;
	private boolean hasMovedLast; 
	private boolean isDead; 
	@FXML
	private AnchorPane lane;
	private double health;
	private int baseHealth;
	KeyValue keyValue;
	KeyFrame keyFrame;
	private ImageView imgView;
	final Animation animationWalk ;
	final Animation animationAttack ;
	//private static Translate translate;
	static {
		try {
			PureTitanImg = new Image("file:Images/Skeleton Walk.png");
			AbnormalTitanImg = new Image("file:Images/Skeleton Walk.png");
			ArmoredTitanImg = new Image("file:Images/Skeleton Walk.png");
			ColossalTitanImg = new Image("file:Images/Skeleton Walk.png");
			AttackImg = new Image("file:Images/SkeletonAttack.png");
			DeathImg = new Image("file:Images/SkeletonDead.gif");
			//translate = new Translate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public TitanEntity(int BaseHealth,Titan titan) {
		this.hasMovedLast = false;
		this.isDead = false;
		healthBar = new ProgressBar(1);
		//healthBar.setProgress(1);
		titanImage = new ImageView();
		if(titan instanceof PureTitan) {
			titanImage.setImage(PureTitanImg);
	        titanImage.setFitHeight(1.5*15);
	        titanImage.setFitWidth(15);
		}else if(titan instanceof AbnormalTitan){
			titanImage.setImage(AbnormalTitanImg);
	        titanImage.setFitHeight(1.5*10);
	        titanImage.setFitWidth(10);
		}else if(titan instanceof ArmoredTitan){
			titanImage.setImage(ArmoredTitanImg);
	        titanImage.setFitHeight(1.5*15);
	        titanImage.setFitWidth(15);
		}else if(titan instanceof ColossalTitan){
			titanImage.setImage(ColossalTitanImg);
	        titanImage.setFitHeight(1.5*60);
	        titanImage.setFitWidth(60);
		}
		titanImage.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		this.animationWalk = new SpriteAnimation(
        		titanImage,
                Duration.millis(900),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
		this.animationWalk.setCycleCount(3);
		titanImage.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
		this.animationAttack = new SpriteAnimation(
        		titanImage,
                Duration.millis(900),
                COUNT2, COLUMNS2,
                OFFSET_X2, OFFSET_Y2,
                WIDTH2, HEIGHT2
        );
		this.animationAttack.setCycleCount(1);
        //animation.play();
        this.getChildren().addAll(healthBar,titanImage);
        posX = 1300;
        this.distance = titan.getDistance();
        this.setLayoutX(1260);
        //myGrid.getChildren().add(this);
        // Initialize timeline and keyframe
        timeline = new Timeline();
        keyValue = new KeyValue(healthBar.progressProperty(), 1.0); // Initial progress
        keyFrame = new KeyFrame(Duration.ZERO, keyValue); // Start immediately
        timeline.getKeyFrames().add(keyFrame);
        this.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    }
	public void move(int Newdistance,int speed){
		
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration((Duration.seconds(2)));
		transition.setNode(this);
		transition.setCycleCount(1);
		if(Newdistance <= 0) {
			transition.setByX(-(this.distance*19));
			System.out.print("I am here:"+-(this.distance*19));
		 	this.hasMovedLast =true;
		}else {
			transition.setByX(-speed*19);
		}
		
		//this.transition=transition;
		
		//transition.setFromX(0);
		//transition.setToX(-25);
		
		this.animationWalk.play();
		transition.play();
		//posX -= (speed*20);
		this.distance = Newdistance;
//		keyValue = new KeyValue(healthBar.progressProperty(), health);
//		KeyFrame keyFrame = new KeyFrame(new Duration(1000), keyValue);
//		timeline.getKeyFrames().setAll(keyFrame); // Replace existing keyframe
//	    timeline.play();
		
		//Translate translate = new Translate();
		//translate.setX((distance - 20)*10);
		//transition.setOnFinished(e->this.getTransforms().add(translate));
		//this.setLayoutX(distance*25);
		//this.getTransforms().add(translate);
	}
	public void moveLast(int distance) {
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration((Duration.seconds(2)));
		transition.setNode(this);
		transition.setByX(-(posX-distance)*22);
		transition.play();
	}
	public void attack() {
		//this.setLayoutX(20);
        titanImage.setImage(AttackImg);
        titanImage.setScaleX(1.6);
        this.animationAttack.play();
	}
	public void death() {
		updateProgress(0);
		this.isDead = true;
		titanImage.setImage(DeathImg);;
		FadeTransition fade=new FadeTransition();
		fade.setDuration((Duration.seconds(3)));
		fade.setNode(this);
		fade.setCycleCount(1);  
		fade.setFromValue(10);  
        fade.setToValue(5); 
		fade.play();
		TranslateTransition transition=new TranslateTransition();
		transition.setDuration((Duration.seconds(3)));
		transition.setNode(this);
		transition.setCycleCount(1);
		transition.setByY(10);
		transition.play();
		transition.setOnFinished(e->lane.getChildren().remove(this));
	}
	
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	//	public void hurt() {
//		this.imgView = new ImageView(images[0]);
//	    Timeline timeLine = new Timeline();
//	    Collection<KeyFrame> frames = timeLine.getKeyFrames();
//	    Duration frameGap = Duration.millis(256);
//	    Duration frameTime = Duration.ZERO ;
//	    for (Image img : images) {
//	        frameTime = frameTime.add(frameGap);
//	        frames.add(new KeyFrame(frameTime, e -> imgView.setImage(img)));
//	    }
//	    timeLine.setCycleCount(Timeline.INDEFINITE);
//	    timeLine.play();
//	}
	public void updateProgress(double health) {
		healthBar.setProgress(health);
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public void setBaseHealth(int baseHealth) {
		this.baseHealth = baseHealth;
	}
	public void setLane(AnchorPane lane) {
		this.lane = lane;
	}
	public AnchorPane getLane() {
		return this.lane;
	}
	public boolean isHasMovedLast() {
		return hasMovedLast;
	}
	public void setHasMovedLast(boolean hasMovedLast) {
		this.hasMovedLast = hasMovedLast;
	}

	
	
}