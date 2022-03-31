import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Tester {
    
    public static void test(String path) {
        List< Thread > list = new ArrayList<>();
        ArrayList<Dict> holder = new ArrayList<>();
        
        try {
            Files.walk( Paths.get(path))
                .filter( Files::isRegularFile)
                .map( pat -> new Thread( () -> {
                    synchronized(holder) {
                        holder.add(checker(pat));
                    }
                }))
                .forEach(t -> list.add(t));
        } catch(IOException e) {
            e.printStackTrace();
        }
        list.forEach(t -> t.start());
        try {
            for(Thread t : list)
                t.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        holder.forEach(temp-> System.out.println(temp.orderedTraversal()));
    }
    private static Dict checker(Path path) {
        List<String> list = new ArrayList<>();
        Dict tree = new DictBinTree();
        try {
            list = Files.readAllLines(path);
            list.forEach( s -> tree.insert(Integer.parseInt(s)));
        } catch (IOException e) {
            e.printStackTrace();;
        }
        return tree;
    }
    public static void main(String[] args) {
        test("C:\\Users\\Krell\\Dropbox\\Pc\\Documents\\2. semester\\Dictionary_AlgoDat\\Data");

    }
}