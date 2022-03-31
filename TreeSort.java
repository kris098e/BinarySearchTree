import java.util.Scanner;

public class TreeSort {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Dict tree = new DictBinTree();
    
        while(scanner.hasNext()) 
            tree.insert( scanner.nextInt() );

        System.out.println(tree.orderedTraversal());
    }
}
