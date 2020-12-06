package corejava;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {

		IntStream intStream = IntStream.of(1,2,3,4,5,6,7,8);
		
		List<Integer> iList = intStream.boxed().collect(Collectors.toList());
		
		/*iList.stream().sort(predicate-> {
		
		});*/

		Stream Stream1 = Stream.of("A","b");

		
		
		
	}

}
