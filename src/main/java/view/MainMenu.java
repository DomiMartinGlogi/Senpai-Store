package view;

import model.items.Item;
import model.storage.Place;
import model.storage.Room;
import model.storage.Storage;
import model.storage.StorageSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private ArrayList<Place> listPlaces;
    private ArrayList<Room> listRooms;
    private ArrayList<StorageSystem> listStorageSystems;

    public static void main(String[] args){
        //This is so dumb, why can't I just run it the way *I* want to, fuck Java seriously.
        try {
            MainMenu m = new MainMenu();
            m.run(args);
        } catch (Exception e){
            System.out.println("Could not Launch Program.");
        }
    }

    public boolean load(){
        try {
            FileInputStream fis = new FileInputStream("places.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listPlaces = (ArrayList<Place>) ois.readObject();

            fis = new FileInputStream("rooms.txt");
            ois = new ObjectInputStream(fis);
            listRooms = (ArrayList<Room>) ois.readObject();

            fis = new FileInputStream("storagesystems.txt");
            ois = new ObjectInputStream(fis);
            listStorageSystems = (ArrayList<StorageSystem>) ois.readObject();

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

    public boolean save(){
        try {
            FileOutputStream fos = new FileOutputStream("places.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listPlaces);

            fos = new FileOutputStream("rooms.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listRooms);

            fos = new FileOutputStream("storagesystems.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listStorageSystems);

            return true;
        } catch (FileNotFoundException e) {
            System.out.println("A FileNotFoundException occurred during the writing of files");
        } catch (IOException e) {
            System.out.println("An IOException occurred during the writing of files.");
        }
        return false;
    }

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
            case ("1") -> {
                listAllContents();
                scanner.nextLine();
                System.out.println();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            case ("2") -> {
                listPlaces();
                scanner.nextLine();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            case ("3") -> {
                listRooms();
                scanner.nextLine();
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
                menu();
            }
            case ("4") -> {
                break;
            }
            case ("5") -> {
                break;
            }
            case ("6") -> {
                break;
            }
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

    public void run(String[] args){
        launch();
        menu();
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

    public void listPlaces(){
        for (Place p:listPlaces){
            System.out.println(p.getName());
        }
    }

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
            case("2") -> {
                listPlaces = new ArrayList<>();
                listRooms = new ArrayList<>();
                listStorageSystems = new ArrayList<>();
            }
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
}
