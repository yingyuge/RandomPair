import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // we need to let user type in names to the name list
        Scanner scanner = new Scanner(System.in);

        //all the names would be uniquely stay in the HashSet
        ArrayList<String> nameListOfTheGroup = new ArrayList<>();

        //let user type in name, add the name in the hashset
        System.out.println("the group is made of how many people? : ");
        int numberOfPplInGroup = scanner.nextInt();
        for (int i = 1; i < numberOfPplInGroup + 1; i++) {
            System.out.println("Please type in " + i + ". name of members in the group: ");
            String inputOfNames = scanner.next();
            nameListOfTheGroup.add(inputOfNames);
        }
        // print the list of people in group
        System.out.println("The list: " + nameListOfTheGroup);


        // hashmap to keep the pair
        HashMap<String, String> pairPplFromGroup = new HashMap<>();
        // create an ArrayList to hold same group of people, to know who to be paired
        // pass the ArrayList nameListOfTheGroup into new ArrayList constructor parameter,
        // below the explanation shown on IntelliJ:
        //Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
        //Params:
        //c – the collection whose elements are to be placed into this list
        ArrayList<String> listToBePaired = new ArrayList<String>(nameListOfTheGroup);

        // create a random for index used in for loop when pairing people from listToBePaired to nameListOfPeople
        Random random = new Random();

       /* ERSTER VERSUCH
        for (int i = 0; i < nameListOfTheGroup.size(); i++) {
            // everytime loops, create the random index for listToBePaired, to get random people
            int randomIndex = random.nextInt(0, listToBePaired.size());
            String singleToBePaired = listToBePaired.get(randomIndex);
            // pair only when the names are not the same
            if (!nameListOfTheGroup.get(i).equals(singleToBePaired)) {
                pairPplFromGroup.put(nameListOfTheGroup.get(i), singleToBePaired);
                // after paired need to remove the perso who just got paired from the lists
                listToBePaired.remove(singleToBePaired);
                listToBePaired.remove(nameListOfTheGroup.get(i));
                nameListOfTheGroup.remove(i);
                nameListOfTheGroup.remove(singleToBePaired);
            }
            System.out.println(pairPplFromGroup);
            SCHLUG FEHL
            */

        /* ZWEITER VERSUCH */
        while (pairPplFromGroup.size() < 5) {
            String p1 = nameListOfTheGroup.get(random.nextInt(0, nameListOfTheGroup.size()));
            String p2 = listToBePaired.get(random.nextInt(0, listToBePaired.size()));
            if (!p1.equals(p2)) {
                pairPplFromGroup.put(p1, p2);

                nameListOfTheGroup.remove(p1);
                listToBePaired.remove(p2);
            }
        }
        Set<String> peopleOnKey = pairPplFromGroup.keySet();
        for (String people : peopleOnKey) {
            System.out.println(people + "paired: " + pairPplFromGroup.get(people) );
        }
       /* SCHLUG FEHL :((((((  */

    }
}