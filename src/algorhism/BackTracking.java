package algorhism;

import java.util.ArrayList;

public class BackTracking {

    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();

        backTracking.nQueen(4, 0, new ArrayList<Integer>());

    }

    public void nQueen(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {

        if (currentRow == N) {
            System.out.println(currentCandidate);
            return;
        }

        for (int index = 0; index < N; index++) {
            if (isAvailable(currentCandidate, index)) {
                currentCandidate.add(index);
                System.out.println(currentCandidate);
                nQueen(N, currentRow + 1, currentCandidate);
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }

    }

    private boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {

        Integer currentRow = candidate.size();

        for (int index = 0; index < currentRow; index++) {
            if (candidate.get(index) == currentCol || Math.abs(candidate.get(index) - currentCol) == currentRow - index) {
                return false;
            }
        }
        return true;
    }
}
