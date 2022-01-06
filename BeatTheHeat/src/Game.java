import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.stage.*;

import javax.imageio.IIOException;

/**
 * @author Alyssa Wang and Nayaab Ali
 * @version 1
 * May 30 2019
 * Time spent: 1 hour
 * Game class extends Application
 * Is the main class for the Game
 *
 *  Variable        Type       Purpose
 *  stage           Stage      makes a Stage
 */
public class Game extends Application {
    public static Boolean loaded = false;
    public static int highScore = 0;


    /**
     * Sets stage and displays it
     * @param stage Stage object
     */
    public void start(Stage stage) throws Exception {
        stage.setTitle("Beat the Heat!");
        stage.setResizable(false);

        stage.setHeight(600);
        stage.setWidth(1120);


        stage.show();
        if (!loaded) {
            new LoadingScreen(stage).loadSplashScreen();
        }
    }

    public static void clearRecords(Stage stage) {
            RecordsList.clearRecords();
            new MainMenu(stage).display();
    }

    /**
     * @return the number of improvements
     * @since 1.11
     */
    public static int getImproveNum() {
        return highScore;
    }

    /**
     * @param num the number of improvements
     * @since 1.11
     */
    public static void setImproveNum(int num) {
        highScore += num;
    }
    /**
     * Main method
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
