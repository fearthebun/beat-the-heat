import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * @author Alyssa Wang and Nayaab Ali
 * @version 1
 * May 30 2019
 * Time spent: 1 hour
 * Instructions class
 * Makes the instructions screens
 *
 * Variable        Type       Purpose
 * stage           Stage      makes a Stage
 */
public class Level1Education{
    private Stage stage;

    /**
     *
     * @param stage Stage Object
     */
    public Level1Education(Stage stage) {
        this.stage = stage;
    }

    /**
     * Page 1 for instructions
     */
    public void page1() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Image newGame = new Image("Resources/lvl1edu1.png");
        BackgroundImage img = new BackgroundImage(newGame, null, null, null, null);
        Background background = new Background(img);

        // set background
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 1120, 600);

        scene.setOnKeyPressed(e -> {
                    switch (e.getCode()){
                        case ESCAPE:
                            new MainMenu(stage).display();
                            break;
                        case RIGHT:
                            page2();
                            break;
                    }
                }
        );
        stage.setScene(scene);
    }

    /**
     * Page 2 for instructions
     */
    public void page2() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Image newGame = new Image("Resources/lvl1edu2.png");
        BackgroundImage img = new BackgroundImage(newGame, null, null, null, null);
        Background background = new Background(img);

        // set background
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 1120, 600);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case ESCAPE:
                    new MainMenu(stage).display();
                    break;
                case RIGHT:
                    page3();
                    break;
                case LEFT:
                    page1();
                    break;
            }
        });
        stage.setScene(scene);
    }

    /**
     * Page 3 for instructions
     */
    public void page3() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Image newGame = new Image("Resources/lvl1edu3.png");
        BackgroundImage img = new BackgroundImage(newGame, null, null, null, null);
        Background background = new Background(img);

        // set background
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 1120, 600);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case ESCAPE:
                    new MainMenu(stage).display();
                    break;
                case LEFT:
                    page2();
                    break;
                case RIGHT:
                    page4();
                    break;
            }
        });
        stage.setScene(scene);
    }


    /**
     * Page 3 for instructions
     */
    public void page4() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.BOTTOM_CENTER);

        Image newGame = new Image("Resources/lvl1edu4.png");
        BackgroundImage img = new BackgroundImage(newGame, null, null, null, null);
        Background background = new Background(img);

        // set background
        vbox.setBackground(background);

        Scene scene = new Scene(vbox, 1120, 600);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case ESCAPE:
                    Stage newWindow = new Stage();
                    newWindow.setTitle("PICASSO");
                    newWindow.show();
                    new MainMenu(newWindow).display();
                    stage.close();
                    break;
                case LEFT:
                    page3();
            }
        });
        stage.setScene(scene);
    }
}
