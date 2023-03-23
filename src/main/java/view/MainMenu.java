package view;

import model.items.Alcohol;
import model.items.Book;
import model.items.Item;
import model.items.Perishable;
import model.storage.Place;
import model.storage.Room;
import model.storage.Storage;
import model.storage.StorageSystem;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private ArrayList<Place> listPlaces;
    private ArrayList<Room> listRooms;
    private ArrayList<StorageSystem> listStorageSystems;

    //This is the launch control, this stuff is why I need a therapist
    public static void main(String[] args){
        //This is so dumb, why can't I just run it the way *I* want to, fuck Java seriously.
        try {
            MainMenu m = new MainMenu();
            m.run(args);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }
    public void run(String[] args){
        launch();
        menu();
    }

    /**
     * Loads data
     * @return true if successful, false if not
     */
    public boolean load(){
        try {
            FileInputStream fis = new FileInputStream("storagesystems.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listStorageSystems = (ArrayList<StorageSystem>) ois.readObject();

            //Create the empty lists
            listRooms = new ArrayList<>();
            listPlaces = new ArrayList<>();

            for (StorageSystem s:listStorageSystems){
                Room r = s.getRoom();
                Place p = r.getPlace();

                if (!listRooms.contains(r)) {
                    listRooms.add(r);
                }
                if (!listPlaces.contains(p)) {
                    listPlaces.add(p);
                }
            }

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("A FileNotFoundException occurred during the loading of Files.");
        } catch (IOException e) {
            System.out.println("An IOException occurred during the loading of files.");
        } catch (ClassNotFoundException e) {
            System.out.println("A ClassNotFoundException occurred during the loading of files.");
        }
        return false;
    }

    /**
     * Saves data
     * @return true if successful, false if not
     */
    public boolean save(){
        try {
            FileOutputStream fos = new FileOutputStream("storagesystems.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listStorageSystems);

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("A FileNotFoundException occurred during the writing of files");
        } catch (IOException e) {
            System.out.println("An IOException occurred during the writing of files.");
        }
        return false;
    }

    /**
     * Launches the program
     * Loads the data if unsuccessful initialises empty lists
     * Also prints the welcoming ASCII art
     */
    private void launch(){
        boolean loadResult = load();
        if (!loadResult){
            listPlaces = new ArrayList<>();
            listRooms = new ArrayList<>();
            listStorageSystems = new ArrayList<>();
        }
        System.out.println(
                "SSSSS                                 iii  SSSSS  tt                         \n" +
                        "SS        eee  nn nnn  pp pp     aa aa     SS      tt     oooo  rr rr    eee  \n" +
                        " SSSSS  ee   e nnn  nn ppp  pp  aa aaa iii  SSSSS  tttt  oo  oo rrr  r ee   e \n" +
                        "     SS eeeee  nn   nn pppppp  aa  aaa iii      SS tt    oo  oo rr     eeeee  \n" +
                        " SSSSS   eeeee nn   nn pp       aaa aa iii  SSSSS   tttt  oooo  rr      eeeee \n" +
                        "                       pp                                                     "
        );
    }

    /**
     * This is the menu, really, that is it.
     */
    private void menu(){
        System.out.println(
                "\nPlease input your selection: \n" +
                "\n1 : List all contents" +
                "\n2 : List all Places" +
                "\n3 : List all Rooms per place" +
                "\n4 : Basic Management" +
                "\n5 : Search for Something" +
                "\n6 : Exit"
        );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            // Method call to listAllContents() + screen clear
            case ("1") -> {
                listAllContents();
                scanner.nextLine();
                System.out.println();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            // Method call to listPlaces() + screen clear
            case ("2") -> {
                listPlaces();
                scanner.nextLine();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            // Method call to listRooms() + screen clear
            case ("3") -> {
                listRooms();
                scanner.nextLine();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            // TODO Basic Management tools
            case ("4") -> {
                managementMenu();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            // TODO Search function
            case ("5") -> {
                break;
            }
            // Exits the program
            case ("6") -> {
                save();
                break;
            }
            // Enters the debug menu, option is not given in menu on purpose + screen clear
            case ("debug") -> {
                debugMenu();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            default -> {
                System.out.println("Invalid input, restarting");
                menu();
            }
        }
        save();
    }

    /**
     * This lists all Contents of the StorageSystem
     */
    public void listAllContents(){
        //This will probably end up in r/softwaregore
        System.out.println("Listing all contents:");
        for (Place p:listPlaces){
            System.out.println(p.getName());
            for (Room r:listRooms){
                if (r.getPlace()==p){
                    System.out.println("  |->" + r.getName());
                    for (StorageSystem s:listStorageSystems){
                        if (s.getRoom() == r){
                            System.out.println("  | " + "  |->" + s.getName());
                            for (Storage c:s.getContainers()){
                                System.out.println("  | " + "  | " + "  |->" + c.getName());
                                for (Item i:c.getContents()){
                                    System.out.println("  | " + "  | " + "  | " + "  |->" + i.getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Lists all the places
     */
    public void listPlaces(){
        for (Place p:listPlaces){
            System.out.println(p.getName());
        }
    }

    /**
     * Lists all the Rooms sorted by places
     */
    public void listRooms(){
        for(Place p:listPlaces){
            System.out.println(p.getName() + ":");
            for (Room r:listRooms){
                if (r.getPlace() == p){
                    System.out.println("    " + r.getName());
                }
            }
        }
    }

    /* No one but me should ever call this method so I shall leave it here and it might actually be fine
       Honestly it could be a lot worse
       Like a lot a lot
       Mind you if you have to fix this:

       Abandon all hope ye who enter here */
    private void debugMenu(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println(
                "DDDDD          bb                      MM    MM                        \n" +
                "DD  DD    eee  bb      uu   uu  gggggg MMM  MMM   eee  nn nnn  uu   uu \n" +
                "DD   DD ee   e bbbbbb  uu   uu gg   gg MM MM MM ee   e nnn  nn uu   uu \n" +
                "DD   DD eeeee  bb   bb uu   uu ggggggg MM    MM eeeee  nn   nn uu   uu \n" +
                "DDDDDD   eeeee bbbbbb   uuuu u      gg MM    MM  eeeee nn   nn  uuuu u \n" +
                "                                ggggg                                  "
        );
        System.out.println("\n \n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : Generate Test Data");
        System.out.println("2 : Delete all Data");
        System.out.println("3 : Show all Data");

        String input = scanner.nextLine();
        switch (input) {
            //Testdata
            case("1") -> {
                for (int i = 0; i < 10; i++) {
                    listPlaces.add(new Place("p" + i));
                }
                for (int i = 0; i < 10; i++) {
                    listRooms.add(new Room(listPlaces.get(i), "r" + i));
                }
                for (int i = 0; i < 10; i++) {
                    listStorageSystems.add(new StorageSystem(listRooms.get(i), "s" + i));
                }
                System.out.println("Test Data Generated");
            }
            //Data removal
            case("2") -> {
                listPlaces = new ArrayList<>();
                listRooms = new ArrayList<>();
                listStorageSystems = new ArrayList<>();
            }
            //Read out
            case("3") -> {
                System.out.println("Places: ");
                listPlaces();
                System.out.println("Rooms: ");
                for(Room r:listRooms){
                    System.out.println(r.getName() + " " + r.getPlace().getName());
                }
                System.out.println("StorageSystems and their contents: ");
                for (StorageSystem s:listStorageSystems){
                    System.out.println(s.getName() + " " + s.getRoom().getName() + " " + s.getRoom().getPlace().getName());
                    for (Storage c:s.getContainers()){
                        System.out.println(c.getName());
                        for (Item i:c.getContents()){
                            System.out.println(i.getName() + " " + i.checkOutStatus());
                        }
                    }
                }
                scanner.nextLine();
            }
        }
    }

    /**
     * Represents the Management Menu
     */
    public void managementMenu(){
        //Screen clear
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        //Here be actual code
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "MM    MM                                                                   tt    \n" +
                "MMM  MMM   aa aa nn nnn    aa aa  gggggg   eee  mm mm mmmm    eee  nn nnn  tt    \n" +
                "MM MM MM  aa aaa nnn  nn  aa aaa gg   gg ee   e mmm  mm  mm ee   e nnn  nn tttt  \n" +
                "MM    MM aa  aaa nn   nn aa  aaa ggggggg eeeee  mmm  mm  mm eeeee  nn   nn tt    \n" +
                "MM    MM  aaa aa nn   nn  aaa aa      gg  eeeee mmm  mm  mm  eeeee nn   nn  tttt \n" +
                "                                  ggggg                                          \n");

        System.out.println(
                "1 : Create a Place         \n" +
                "2 : Create a Room          \n" +
                "3 : Create a Storagesystem \n" +
                "4 : Create a Container     \n" +
                "5 : Create an Object       \n");

        String input = scanner.nextLine();
        switch (input) {
            case("1") -> {
                Place place = placeCreator();
                listPlaces.add(place);
            }
            case("2") -> {
                Room room = roomCreator();
                listRooms.add(room);
            }
            case ("3") -> {
                StorageSystem storageSystem = storageSystemCreator();
                listStorageSystems.add(storageSystem);
            }
            case ("4") -> {
                containerCreator();
            }
            case ("5") -> {
                try {
                    objectCreator();
                } catch (Exception e) {
                    System.out.println("Something bad happened, returning to menu");
                    scanner.nextLine();
                }
            }
            default -> {
                System.out.println("Returning to menu");
            }
        }
    }

    private Place placeCreator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the name of the place");
        String name = scanner.nextLine();
        Place place = new Place(name);
        return place;
    }

    private Room roomCreator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the name of the room");
        String name = scanner.nextLine();
        System.out.println("Choose the place for the room");
        for (int i = 0; i < listPlaces.size(); i++) {
            System.out.println(i + " : " + listPlaces.get(i).getName());
        }
        int index = scanner.nextInt();
        Room room = new Room(listPlaces.get(index),name);
        return room;
    }

    private StorageSystem storageSystemCreator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the name of the StorageSystem");
        String name = scanner.nextLine();
        Place place = pickPlace(scanner);
        Room room = pickRoom(scanner, place);
        StorageSystem storageSystem = new StorageSystem(room,name);
        return storageSystem;
    }

    private void containerCreator(){
        Scanner scanner = new Scanner(System.in);
        Place place = pickPlace(scanner);
        Room room = pickRoom(scanner,place);
        StorageSystem st = pickStorageSystem(scanner,room);
        System.out.println("Enter the name for the container:");
        String contName = scanner.nextLine();
        System.out.println("Enter the containers capacity (-1 for infinite)");
        int cap = scanner.nextInt();
        Storage storage = new Storage(contName,cap);
        int index = listStorageSystems.indexOf(st);
        listStorageSystems.get(index).addContainer(storage);
    }

    private void objectCreator() throws ParseException {
        //Defining which objects to call
        Scanner scanner = new Scanner(System.in);
        Place place = pickPlace(scanner);
        Room room = pickRoom(scanner,place);
        StorageSystem storageSystem = pickStorageSystem(scanner,room);
        Storage storage = pickStorage(scanner,storageSystem);

        // Taking in user Input for the Type of object
        System.out.println("Please select the Type of Object:");
        System.out.println(
                "1 : Alcohol    \n" +
                "2 : Book       \n" +
                "3 : Perishable   ");
        int type = scanner.nextInt();

        //Taking in the name of the object, predefining the item
        System.out.println("Please enter the name of the Object:");
        String name = scanner.nextLine();
        Item item = null;

        //Preparing the SimpleDateFormat
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

        //Decision logic to create the right object
        switch (type) {
            // Alcohol:
            case(1) -> {
                System.out.println("Please enter the type:");
                String subType = scanner.nextLine();

                System.out.println("Please enter the Best By Date in form of \"dd-mm-yyyy\":");
                String bestByDate = scanner.nextLine();
                Date bestby = format.parse(bestByDate);

                System.out.println("Please enter the abv, without the '%':");
                float abv = scanner.nextFloat();
                item = new Alcohol(name,bestby,abv,subType);
            }

            // Book:
            case(2) -> {
                System.out.println("Please enter the Author:");
                String author = scanner.nextLine();

                System.out.println("Please enter the Genre:");
                String genre = scanner.nextLine();

                item = new Book(name,author,genre);
            }

            // Generic Perishable:
            case(3) -> {
                System.out.println("Please enter the Best By Date in form of \"dd-mm-yyyy\":");
                String bestByDate = scanner.nextLine();
                Date bestby = format.parse(bestByDate);

                item = new Perishable(name,bestby);
            }
        }

        // Making sure it gets saved properly.
        int storageSystemIndex = listStorageSystems.indexOf(storageSystem);
        int storageIndex = storageSystem.getContainers().indexOf(storage);

        listStorageSystems.get(storageSystemIndex).getContainers().get(storageIndex).addItem(item);
    }

    private Room pickRoom(Scanner scanner, Place place) {
        int index;
        System.out.println("Choose the room for the StorageSystem");
        for (int i = 0; i < listRooms.size(); i++){
            if (listRooms.get(i).getPlace()== place){
                System.out.println(i + " : " + listPlaces.get(i).getName());
            }
        }
        index = scanner.nextInt();
        Room room = listRooms.get(index);
        return room;
    }

    private Place pickPlace(Scanner scanner) {
        System.out.println("Choose the place for the StorageSystem");
        for (int i = 0; i < listPlaces.size(); i++) {
            System.out.println(i + " : " + listPlaces.get(i).getName());
        }
        int index = scanner.nextInt();
        Place place = listPlaces.get(index);
        return place;
    }

    private StorageSystem pickStorageSystem(Scanner scanner, Room room) {
        StorageSystem st;
        System.out.println("Pick a StorageSystem");
        for (StorageSystem s:listStorageSystems) {
            if (s.getRoom() == room) {
                System.out.println(listStorageSystems.indexOf(s) + " : " + s.getName());
            }
        }
        int index = scanner.nextInt();
        st = listStorageSystems.get(index);
        return st;
    }

    private Storage pickStorage(Scanner scanner, StorageSystem storageSystem) {
        Storage storage = null;
        scanner = new Scanner(System.in);
        System.out.println("Select the Container:");
        for (Storage s:storageSystem.getContainers()){
            System.out.println(storageSystem.getContainers().indexOf(s) + " : " + s.getName());
        }
        int index = scanner.nextInt();
        storage = storageSystem.getContainers().get(index);
        return storage;
    }

}
