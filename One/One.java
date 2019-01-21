import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class One{
	public static void main(String[] args){
		ArrayList<Integer> numbersArr = new ArrayList<>(Arrays.asList(new Integer[]{8, 7, 2, 5, 3, 1}));
		int sum = 10;

		//sortedArrayMethod(numbersArr, sum);
		hashMapMethod(numbersArr, sum);

	}

	private static void hashMapMethod(ArrayList<Integer> numbersArr, int sum){
		HashMap<Integer, ArrayList<Integer>> numbersMap = new HashMap<>();
		for (int ind = 0; ind < numbersArr.size(); ind ++){
			if (numbersMap.get(numbersArr.get(ind)) == null)
				numbersMap.put(numbersArr.get(ind), new ArrayList<Integer>());
			
			numbersMap.get(numbersArr.get(ind)).add(ind);
		}


		for (int posA = 0; posA < numbersArr.size(); posA++){
			int numA = numbersArr.get(posA);
			Integer other = sum - numA;
			ArrayList<Integer> indexes = numbersMap.get(other);

			if (indexes != null){
				for (int i = 0; i < indexes.size(); i++){
					int posB = indexes.get(i);
					if (posA != posB){
						int numB = numbersArr.get(posB);
						System.out.println(
								String.format("%1$d + %2$d = 10 at index %3$d %4$d respectfully", numA, numB, posA, posB));
					}
				}
			}
		}
	}

	private static void sortedArrayMethod(ArrayList<Integer> numbersArr, int sum){
		Collections.sort(numbersArr);
		ArrayList<ArrayList<Integer>> seenMatches = new ArrayList<>();
		int posA = 0;

		for (Integer numA : numbersArr) {
			for (int posB = (posA + 1); posB < numbersArr.size(); posB++) {
				Integer numB = numbersArr.get(posB);
				if (numA + numB == sum && !seenMatches.contains(Arrays.asList(new Integer[] { numA, numB }))) {
					System.out.println(
							String.format("%1$d + %2$d = 10 at sorted index %3$d %4$d respectfully", numA, numB, posA, posB));
					ArrayList<Integer> seen = new ArrayList<>();
					seen.add(numA);
					seen.add(numB);

					Collections.sort(seen);
					seenMatches.add(seen);
					seen = new ArrayList<>(seen);
					Collections.reverse(seen);
					seenMatches.add(seen);
				}
			}
			++posA;
		}
	}
}