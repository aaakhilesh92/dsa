package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ArrayBeautifulArrangement3 {

    SortedMap<Integer, List<Integer>> constraints;

    List<List<Integer>> sortedConstraints;

    int NumberOflegitimatePaths;

    List<List<Integer>> legitimatePaths;

    int N;

    public int countArrangement(int N) {

        this.N = N;

        constraints = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

        // 1- Find divisors and multiples of numbers between 1 and N. Put them in a map.

        for (int i = N; i >= 1; i--) {

            List<Integer> divisorsAndMultiples = new ArrayList<Integer>();

            for (int j = 1; j <= N; j++)
                if (j % i == 0 || i % j == 0)
                    divisorsAndMultiples.add(j);

            constraints.put(i, divisorsAndMultiples);

        }

        // Sort multiples and divisors based on the length of the set using insertion sort.

        sortedConstraints = new ArrayList<List<Integer>>();

        for (Integer key : constraints.keySet()) {
            List<Integer> currentConstraints = constraints.get(key);

            if (sortedConstraints.isEmpty())
                sortedConstraints.add(currentConstraints);
            else {
                boolean added = false;

                for (int i = sortedConstraints.size() - 1; i >= 0; i--) {

                    if (currentConstraints.size() >= sortedConstraints.get(i).size()) {
                        if (i < currentConstraints.size() - 1)
                            sortedConstraints.add(i + 1, currentConstraints);
                        else
                            sortedConstraints.add(currentConstraints);

                        added = true;
                        break;
                    }
                }

                if (!added)
                    sortedConstraints.add(0, currentConstraints);
            }
        }

        // 3- Start building all legitimate paths and count them

        legitimatePaths = new ArrayList<List<Integer>>();
        BuildLegitimatePaths(sortedConstraints, new ArrayList<Integer>());

        return NumberOflegitimatePaths;
    }

    void BuildLegitimatePaths(List<List<Integer>> constraintsSet, ArrayList<Integer> builtPath) {

        if (constraintsSet.isEmpty()) {
            if (builtPath.size() == N) {
                legitimatePaths.add(new ArrayList(builtPath));
                NumberOflegitimatePaths++;
            }

        }

        else {

            for (int i = 0; i < constraintsSet.get(0).size(); i++) {
                if (builtPath.isEmpty() || !builtPath.contains(constraintsSet.get(0).get(i))) {
                    builtPath.add(constraintsSet.get(0).get(i));

                    BuildLegitimatePaths(constraintsSet.subList(1, constraintsSet.size()), builtPath);

                    builtPath.remove(builtPath.size() - 1);
                }

            }
        }
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            ArrayBeautifulArrangement3 obj = new ArrayBeautifulArrangement3();
            System.out.println("arrangementCount for value:" + i + " -  " + obj.countArrangement(i));
        }
    }
}