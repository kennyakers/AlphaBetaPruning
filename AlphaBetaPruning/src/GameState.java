
import java.util.ArrayList;

public interface GameState {

    public boolean isGoalState();

    public ArrayList<Move> moves();

    public GameState nextState(Move move);

    public int utilityValue();

}
