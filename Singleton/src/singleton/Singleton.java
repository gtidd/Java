package singleton;

/**
 *
 * @author Greg Tidd
 * 8/24/2015
 * Java 2 
 * Singleton program 1.0
 * 
 */
import java.util.*; //imports java util classes needed 
public class Singleton { //class creation

    public enum TrackEnum { // creates enum instance
        INSTANCE; 
        private Set<String> runningLane;
        private TrackEnum() {
            runningLane = new HashSet<String>();
            runningLane.add("1");
            runningLane.add("2");
            runningLane.add("3");
            runningLane.add("4");
            runningLane.add("5");
            runningLane.add("6");
            runningLane.add("7");
            runningLane.add("8");
        }
        public boolean saveLane(String lane) { //removes lane once it is selected in lane on a single instance
            return runningLane.remove(lane);
        }
       
        }
        private static void saveRunningLane(String lane) { // creates instance and output lane
            TrackEnum runner = TrackEnum.INSTANCE; 
            
            System.out.println(runner.saveLane(lane));
        }
         public static void main(String[] args) {
            Scanner in = new Scanner(System.in);//accepts input and places into saveRunningLane method
            String s;
            int runnerNumber = 0;
            System.out.println("How many runners are there? "); //asks for runners
            runnerNumber = in.nextInt();
            in.nextLine();
            while (runnerNumber > 8){ // restricts the count to 8 since there are only 8 lanes
                System.out.println("Too many please try again...");
                runnerNumber = in.nextInt();
                in.nextLine();
            }
            do {
            System.out.println("Enter a lane from 1 - 8: "); //assigns runner to empty lane will return true
            s = in.nextLine();
            System.out.println("You entered lane "+s);
             saveRunningLane(s); //testing simultanious track log
             runnerNumber--;
            }while(runnerNumber > 0);
    }
}