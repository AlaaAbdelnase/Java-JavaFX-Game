package application;
	
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

//import javafx.scene.layout.BorderPane;

import game.animations.SpriteAnimation;
import game.engine.Battle;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;

public class Main extends Application{
	private static final Image IMAGE = new Image("file:Images/BookForMyBestFriendFullTitile.png");
	private static final Image IMAGE2 = new Image("file:Images/BookForMyBestFriendFullStart.png");
	
	private static final Image ImageW1 = new Image("file:Images/PiercingCannon.png");
	private static final Image ImageW2 = new Image("file:Images/SniperCannon.png");
	private static final Image ImageW3 = new Image("file:Images/VolleySpreadCannon.png");
	private static final Image ImageW4 = new Image("file:Images/WallTrap.png");
	private static final Image Cursor = new Image("file:Images/Cursor.png");
	private static final Image LoadCursor = new Image("file:Images/LoadCurso.png");
	private static final Image Hand = new Image("file:Images/Hand.png");
	private static final Image LoadBookImg = new Image("file:Images/LoadBook.png");
	private static final Image m1 = new Image("file:Images/m1.png");
	private static final Image m2 = new Image("file:Images/m2.png");
	private static final Image m3 = new Image("file:Images/m3.png");
	
    private static final int COLUMNS  =  10;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 2880;
    private static final int HEIGHT   = 1620;
    
    private static final int COLUMNS2  =  4;
    private static final int COUNT2    =  4;
    private static final int OFFSET_X2 =  0;
    private static final int OFFSET_Y2 =  0;
    private static final int WIDTH2  = 190;
    private static final int HEIGHT2   = 160;
    
    private static boolean HardDiff = true;
    private static boolean isAI = false;
    
    static Battle battle;
    
    private Stage stage;
	private static Scene scene;
	
	private static int lane = 0;
	private static int WEAPON_CODE = 0;
	private static BorderPane root ;
	private static Scene Mscene;
	
	
	@FXML
	private Label myLabel; 
	@FXML
	private Button PiercingCannon;
	@FXML
	private Button SniperCannon;
	@FXML
	private Button VolleySpreadCannon;
	@FXML
	private Button WallTrap;
	@FXML
	private Button lane1;
	@FXML
	private Button lane2;
	@FXML
	private Button lane3;
	@FXML
	private Button lane4;
	@FXML
	private Button lane5;
	@FXML
	private Button exit;
	@FXML
	private Button next;
	@FXML
	private Button MainMenu;
	@FXML
	private Button ready;
	@FXML
	private Button passTurnTut;
	@FXML
	private Button laneSelect;
	@FXML
	private Button selectWeapon;
	@FXML
	private Label score;
	@FXML
	private Label resources2;
	@FXML
	private Label turn;
	@FXML
	private Label phase;
	@FXML
	private Label price;
	@FXML
	private Label damage;
	@FXML
	private Label type;
	@FXML
	private Label mulVolleySpreadCannonlane1;
	@FXML
	private Label mulPiercingCannonlane1;
	@FXML
	private Label mulSniperCannonlane1;
	@FXML
	private Label mulWallTraplane1;
	@FXML
	private Label mulVolleySpreadCannonlane2;
	@FXML
	private Label mulPiercingCannonlane2;
	@FXML
	private Label mulSniperCannonlane2;
	@FXML
	private Label mulWallTraplane2;
	@FXML
	private Label mulVolleySpreadCannonlane3;
	@FXML
	private Label mulPiercingCannonlane3;
	@FXML
	private Label mulSniperCannonlane3;
	@FXML
	private Label mulWallTraplane3;
	@FXML
	private Label mulVolleySpreadCannonlane4;
	@FXML
	private Label mulPiercingCannonlane4;
	@FXML
	private Label mulSniperCannonlane4;
	@FXML
	private Label mulWallTraplane4;
	@FXML
	private Label mulVolleySpreadCannonlane5;
	@FXML
	private Label mulPiercingCannonlane5;
	@FXML
	private Label mulSniperCannonlane5;
	@FXML
	private Label mulWallTraplane5;
	@FXML
	private Label DangerLevelLane1;
	@FXML
	private Label DangerLevelLane2;
	@FXML
	private Label DangerLevelLane3;
	@FXML
	private Label DangerLevelLane4;
	@FXML
	private Label DangerLevelLane5;
	@FXML
	private Label gameOver;
	@FXML
	private ImageView weapon;
	@FXML
	private ImageView VolleySpreadCannonlane1;
	@FXML
	private ImageView PiercingCannonlane1;
	@FXML
	private ImageView SniperCannonlane1;
	@FXML
	private ImageView WallTraplane1;
	@FXML
	private ImageView VolleySpreadCannonlane2;
	@FXML
	private ImageView PiercingCannonlane2;
	@FXML
	private ImageView SniperCannonlane2;
	@FXML
	private ImageView WallTraplane2;
	@FXML
	private ImageView VolleySpreadCannonlane3;
	@FXML
	private ImageView PiercingCannonlane3;
	@FXML
	private ImageView SniperCannonlane3;
	@FXML
	private ImageView WallTraplane3;
	@FXML
	private ImageView VolleySpreadCannonlane4;
	@FXML
	private ImageView PiercingCannonlane4;
	@FXML
	private ImageView SniperCannonlane4;
	@FXML
	private ImageView WallTraplane4;
	@FXML
	private ImageView VolleySpreadCannonlane5;
	@FXML
	private ImageView PiercingCannonlane5;
	@FXML
	private ImageView SniperCannonlane5;
	@FXML
	private ImageView WallTraplane5;
	@FXML
	private ImageView LoadBook;
	@FXML
	private ImageView phaseIcon;
	@FXML
	private AnchorPane lane1Pane;
	@FXML
	private AnchorPane lane2Pane;
	@FXML
	private AnchorPane lane3Pane;
	@FXML
	private AnchorPane lane4Pane;
	@FXML
	private AnchorPane lane5Pane;
	@FXML
	private AnchorPane mainPane;
	@FXML
	private Rectangle Wall1;
	@FXML
	private Rectangle Wall2;
	@FXML
	private Rectangle Wall3;
	@FXML
	private Rectangle Wall4;
	@FXML
	private Rectangle Wall5;
	@FXML
	private ProgressIndicator Wall1Progress;
	@FXML
	private ProgressIndicator Wall2Progress;
	@FXML
	private ProgressIndicator Wall3Progress;
	@FXML
	private ProgressIndicator Wall4Progress;
	@FXML
	private ProgressIndicator Wall5Progress;
	@FXML
	Parent Gameroot ;
	private static Parent GameOverroot;
	@FXML
	private Label finalScore;
	static int finalscore =0;
	static Stage primaryStage;
	static Scene MainScene;
	
