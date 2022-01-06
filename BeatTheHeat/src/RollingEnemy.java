
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RollingEnemy extends Enemy {
	//Field members for Transitions
	protected ParallelTransition pT;
	protected TranslateTransition tTOne;
	boolean good;
	String name;
	boolean finish = false;
	
	//Static ArrayList to which all instances of RollingEnemy will add themselves
	protected static ArrayList rollingEnemies = new ArrayList<RollingEnemy>();

	/**
	 * Constructor.
	 * 
	 * @param componentsGroup (required) group to which RollingEnemy will be added
	 * @param xCoord (required) defines x coordinate of RollingEnemy
	 * @param yCoord (required) defines y coordinate of RollingEnemy
	 * @param speed (required) defines speed at which RollingEnemy will move
	 */
	public RollingEnemy(Group componentsGroup, double xCoord, double yCoord, String name, double stopYCoord,
			Duration speed, boolean good) {
		
		//Call super class' constructor
		super(componentsGroup, xCoord, yCoord, name);
		this.good = good;
		this.name=name;
		
		//Add RollingEnemy to ArrayList and remove from Enemy ArrayList
		rollingEnemies.add(0, this);
		super.enemiesArray.remove(this);

		//Create TranslateTransition for pointySquareOne
		tTOne = new TranslateTransition(speed, enemyField);
		tTOne.setFromY(yCoord);
		tTOne.setToY(stopYCoord);
		tTOne.setCycleCount(1);
		tTOne.setAutoReverse(false);
		
		//Create ParallelTransition, add previously created/set up Transitions 
		//to it, and call play()
		pT = new ParallelTransition();
		pT.getChildren().addAll(tTOne);
		pT.setAutoReverse(true);
		pT.play();
		//After fade in, start fade out
		pT.setOnFinished((e) -> {
			finish = true;
		});
	}
	
	/**
	 * Get an ArrayList containing all instances of RollingEnemy.
	 * @return return an ArrayList containing all instances of RollingEnemy
	 */
	public static ArrayList<RollingEnemy> getRollingEnemiesArrayList() {
		return rollingEnemies;
	}

	public void done()
	{
		tTOne = new TranslateTransition(Duration.millis(500), enemyField);
		tTOne.setToY(600);
		tTOne.setCycleCount(1);
		tTOne.setAutoReverse(false);

		//Create ParallelTransition, add previously created/set up Transitions
		//to it, and call play()
		pT = new ParallelTransition();
		pT.getChildren().addAll(tTOne);
		pT.setAutoReverse(true);
		pT.play();
	}

	public boolean isGood()
	{
		return good;
	}
	public boolean isFinish()
	{
		return finish;
	}
	public String getName() {return name;}

	public void stop()
	{
		pT.stop();
	}

	public void stopAll()
	{
		for (RollingEnemy e : getRollingEnemiesArrayList()) {
			e.stop();
		}
	}

	/**
	 * Must be called before creating new Stage!
	 */
	public static void reset() {
		rollingEnemies.clear();
	}
}
