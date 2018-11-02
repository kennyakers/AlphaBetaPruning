
public class AlphaBetaPruning {

    private UtilMove maxValue(GameState state, int alpha, int beta) {
        if (state.isGoalState()) {
            return new UtilMove(state.utilityValue(), null);
        }
        Move action = null;
        for (Move move : state.moves()) {
            int minVal = minValue(state.nextState(move), alpha, Integer.MAX_VALUE).getUtility();
            if (minVal > beta) {
                return new UtilMove(minVal, move);
            }
            if (minVal > alpha) {
                action = move;
                alpha = minVal;
            }
        }
        return new UtilMove(alpha, action);
    }

    private UtilMove minValue(GameState state, int alpha, int beta) {
        if (state.isGoalState()) {
            return new UtilMove(state.utilityValue(), null);
        }
        Move action = null;
        for (Move move : state.moves()) {
            int maxVal = maxValue(state.nextState(move), Integer.MIN_VALUE, beta).getUtility();
            if (maxVal < alpha) {
                return new UtilMove(maxVal, move);
            }
            if (maxVal < beta) {
                beta = maxVal;
                action = move;
            }
        }
        return new UtilMove(beta, action);
    }

    private class UtilMove {

        private int utility;
        private Move move;

        public UtilMove(int utilVal, Move move) {
            this.utility = utilVal;
            this.move = move;
        }

        public int getUtility() {
            return utility;
        }

        public Move getMove() {
            return move;
        }
    }

}
