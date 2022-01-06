/**
 * Represents a player record.
 *
 * @author Nayaab Ali
 * @version 1.11
 * <p>
 * 1.11 - Julia Xie
 * <br>DateL 2019/06/07
 * <br>Time Spent: 30 minutes
 * <br>Added constructor.
 * <br>Added getName() method.
 * <br>Added getPercent() method.
 * <br>Added toString() method.
 * </p>
 * @since 1.11
 */
public class Record {
    private String name;
    private int score;

    /**
     * Constructor which creates a record using the specified parameters.
     *
     * @param name    the player's name
     * @since 1.11
     */
    public Record(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * @return the player's name
     * @since 1.11
     */
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /**
     * @return a string with the name and percent of the player
     * @since 1.11
     */
    public String toString() {
        return name + score;
    }
}