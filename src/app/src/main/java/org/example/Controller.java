package org.example;

import org.example.Package_Produit.Produit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Company;
import org.example.products.Shoes;
import org.example.repositories.CompanyRepositoryImplementation;
import org.example.repositories.ProductRepositoryImplementation;

// public class App {
//     public static void main(String[] args) {
//         Company company = CompanyRepositoryImplementation.getCompanyByName("Clothes shop");

//         Clothes dress = ProductRepositoryImplementation.getClothesByUUID("40e6215d-b5c6-4896-987c-f30f3678f608"); 
//         Clothes shirt = ProductRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1c");
//         Clothes jean = ProductRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1d");

//         Accessories clock = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1e");
//         Accessories parachute = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1f");
//         Accessories sunglasses = ProductRepositoryImplementation.getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1g");

//         Shoes classy = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1h");
//         Shoes work = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1i");
//         Shoes aero = ProductRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1j");
//     }
// }

public class Controller implements Initializable {

    @FXML
    private HBox boite_accessoires;
    private List<Produit> liste_accessoires;

    @FXML
    private HBox boite_habits;
    private List<Produit> liste_habits;

    @FXML
    private HBox boite_chaussures;
    private List<Produit> liste_chaussures;

    @FXML
    private Label foot;

    public static Company company = CompanyRepositoryImplementation.getCompanyByName("Clothes shop");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        liste_habits = new ArrayList<>(init_liste_habits());
        try {
            for (int i = 0; i < init_liste_habits().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Produit.fxml"));
                HBox CardLayout = fxmlLoader.load();
                ProduitController miniccontrollerbut = fxmlLoader.getController();
                miniccontrollerbut.setData(init_liste_habits().get(i));
                boite_habits.getChildren().add(CardLayout);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        liste_accessoires = new ArrayList<>(init_liste_accessoires());
        try {
            for (int i = 0; i < init_liste_accessoires().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Produit.fxml"));
                HBox CardLayout = fxmlLoader.load();
                ProduitController miniccontrollerbut = fxmlLoader.getController();
                miniccontrollerbut.setData(init_liste_accessoires().get(i));
                boite_accessoires.getChildren().add(CardLayout);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        liste_chaussures = new ArrayList<>(init_liste_chaussures());
        try {
            for (int i = 0; i < init_liste_chaussures().size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Produit.fxml"));
                HBox CardLayout = fxmlLoader.load();
                ProduitController miniccontrollerbut = fxmlLoader.getController();
                miniccontrollerbut.setData(init_liste_chaussures().get(i));
                boite_chaussures.getChildren().add(CardLayout);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        foot.setText(company.toString());
    }

    public void updatetxt() {
        foot.setText(company.toString());
    }

    private List<Produit> init_liste_habits() {
        List<Produit> liste_retour = new ArrayList<>();

        Produit produit = new Produit("Winter Dress", "batman.jpg", 10000, 1000000, 700000, 1, 1);
        liste_retour.add(produit);

        produit = new Produit("Professional Shirt", "unicorn.jpg", 0.43, 20, 14, 333, 2);
        liste_retour.add(produit);

        produit = new Produit("Not-Used Jean", "jean.jpg", 8, 80, 66, 58, 3);
        liste_retour.add(produit);
        return liste_retour;
    }

    private List<Produit> init_liste_accessoires() {
        List<Produit> liste_retour = new ArrayList<>();

        Produit produit = new Produit("Cheap Little Clock", "Rolex.png", 155000, 8.77, 23, 6, 4);
        liste_retour.add(produit);

        produit = new Produit("Portable Parachute", "parachute.jpg", 2.55, 34, 25, 74, 5);
        liste_retour.add(produit);

        produit = new Produit("Sunglasses", "sunglasses.jpg", 3500, 3500, 3500, 24, 6);
        liste_retour.add(produit);

        return liste_retour;
    }

    private List<Produit> init_liste_chaussures() {
        List<Produit> liste_retour = new ArrayList<>();

        Produit produit = new Produit("Classy shoe", "ffs.jpg", 67, 87.7, 63, 38, 7);
        liste_retour.add(produit);

        produit = new Produit("Work Shoe", "work.jpg", 2.55, 28, 20, 16, 8);
        liste_retour.add(produit);

        produit = new Produit("Aerodynamic shoe", "aero.jpg", 0.20, 1999, 1500, 529, 9);
        liste_retour.add(produit);

        return liste_retour;
    }
}