	Animation animationBookLoad;

	public void start(Stage primaryStage) throws Exception {
		try {
			
			this.primaryStage = primaryStage;
			Image icon = new Image("file:Images/Icon.png");
			primaryStage.setResizable(false);
	        final ImageView imageView = new ImageView(IMAGE);
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
	        
	        final ImageView imageView2 = new ImageView(IMAGE2);
	        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
	        final Animation animation2 = new SpriteAnimation(
	                imageView2,
	                Duration.millis(1000),
	                COUNT, COLUMNS,
	                OFFSET_X, OFFSET_Y,
	                WIDTH, HEIGHT
	        );
	        imageView2.setFitHeight(800) ;
	        imageView2.setFitWidth(1490) ;
	        animation2.setCycleCount(1);
	        animation2.play();
	        
	        final ImageView imageView4 = new ImageView(IMAGE);
	        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
	        final Animation animation4 = new SpriteAnimation(
	                imageView4,
	                Duration.millis(1000),
	                COUNT, COLUMNS,
	                OFFSET_X, OFFSET_Y,
	                WIDTH, HEIGHT
	        );
	        imageView4.setFitHeight(800) ;
	        imageView4.setFitWidth(1490) ;
	        animation4.setCycleCount(1);
	        animation4.play();
	        
	        BorderPane root = new BorderPane();
	        root.setCenter(imageView);//start game
	    	scene = new Scene(root,1550,800); 
	    	scene.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
	    	MainScene = scene;
	        
			//Gamescene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent Gameroot = FXMLLoader.load(getClass().getResource("Game.fxml"));
			
			BorderPane root3 = new BorderPane();
			Scene Setscene = new Scene(root3,1550,800);//Chosse difficuit
			Setscene.setCursor(new ImageCursor(Cursor));
			Setscene.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
			primaryStage.setScene(Setscene);
			root3.setCenter(imageView2);
			
			BorderPane root4 = new BorderPane();
			Scene scene4 = new Scene(root4,1550,800);//instrutions
			scene4.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
			scene4.setCursor(new ImageCursor(Cursor));
			primaryStage.setScene(Setscene);
			root4.setCenter(imageView4);
			
	        Font Mainfont = Font.loadFont("file:Fonts/Enchanted Land.otf", 50);
	        Font Subfont = Font.loadFont("file:Fonts/Minecraft.ttf", 25);
	        
//	        Text text = new Text();
//			text.setFont(Mainfont);
//			text.setText("Attack On Titan");
//			text.setX(150);
//			text.setY(100);
//			text.setFill(Color.BLACK);
//			root.getChildren().add(text) ;
	        
			
	      
	        Button StartButton = new Button("Start Game");
	        StartButton.setFont(Subfont);
	        StartButton.setMaxWidth(250);
	        StartButton.setMaxHeight(200);
	        StartButton.setCursor(new ImageCursor(Hand)); 
	        StartButton.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(scene4);
	
				}
			});	
	        
	        Button AIMode = new Button("AI Mode OFF");
	        AIMode.setFont(Subfont);
	        AIMode.setMaxWidth(250);
	        AIMode.setMaxHeight(200);
	        AIMode.setCursor(new ImageCursor(Hand)); 
	        AIMode.setOnAction(new EventHandler <ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if(isAI== false) {
						isAI = true;
						AIMode.setText("AI Mode ON");
					}else {
						isAI = false;
						AIMode.setText("AI Mode OFF");
					}
				}
			});
	        
	        Image MenuImg = new Image("file:Images/MainMenuTex.png");
	        ImageView imageViewMenu = new ImageView(MenuImg);
	        imageViewMenu.setFitWidth(250) ;
	        imageViewMenu.setFitHeight(150);
	        ImageView imageViewMenu1 = new ImageView(MenuImg);
	        imageViewMenu1.setFitWidth(250) ;
	        imageViewMenu1.setFitHeight(170);
	        ImageView imageViewMenu2 = new ImageView(MenuImg);
	        imageViewMenu2.setFitWidth(250) ;
	        imageViewMenu2.setFitHeight(170);
	        ImageView imageViewMenu3 = new ImageView(MenuImg);
	        imageViewMenu3.setFitWidth(250) ;
	        imageViewMenu3.setFitHeight(150);
	        
	        Button ChangeDiff = new Button("Change Difficulty");
	        ChangeDiff.setFont(Subfont);
	        ChangeDiff.setMaxWidth(250);
	        ChangeDiff.setMaxHeight(200);
	        ChangeDiff.setCursor(new ImageCursor(Hand)); 
	        ChangeDiff.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(Setscene);
					animation2.play();
					animation2.delayProperty();
		
				}
			});	
	        
			GridPane mainMenu = new GridPane();
			root.setLeft(mainMenu) ;
			mainMenu.add(imageViewMenu, 0, 1);
			mainMenu.add(imageViewMenu1, 0, 3);
			mainMenu.add(StartButton, 0, 4);
			mainMenu.add(imageViewMenu2, 0, 5);
			mainMenu.add(ChangeDiff, 0, 6);
			mainMenu.add(imageViewMenu3, 0, 7);
			mainMenu.add(AIMode,0,8);
			
			//Setscene
			
	        Button Easy = new Button("Easy");
	        Easy.setFont(Subfont);
	        Easy.setMaxWidth(250);
	        Easy.setMaxHeight(200);
	        Easy.setCursor(new ImageCursor(Hand));
	        Easy.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(scene);
					animation.play();
					animation.delayProperty();
					HardDiff = false;
	
				}
			});
	        
	        Button Hard = new Button("Hard");
	        Hard.setFont(Subfont);
	        Hard.setMaxWidth(250);
	        Hard.setMaxHeight(200);
	        Hard.setCursor(new ImageCursor(Hand));
	        Hard.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(scene);
					animation.play();
					animation.delayProperty();
					HardDiff = true;
	
				}
			});
			
	        ImageView imageViewMenu4 = new ImageView(MenuImg);
	        imageViewMenu4.setFitWidth(250) ;
	        imageViewMenu4.setFitHeight(150);
	        
	        GridPane Diffmenu = new GridPane();
			root3.setLeft(Diffmenu) ;
			Diffmenu.add(imageViewMenu4, 0, 1);
			Diffmenu.add(Easy, 0, 4);
			Diffmenu.add(Hard, 0, 6);
			
			//Scene4
			
			Image NextImg = new Image("file:Images/Next.png");
	        ImageView imageViewNext = new ImageView(NextImg);
	        imageViewNext.setFitHeight(30) ;
	        imageViewNext.setFitWidth(30) ;
	        
	        Button Next = new Button("Ready",imageViewNext);
	        Next.setFont(Subfont);
	        Next.setMaxWidth(250);
	        Next.setMaxHeight(200);
	        Next.setCursor(new ImageCursor(Hand));
	        Next.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					animation4.play();
					animation4.delayProperty();
					// Gamescene = new Scene(Gameroot,1550,800);//Gameroot
					Parent root;
					try {
						root = FXMLLoader.load(getClass().getResource("Game.fxml"));
						stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
				    	Scene Escene = new Scene(root,1550,800);
				    	Escene.setCursor(new ImageCursor(Cursor));;
				    	primaryStage.setScene(Escene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					//score.setFont(Subfont);
					//resources2.setFont(Subfont);
					if(isHardDiff()) {
						try {
							battle = new Battle(1,0,50,5,125);
							resources2 = new Label();
							System.out.println(battle.getResourcesGathered());
							resources2.setText("Resources:"+battle.getResourcesGathered());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
						try {
							battle = new Battle(1,0,50,3,250);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//					Alert alert3 = new Alert(AlertType.WARNING);
//			    	alert3.setContentText("How to play");
//			    	ImageView icon1 = new ImageView(icon);
//			    	icon1.setFitHeight(40);
//			    	icon1.setFitWidth(40);
//			    	alert3.getDialogPane().setGraphic(icon1);
//			    	alert3.addEventHandler(null, null);
//			    	alert3.show();
				}
			});
	        
	        ImageView imageViewMenu41 = new ImageView(MenuImg);
	        imageViewMenu41.setFitWidth(250) ;
	        imageViewMenu41.setFitHeight(150);
	        
	        GridPane Imenu = new GridPane();
			root4.setLeft(Imenu) ;
			Imenu.add(imageViewMenu41, 0, 1);
			Imenu.add(Next, 0, 4);
	        
			
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Attack On Titan");
			scene.setCursor(new ImageCursor(Cursor));

			//GameScene
		
			
	
//			for (Lane lane : battle.getOriginalLanes()) {
//	            battleView.addLane(battle.getOriginalLanes().size());
//	        }
			
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,1550,800);
//			
//			
//			
//			
//			BorderPane root3 = new BorderPane();  
//	        Scene scene3 = new Scene(root3,1550,800);  
//	        MenuBar menubar = new MenuBar();  
//	        Menu FileMenu = new Menu("File");  
//	        MenuItem filemenu1=new MenuItem("new");  
//	        MenuItem filemenu2=new MenuItem("Save");  
//	        MenuItem filemenu3=new MenuItem("Exit");  
//	        Menu EditMenu=new Menu("Edit");  
//	        MenuItem EditMenu1=new MenuItem("Cut");  
//	        MenuItem EditMenu2=new MenuItem("Copy");  
//	        MenuItem EditMenu3=new MenuItem("Paste");  
//	        EditMenu.getItems().addAll(EditMenu1,EditMenu2,EditMenu3);  
//	        root3.setTop(menubar);  
//	        FileMenu.getItems().addAll(filemenu1,filemenu2,filemenu3);  
//	        menubar.getMenus().addAll(FileMenu,EditMenu);  
//			
//			primaryStage.setResizable(false);
//			primaryStage.setFullScreen(false);
//			primaryStage.setScene(scene);
//		
//			StartButton.setStyle("-fx-background-color: gray");
//			root.setCenter(StartButton);
//			root.setTop(main);
//			
//			Image img = new Image("file:Images/RADL_Book.png") ; 
//			ImageView view = new ImageView(img) ;
//			
//			Line line = new Line();
//			line.setStartX(200);
//			line.setStartY(200);
//			line.setEndX(500);
//			line.setEndY(200);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
//	public void render(Graphics2D g) {
//		Sprite.drawArray(g,font,word:"Alaa is masahallah the best",new Vector2f(300,300),32);
//	}
	public static void main(String[] args) {
		launch(args);
	}
	public static boolean isHardDiff() {
		return HardDiff;
	}
	public void Yes(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("BuyWeaponScene.fxml")); 
		stage = (Stage) ( (Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root,1550,800);
    	stage.setScene(scene); 
    	stage.show();
    }
	public void passturn(ActionEvent event) throws IOException{
		if(battle.getLanes().isEmpty()||battle.isGameOver()) {
			GameOver();
		}
		if(isAI==false) {
			try {
				battle.passTurn();
			}catch(NullPointerException e) {
				GameOver();
			}
		}else {
			Lane mostdangerouslane = battle.getLanes().peek();
			if(battle.getResourcesGathered()<25) {
				try {
					battle.passTurn();
				}catch(NullPointerException e) {
					GameOver();
				}
			}else {
				if(battle.getResourcesGathered()>=100) {
					VolleySpreadCannon(event);
				}else if(battle.getResourcesGathered()>=75) {
					WallTrap(event);
				}else if(mostdangerouslane.getTitans().size()>5) {
					PiercingCannon(event);
				}else {
					SniperCannon(event);
				}
				
				int i = 0;
				for(;i<battle.getOriginalLanes().size();i++) {
					if(mostdangerouslane==battle.getOriginalLanes().get(i)) {
						break;
					}
				}
				switch(i) {
				case 0:Lane1(event);break;
				case 1:Lane2(event);break;
				case 2:Lane3(event);break;
				case 3:Lane4(event);break;
				case 4:Lane5(event);break;
				}
			}
		}
		switvhBacktogame();
	}
    public void switvhBacktogame(){
    	finalscore = battle.getScore();
    	updateScene();
    }
    public void backtoMainMenu(ActionEvent event) throws IOException{
    	primaryStage.setScene(MainScene); 
		primaryStage.show();
    }
    public void showfinalscore(ActionEvent event) throws IOException{
    	finalScore.setText(finalscore+"");
    }
    public void Lane1(ActionEvent event) throws IOException {	
    	lane = 0;
    	if(battle.getLanes().isEmpty()||battle.isGameOver()) {
    		GameOver();
		}
    	if(WEAPON_CODE==0) {
    		ErrorEntity NoWeapon = new ErrorEntity("You must pick a Weapon frist bruh");
    		NoWeapon.play(lane1Pane);return;
    	}
    	try {
			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
    	switch (WEAPON_CODE) {
    	case 1:
    		PiercingCannonlane1.setImage(ImageW1);
    		mulPiercingCannonlane1.setText(Integer.parseInt(mulPiercingCannonlane1.getText())+1+"");
    		break;
    	case 2:
    		SniperCannonlane1.setImage(ImageW2);
    		mulSniperCannonlane1.setText(Integer.parseInt(mulSniperCannonlane1.getText())+1+"");
    		break;
    	case 3:
    		VolleySpreadCannonlane1.setImage(ImageW3);
    		mulVolleySpreadCannonlane1.setText(Integer.parseInt(mulVolleySpreadCannonlane1.getText())+1+"");
    		break;
    	case 4:
    		WallTraplane1.setImage(ImageW4);
    		mulWallTraplane1.setText(Integer.parseInt(mulWallTraplane1.getText())+1+"");
    		break;
    	}
    	switvhBacktogame();
    	}catch (InsufficientResourcesException  e) {
			ErrorEntity InsufficientResourcesException = new ErrorEntity("You are poor");
			InsufficientResourcesException.play(lane1Pane);return;
    	}catch( InvalidLaneException e) {
			ErrorEntity InvalidLaneException = new ErrorEntity("The lane is lost");
			InvalidLaneException.play(lane1Pane);return;	
    	}catch(NullPointerException e) {
    		GameOver();
    	} 
    	
    }
    public void Lane2(ActionEvent event) throws IOException {
    	lane = 1;
    	if(battle.getLanes().isEmpty()||battle.isGameOver()) {
    		GameOver();
		}
    	if(WEAPON_CODE==0) {
    		ErrorEntity NoWeapon = new ErrorEntity("You must pick a Weapon frist bruh");
    		NoWeapon.play(lane2Pane);return;
    	}
    	try {
			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
    	switch (WEAPON_CODE) {
    	case 1:
    		PiercingCannonlane2.setImage(ImageW1);
    		mulPiercingCannonlane2.setText(Integer.parseInt(mulPiercingCannonlane2.getText())+1+"");
    		break;
    	case 2:
    		SniperCannonlane2.setImage(ImageW2);
    		mulSniperCannonlane2.setText(Integer.parseInt(mulSniperCannonlane2.getText())+1+"");
    		break;
    	case 3:
    		VolleySpreadCannonlane2.setImage(ImageW3);
    		mulVolleySpreadCannonlane2.setText(Integer.parseInt(mulVolleySpreadCannonlane2.getText())+1+"");
    		break;
    	case 4:
    		WallTraplane2.setImage(ImageW4);
    		mulWallTraplane2.setText(Integer.parseInt(mulWallTraplane2.getText())+1+"");
    		break;
    	}
    	switvhBacktogame();
    	}catch (InsufficientResourcesException  e) {
			ErrorEntity InsufficientResourcesException = new ErrorEntity("You are poor");
			InsufficientResourcesException.play(lane2Pane);return;
    	}catch( InvalidLaneException e) {
			ErrorEntity InvalidLaneException = new ErrorEntity("The lane is lost");
			InvalidLaneException.play(lane2Pane);return;	
    	} catch(NullPointerException e) {
    		GameOver();
    	} 
	}
	public void Lane3(ActionEvent event) throws IOException {
		lane = 2;
		if(battle.getLanes().isEmpty()||battle.isGameOver()) {
			GameOver();
		}
		if(WEAPON_CODE==0) {
    		ErrorEntity NoWeapon = new ErrorEntity("You must pick a Weapon frist bruh");
    		NoWeapon.play(lane3Pane);return;
    	}
    	try {
			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
    	switch (WEAPON_CODE) {
    	case 1:
    		PiercingCannonlane3.setImage(ImageW1);
    		mulPiercingCannonlane3.setText(Integer.parseInt(mulPiercingCannonlane3.getText())+1+"");
    		break;
    	case 2:
    		SniperCannonlane3.setImage(ImageW2);
    		mulSniperCannonlane3.setText(Integer.parseInt(mulSniperCannonlane3.getText())+1+"");
    		break;
    	case 3:
    		VolleySpreadCannonlane3.setImage(ImageW3);
    		mulVolleySpreadCannonlane3.setText(Integer.parseInt(mulVolleySpreadCannonlane3.getText())+1+"");
    		break;
    	case 4:
    		WallTraplane3.setImage(ImageW4);
    		mulWallTraplane3.setText(Integer.parseInt(mulWallTraplane3.getText())+1+"");
    		break;
    	}
    	switvhBacktogame();     
    	}catch (InsufficientResourcesException  e) {
			ErrorEntity InsufficientResourcesException = new ErrorEntity("You are poor");
			InsufficientResourcesException.play(lane3Pane);return;
    	}catch( InvalidLaneException e) {
			ErrorEntity InvalidLaneException = new ErrorEntity("The lane is lost");
			InvalidLaneException.play(lane3Pane);return;	
    	} catch(NullPointerException e) {
    		GameOver();
    	} 
	}
	public void Lane4(ActionEvent event) throws IOException {
		lane = 3;
		if(battle.getLanes().isEmpty()||battle.isGameOver()) {
			GameOver();
		}
		if(WEAPON_CODE==0) {
    		ErrorEntity NoWeapon = new ErrorEntity("You must pick a Weapon frist bruh");
    		NoWeapon.play(lane4Pane);return;
    	}
    	try {
			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
    	switch (WEAPON_CODE) {
    	case 1:
    		PiercingCannonlane4.setImage(ImageW1);
    		mulPiercingCannonlane4.setText(Integer.parseInt(mulPiercingCannonlane4.getText())+1+"");
    		break;
    	case 2:
    		SniperCannonlane4.setImage(ImageW2);
    		mulSniperCannonlane4.setText(Integer.parseInt(mulSniperCannonlane4.getText())+1+"");
    		break;
    	case 3:
    		VolleySpreadCannonlane4.setImage(ImageW3);
    		mulVolleySpreadCannonlane4.setText(Integer.parseInt(mulVolleySpreadCannonlane4.getText())+1+"");
    		break;
    	case 4:
    		WallTraplane4.setImage(ImageW4);
    		mulWallTraplane4.setText(Integer.parseInt(mulWallTraplane4.getText())+1+"");
    		break;
    	}
    	switvhBacktogame();
    	}catch (InsufficientResourcesException  e) {
			ErrorEntity InsufficientResourcesException = new ErrorEntity("You are poor");
			InsufficientResourcesException.play(lane4Pane);return;
    	}catch( InvalidLaneException e) {
			ErrorEntity InvalidLaneException = new ErrorEntity("The lane is lost");
			InvalidLaneException.play(lane4Pane);return;	
    	} catch(NullPointerException e) {
    		GameOver();
    	} 
	}
	public void Lane5(ActionEvent event) throws IOException {
		lane = 4;
		if(battle.getLanes().isEmpty()||battle.isGameOver()) {
			GameOver();
		}
		if(WEAPON_CODE==0) {
    		ErrorEntity NoWeapon = new ErrorEntity("You must pick a Weapon frist bruh");
    		NoWeapon.play(lane5Pane);return;
    	}
    	try {
			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
    	switch (WEAPON_CODE) {
    	case 1:
    		PiercingCannonlane5.setImage(ImageW1);
    		mulPiercingCannonlane5.setText(Integer.parseInt(mulPiercingCannonlane5.getText())+1+"");
    		break;
    	case 2:
    		SniperCannonlane5.setImage(ImageW2);
    		mulSniperCannonlane5.setText(Integer.parseInt(mulSniperCannonlane5.getText())+1+"");
    		break;
    	case 3:
    		VolleySpreadCannonlane5.setImage(ImageW3);
    		mulVolleySpreadCannonlane5.setText(Integer.parseInt(mulVolleySpreadCannonlane5.getText())+1+"");
    		break;
    	case 4:
    		WallTraplane5.setImage(ImageW4);
    		mulWallTraplane5.setText(Integer.parseInt(mulWallTraplane5.getText())+1+"");
    		break;
    	}
    	switvhBacktogame();
    	}catch (InsufficientResourcesException  e) {
			ErrorEntity InsufficientResourcesException = new ErrorEntity("You are poor");
			InsufficientResourcesException.play(lane5Pane);return;
    	}catch( InvalidLaneException e) {
			ErrorEntity InvalidLaneException = new ErrorEntity("The lane is lost");
			InvalidLaneException.play(lane5Pane);return;	
    	} catch(NullPointerException e) {
    		GameOver();
    	} 
	}
//    public void gotoBuy(ActionEvent event) throws IOException { 
//    	try {
//			battle.purchaseWeapon(WEAPON_CODE,battle.getOriginalLanes().get(lane));
//		} catch (InsufficientResourcesException | InvalidLaneException e) {
//			Alert alert3 = new Alert(AlertType.WARNING);
//			alert3.setContentText("You don't have money");
//			alert3.show();
//		}
//    	
//    	switvhBacktogame(event);
//    }
//    public void next(ActionEvent event) throws IOException {
//    	if(battle.isGameOver()) {
//    		Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml")); 
//    		System.out.print("Swtiched");
//    		stage = (Stage) ( (Node) event.getSource()).getScene().getWindow(); 
//    		scene = new Scene(root);
//    		stage.setScene(scene); 
//    		stage.show();
//    	}
//    }
	public static int getLane() {
		return lane;
	}
	public void PiercingCannon(ActionEvent event) throws IOException {
		WEAPON_CODE = 1;
		weapon.setImage(ImageW1);
		enableAllLanes();
		price.setText("Price:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getPrice()+"K.D.");
		damage.setText("Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getDamage());
		type.setText("Type: PiercingCannon");
	}
	public void SniperCannon(ActionEvent event) throws IOException {
		 WEAPON_CODE = 2;
		 weapon.setImage(ImageW2);
		 enableAllLanes();
		 price.setText("Price:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getPrice()+"K.D.");
		damage.setText("Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getDamage());
		type.setText("Type: SniperCannon");
	}
	public void VolleySpreadCannon(ActionEvent event) throws IOException {
		 WEAPON_CODE = 3;
		 weapon.setImage(ImageW3);
		 enableAllLanes();
		 price.setText("Price:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getPrice()+"K.D.");
		damage.setText("Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getDamage());
		type.setText("Type: VolleySpreadCannon");
	}
	public void WallTrap(ActionEvent event) throws IOException {
		WEAPON_CODE = 4;
		weapon.setImage(ImageW4);
		enableAllLanes();
		price.setText("Price:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getPrice()+"K.D.");
		damage.setText("Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(WEAPON_CODE).getDamage());
		type.setText("Type: WallTrap");
	}
	public void exitGame(ActionEvent event) throws IOException {
        System.exit(0);
    }
	private void enableAllLanes() {
		for(int i=0; i<battle.getOriginalLanes().size();i++) {
        	if(!battle.getOriginalLanes().get(i).isLaneLost()) {
        		switch(i) {
        		case 0: lane1.setDisable(false);Wall1.setOpacity(1);Wall1Progress.setOpacity(1);mulVolleySpreadCannonlane1.setOpacity(1);mulPiercingCannonlane1.setOpacity(1);mulSniperCannonlane1.setOpacity(1);mulWallTraplane1.setOpacity(1);DangerLevelLane1.setOpacity(1);break;
        		case 1: lane2.setDisable(false);Wall2.setOpacity(1);Wall2Progress.setOpacity(1);mulVolleySpreadCannonlane2.setOpacity(1);mulPiercingCannonlane2.setOpacity(1);mulSniperCannonlane2.setOpacity(1);mulWallTraplane2.setOpacity(1);DangerLevelLane2.setOpacity(1);break;
        		case 2: lane3.setDisable(false);Wall3.setOpacity(1);Wall3Progress.setOpacity(1);mulVolleySpreadCannonlane3.setOpacity(1);mulPiercingCannonlane3.setOpacity(1);mulSniperCannonlane3.setOpacity(1);mulWallTraplane3.setOpacity(1);DangerLevelLane3.setOpacity(1);break;
        		case 3: lane4.setDisable(false);Wall4.setOpacity(1);Wall4Progress.setOpacity(1);mulVolleySpreadCannonlane4.setOpacity(1);mulPiercingCannonlane4.setOpacity(1);mulSniperCannonlane4.setOpacity(1);mulWallTraplane4.setOpacity(1);DangerLevelLane4.setOpacity(1);break;
        		case 4: lane5.setDisable(false);Wall5.setOpacity(1);Wall5Progress.setOpacity(1);mulVolleySpreadCannonlane5.setOpacity(1);mulPiercingCannonlane5.setOpacity(1);mulSniperCannonlane5.setOpacity(1);mulWallTraplane5.setOpacity(1);DangerLevelLane5.setOpacity(1);break;
        		}
        	}
		}
	}
//	public void updateScore(){
//		scoreLabel.setText("Score"+battle.getScore());
//  }
//	public void updateScore(ActionEvent event) {
//		myLabel.setText("Score:"+battle.getScore()+" Resources:"+battle.getResourcesGathered());	
//	}
	public void ready(ActionEvent event) throws IOException {
		//Media media = new Media("file:Sound/BackGroundMusic.mp3");  
//		String musicFile = "file:Sound/BackGroundMusic.mp3";
//		Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound); 
//        mediaPlayer.setAutoPlay(true); 
		setViewMountain();
		LoadBook.setImage(LoadBookImg);
		LoadBook.setViewport(new Rectangle2D(OFFSET_X2, OFFSET_Y2, WIDTH2, HEIGHT2));
        this.animationBookLoad = new SpriteAnimation(
        		LoadBook,
                Duration.millis(500),
                COUNT2, COLUMNS2,
                OFFSET_X2, OFFSET_Y2,
                WIDTH2, HEIGHT2
        );
        animationBookLoad.setCycleCount(3);
        //animationBookLoad.play();
		score.setText("Score:"+battle.getScore());
		resources2.setText("Resources:"+battle.getResourcesGathered());
		turn.setText("Turn:"+battle.getNumberOfTurns());
		phase.setText("Phase:"+battle.getBattlePhase());
		ready.setOpacity(0);
		if(isAI==false) {
			PiercingCannon.setDisable(false);
			SniperCannon.setDisable(false);
			VolleySpreadCannon.setDisable(false);
			WallTrap.setDisable(false);
			enableAllLanes();
		}else {
			next.setText("AI Turn");
		}
		next.setDisable(false);
	}
	public void disableAllButtons() {
		lane1.setDisable(true);
		lane2.setDisable(true);
		lane3.setDisable(true);
		lane4.setDisable(true);
		lane5.setDisable(true);
		next.setDisable(true);
	}
	public void enabelButtons() {
		if(isAI==false) {
			lane1.setDisable(false);
			lane2.setDisable(false);
			lane3.setDisable(false);
			if(HardDiff) {
				lane4.setDisable(false);
				lane5.setDisable(false);
			}
		}
		next.setDisable(false);
	}
	private void updateScene() {  //gui
		
		setViewMountain();
		disableAllButtons();
		animationBookLoad.play();
		animationBookLoad.setOnFinished(e->enabelButtons());
		//delay(5000, () -> label.setText("Hello World"));
		score.setText("Score:"+battle.getScore());
		resources2.setText("Resources:"+battle.getResourcesGathered());
		turn.setText("Turn:"+battle.getNumberOfTurns());
		phase.setText("Phase:"+battle.getBattlePhase());
        for(int i=0; i<battle.getOriginalLanes().size();i++) {
        	AnchorPane currlaneView = null;
        	ProgressIndicator currWallPro = null;
        	Rectangle currWallView = null;
        	Label currDangerLevel = null;
        	Lane currLane = battle.getOriginalLanes().get(i);
        	switch(i) {
			case 0:
				currlaneView = lane1Pane;
				currWallPro = Wall1Progress;
				currWallView = Wall1;
				currDangerLevel = DangerLevelLane1;
				break;
			case 1:
				currlaneView = lane2Pane;
				currWallPro = Wall2Progress;
				currWallView = Wall2;
				currDangerLevel = DangerLevelLane2;
				break;
			case 2:
				currlaneView = lane3Pane;
				currWallPro = Wall3Progress;
				currWallView = Wall3;
				currDangerLevel = DangerLevelLane3;
				break;
			case 3:
				currlaneView = lane4Pane;
				currWallPro = Wall4Progress;
				currWallView = Wall4;
				currDangerLevel = DangerLevelLane4;
				break;
			case 4:
				currlaneView = lane5Pane;
				currWallPro = Wall5Progress;
				currWallView = Wall5;
				currDangerLevel = DangerLevelLane5;
				break;
    		}
        	currWallPro.setProgress(currLane.getLaneWall().getCurrentHealth()/(double)currLane.getLaneWall().getBaseHealth());
        	if(!currLane.isLaneLost()) {
        		currDangerLevel.setText(currLane.getDangerLevel()+"");
        		for(int j =0;j<currLane.getDeadtitans().size();j++){
        			Titan currDead = currLane.getDeadtitans().get(j);
        			TitanEntity currEntityDead = currLane.getTitansEntity().get(currDead);
        			//currlaneView.getChildren().remove(currEntityDead);
        			currEntityDead.death();
        		}
        		PriorityQueue<Titan> checked = new PriorityQueue<>();
        		ArrayList<Integer> postitan = new ArrayList<>();
        		while(!currLane.getTitans().isEmpty()){
        			Titan curr =currLane.getTitans().remove();
        			checked.add(curr);
        			postitan.add(curr.getDistance());
        			TitanEntity currEntity = currLane.getTitansEntity().get(curr);
        			if(currEntity.getLane()!=null) {
        				//currlaneView.getChildren().remove(currEntity);
        			}else {
        				currEntity.setLane(currlaneView);
        				currlaneView.getChildren().add(currLane.getTitansEntity().get(curr));
        			}
        			//currlaneView.getChildren().add(currLane.getTitansEntity().get(curr));
        			if(!curr.hasReachedTarget()&&!currEntity.isDead()) {
        				currEntity.move(curr.getDistance(),curr.getSpeed());
        			}else if(!currEntity.isHasMovedLast()&&!currEntity.isDead()){
        				currEntity.move(curr.getDistance(),curr.getSpeed());
        				currEntity.setHasMovedLast(true);
        			}else if(!currEntity.isDead()){
        				currEntity.attack();
        			}
//        				currlaneView.getChildren().remove(currEntity);
//        				currlaneView.getChildren().add(currEntity);
//        				currEntity.setLayoutX(20);
        				//if(!currEntity.isHasMovedLast()) {
        					//currlaneView.getChildren().remove(currEntity);
        					//currEntity.moveLast(curr.getDistance());
        					//currlaneView.getChildren().add(currEntity);
        					//currEntity.setHasMovedLast(true);
        				//}
        				//currEntity.attack();
        			//}
//					currEntity.setBaseHealth(curr.getBaseHealth());
            		currEntity.updateProgress(((double)(curr.getCurrentHealth())/curr.getBaseHealth()));
//					TranslateTransition translate = new TranslateTransition(); 
//					translate.setNode(image);
//					translate.setDuration(Duration.millis(1000));
//					translate.setCycleCount (1);
//					translate.setByX(-10);
//					translate.setAutoReverse (true);
//					translate.play();
        		}
        		System.out.print("lane "+i);
    			System.out.println(postitan);
        		battle.getOriginalLanes().get(i).getTitans().addAll(checked);
        	}else {
        		currlaneView.getChildren().removeAll();
        		if(!currLane.isLostDisplayed()) {
        			TranslateTransition transition=new TranslateTransition();
        			transition.setDuration((Duration.seconds(2)));
        			transition.setNode(currWallView);
        			transition.setCycleCount(1);
        			transition.setFromY(0);;
        			transition.setToY(10);
        			transition.play();
        			FadeTransition fade=new FadeTransition();
        			fade.setDuration((Duration.seconds(2)));
        			fade.setNode(currWallView);
        			fade.setCycleCount(1);  
        			fade.setFromValue(10);  
        	        fade.setToValue(0); 
        			fade.play();
            		currlaneView.getChildren().clear();
            		WariningEntity laneIsLost = new WariningEntity("Lane is Lost :(",currlaneView);
        			currLane.setLostDisplayed(true);
        		}
        		//laneIsLost.play(currlaneView);
        	}
        }
	}
	private void playAnimation() {
		
	}
//    public GridPane createShop(){
//        	GridPane rootShop=new GridPane();
//        	rootShop.getStylesheets().add(getClass().getResource("application2.css").toExternalForm());
//        	rootShop.setLayoutX(100);
//        	rootShop.setLayoutY(100);
//        	rootShop.setPrefWidth(600);
//        	rootShop.setPrefHeight(800);
//        	rootShop.setHgap(10);
//        	rootShop.setVgap(10);
//        	rootShop.setPadding(new Insets(10));
//        	Button btn1=new Button("PiercingCannon");
//        	btn1.setOnAction(new EventHandler <ActionEvent>(){
//        		public void handle(ActionEvent event) { 
//        			WEAPON_CODE = 1;
//        			byWeapon.setDisable(false);
//        			mainPane.getChildren().remove(rootShop);
//        		}
//        	});
//        	Button btn2=new Button("SniperCannon");
//        	btn2.setOnAction(new EventHandler <ActionEvent>(){
//        		public void handle(ActionEvent event) { 
//        			WEAPON_CODE = 2;	
//        			byWeapon.setDisable(false);
//        			mainPane.getChildren().remove(rootShop);
//     		    }
//        	});
//        	Button btn3=new Button("VolleySpreadCannon");
//        	btn3.setOnAction(new EventHandler <ActionEvent>(){
//        		public void handle(ActionEvent event) { 
//        			WEAPON_CODE = 3;	
//        			byWeapon.setDisable(false);
//        			mainPane.getChildren().remove(rootShop);
//     		    }
//        	});
//        	Button btn4=new Button("WallTrap");
//        	btn4.setOnAction(new EventHandler <ActionEvent>(){
//        		public void handle(ActionEvent event) { 
//        			WEAPON_CODE = 4;	
//        			byWeapon.setDisable(false);
//        			mainPane.getChildren().remove(rootShop);
//     		    }
//        	});
//        	Label l1=new Label("Price:"+battle.getWeaponFactory().getWeaponShop().get(1).getPrice()+"K.D."+"\n"+"Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(1).getDamage()+"\n"+"Type: PiercingCannon");
//        	Label l2=new Label("Price:"+battle.getWeaponFactory().getWeaponShop().get(2).getPrice()+"K.D."+"\n"+"Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(2).getDamage()+"\n"+"Type: SniperCannon");
//        	Label l3=new Label("Price:"+battle.getWeaponFactory().getWeaponShop().get(3).getPrice()+"K.D."+"\n"+"Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(3).getDamage()+"\n"+"Type: VolleySpreadCannon");
//        	Label l4=new Label("Price:"+battle.getWeaponFactory().getWeaponShop().get(4).getPrice()+"K.D."+"\n"+"Base Damage:"+battle.getWeaponFactory().getWeaponShop().get(4).getDamage()+"\n"+"Type: WallTrap");
//        	
//        	rootShop.add(btn1, 0, 0);
//        	rootShop.add(btn2, 1, 0);
//        	rootShop.add(btn3, 2, 0);
//        	rootShop.add(btn4, 3, 0);
//        	
//        	rootShop.add(l1, 0, 1);
//        	rootShop.add(l2, 1, 1);
//        	rootShop.add(l3, 2, 1);
//        	rootShop.add(l4, 3, 1);
//        	
//        	return rootShop;
//        }
//        
//	public void buyWeapon(ActionEvent event) throws IOException {
//    			mainPane.getChildren().add(createShop());	
//	}
	public void selectWeapon(ActionEvent event) throws IOException {
		FadeInFadeOut(selectWeapon,laneSelect);
		PiercingCannon.setCursor(new ImageCursor(Hand));
		SniperCannon.setCursor(new ImageCursor(Hand));
		VolleySpreadCannon.setCursor(new ImageCursor(Hand));
		WallTrap.setCursor(new ImageCursor(Hand));
		lane1.setCursor(new ImageCursor(Hand));
		lane2.setCursor(new ImageCursor(Hand));
		lane3.setCursor(new ImageCursor(Hand));
		lane4.setCursor(new ImageCursor(Hand));
		lane5.setCursor(new ImageCursor(Hand));
		exit.setCursor(new ImageCursor(Hand));
		next.setCursor(new ImageCursor(Hand));
		MainMenu.setCursor(new ImageCursor(Hand));
		ready.setCursor(new ImageCursor(Hand));
		passTurnTut.setCursor(new ImageCursor(Hand));
		laneSelect.setCursor(new ImageCursor(Hand));
		selectWeapon.setCursor(new ImageCursor(Hand));
	}
	public void laneSelect(ActionEvent event) throws IOException {
		FadeInFadeOut(laneSelect,passTurnTut);
	}
	public void passTurnTut(ActionEvent event) throws IOException {
		FadeInFadeOut(passTurnTut,ready);
	}
	public void FadeInFadeOut(Node n1,Node n2) {
		n1.setDisable(true);
		FadeTransition fadeout=new FadeTransition();
		fadeout.setDuration((Duration.seconds(1)));
		fadeout.setNode(n1);
		fadeout.setCycleCount(1);  
		fadeout.setFromValue(10);  
        fadeout.setToValue(0); 
		fadeout.play();
		TranslateTransition up=new TranslateTransition();
		up.setDuration((Duration.seconds(1)));
		up.setNode(n1);
		up.setCycleCount(1);
		up.setByY(10);;
		up.play();
		FadeTransition fadein=new FadeTransition();
		fadein.setDuration((Duration.seconds(1)));
		fadein.setNode(n2);
		fadein.setCycleCount(1);  
		fadein.setFromValue(0);  
        fadein.setToValue(10); 
		fadein.play();
		fadein.setOnFinished(e->n2.setDisable(false));
		TranslateTransition down=new TranslateTransition();
		down.setDuration((Duration.seconds(1)));
		down.setNode(n2);
		down.setCycleCount(1);
		down.setByY(-10);;
		down.play();
	}
	public void FadeIn(Node n2) {
		FadeTransition fadein=new FadeTransition();
		fadein.setDuration((Duration.seconds(1)));
		fadein.setNode(n2);
		fadein.setCycleCount(1);  
		fadein.setFromValue(0);  
        fadein.setToValue(10); 
		fadein.play();
		fadein.setOnFinished(e->n2.setDisable(false));
		TranslateTransition down=new TranslateTransition();
		down.setDuration((Duration.seconds(1)));
		down.setNode(n2);
		down.setCycleCount(1);
		down.setByY(-10);;
		down.play();
	}
	public void GameOver() {
		disableAllButtons();
		FadeIn(gameOver);
		FadeIn(MainMenu);
		finalScore.setText("Finail Score = "+finalscore+"");
		FadeIn(finalScore);
	}
	public void setViewMountain() {
		switch(battle.getBattlePhase()) {
		case EARLY:phaseIcon.setImage(m1);break;
		case INTENSE:phaseIcon.setImage(m2);break;
		case GRUMBLING:phaseIcon.setImage(m3);break;
		}
	}
 }