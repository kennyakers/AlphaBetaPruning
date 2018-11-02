
import java.util.ArrayList;


public interface GameTree<State> {
    
    public boolean isGoalState();
    
    public ArrayList<Move> moves(State state);
    
    public State nextState(State currentState, Move move);
    
    public int utilityValue(State state);
    
}
