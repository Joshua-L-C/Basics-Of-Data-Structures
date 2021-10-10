import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class birthday {

public static int birthdayTest(List<Integer> s, int addedTo, int numberOfSegments) {
        
        int holder = 0;
        int total = 0;
        
        if(s.size() == 1){
            if(s.get(0) == addedTo){
                total++;
            }
        }
        
        
        for(int runner = 0; runner <= s.size() - numberOfSegments; runner++){
            for(int runnerTwo = runner; runnerTwo < (runner + numberOfSegments);runnerTwo++){
                holder += s.get(runnerTwo);
            }
            
            if(holder == addedTo){
                total++;
            }
            
            holder = 0;
            
        }
        
        return total;
    }




    public static void main(String[] args) throws IOException {
 
    }
    

}
