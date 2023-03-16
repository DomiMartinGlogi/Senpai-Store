package view;

import model.storage.Place;
import model.storage.Room;
import model.storage.StorageSystem;

import java.io.*;
import java.util.ArrayList;

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

    private void launch(){
        boolean loadResult = load();
        if (!loadResult){
            listPlaces = new ArrayList<>();
            listRooms = new ArrayList<>();
            listStorageSystems = new ArrayList<>();
        }
    }

    private void menu(){
        System.out.println(
                        "SSSSS                                 iii  SSSSS  tt                         \n" +
                        "SS        eee  nn nnn  pp pp     aa aa     SS      tt     oooo  rr rr    eee  \n" +
                        " SSSSS  ee   e nnn  nn ppp  pp  aa aaa iii  SSSSS  tttt  oo  oo rrr  r ee   e \n" +
                        "     SS eeeee  nn   nn pppppp  aa  aaa iii      SS tt    oo  oo rr     eeeee  \n" +
                        " SSSSS   eeeee nn   nn pp       aaa aa iii  SSSSS   tttt  oooo  rr      eeeee \n" +
                        "                       pp                                                     "
        );
        launch();
    }

    public void run(String[] args){
        menu();
    }
}
