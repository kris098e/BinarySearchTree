/** 
 * Gruppe:
 * Philip Jos Rosenlund Andersen, Phand18@student.sdu.dk
 * Kristian Degn Abrahamsen, Krabr21@student.sdu.dk
 * Andreas Viby Jensen, Andje21@student.sdu.dk
 */
import java.util.Scanner;

public class TreeSort {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Dict tree = new DictBinTree();
    
        while(scanner.hasNext()) 
            tree.insert( scanner.nextInt() );

        System.out.println();
        for(int x : tree.orderedTraversal())
            System.out.println(x);
    }
}
