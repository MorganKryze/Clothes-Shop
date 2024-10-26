package org.example.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.example.models.Accessories;
import org.example.models.Clothes;
import org.example.models.Company;
import org.example.models.Shoes;
import org.example.repositories.CompanyRepositoryImplementation;
import org.example.repositories.ProductRepositoryImplementation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Controller implements Initializable {

    @FXML
    private HBox boite_accessoires;
    @SuppressWarnings("unused")
    private List<Accessories> liste_accessoires;

    @FXML
    private HBox boite_habits;
    @SuppressWarnings("unused")
    private List<Clothes> liste_habits;

    @FXML
    private HBox boite_chaussures;
    @SuppressWarnings("unused")
    private List<Shoes> liste_chaussures;

    @FXML
    private Label foot;

    public static CompanyRepositoryImplementation companyRepositoryImplementation = new CompanyRepositoryImplementation();
    public static ProductRepositoryImplementation productRepositoryImplementation = new ProductRepositoryImplementation();
    public static Company company;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        company = companyRepositoryImplementation.getCompanyByName("Clothes shop");

        liste_habits = new ArrayList<>(init_liste_habits());
        // try {
        //     for (int i = 0; i < init_liste_habits().size(); i++) {
        //         FXMLLoader fxmlLoader = new FXMLLoader();
        //         fxmlLoader.setLocation(getClass().getResource("view/Product.fxml"));
        //         HBox CardLayout = fxmlLoader.load();
        //         ProductController miniccontrollerbut = fxmlLoader.getController();
        //         miniccontrollerbut.setData(init_liste_habits().get(i), foot, company);
        //         boite_habits.getChildren().add(CardLayout);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // liste_accessoires = new ArrayList<>(init_liste_accessoires());
        // try {
        //     for (int i = 0; i < init_liste_accessoires().size(); i++) {
        //         FXMLLoader fxmlLoader = new FXMLLoader();
        //         fxmlLoader.setLocation(getClass().getResource("view/Product.fxml"));
        //         HBox CardLayout = fxmlLoader.load();
        //         ProductController miniccontrollerbut = fxmlLoader.getController();
        //         miniccontrollerbut.setData(init_liste_accessoires().get(i), foot, company);
        //         boite_accessoires.getChildren().add(CardLayout);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // liste_chaussures = new ArrayList<>(init_liste_chaussures());
        // try {
        //     for (int i = 0; i < init_liste_chaussures().size(); i++) {
        //         FXMLLoader fxmlLoader = new FXMLLoader();
        //         fxmlLoader.setLocation(getClass().getResource("view/Product.fxml"));
        //         HBox CardLayout = fxmlLoader.load();
        //         ProductController miniccontrollerbut = fxmlLoader.getController();
        //         miniccontrollerbut.setData(init_liste_chaussures().get(i), foot, company);
        //         boite_chaussures.getChildren().add(CardLayout);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // foot.setText(company.toString());
    }

    public void updatetxt() {
        foot.setText(company.toString());
    }

    private List<Clothes> init_liste_habits() {
        List<Clothes> liste_retour = new ArrayList<>();

        Clothes dress = productRepositoryImplementation.getClothesByUUID("40e6215d-b5c6-4896-987c-f30f3678f608");
        Clothes shirt = productRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1c");
        Clothes jean = productRepositoryImplementation.getClothesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1d");

        liste_retour.add(dress);
        liste_retour.add(shirt);
        liste_retour.add(jean);

        return liste_retour;
    }

    private List<Accessories> init_liste_accessoires() {
        List<Accessories> liste_retour = new ArrayList<>();
        Accessories clock = productRepositoryImplementation
                .getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1e");
        Accessories parachute = productRepositoryImplementation
                .getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1f");
        Accessories sunglasses = productRepositoryImplementation
                .getAccessoriesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1g");

        liste_retour.add(clock);
        liste_retour.add(parachute);
        liste_retour.add(sunglasses);

        return liste_retour;
    }

    private List<Shoes> init_liste_chaussures() {
        List<Shoes> liste_retour = new ArrayList<>();
        Shoes classy = productRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1h");
        Shoes work = productRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1i");
        Shoes aero = productRepositoryImplementation.getShoesByUUID("f1b1b1b1-1b1b-1b1b-1b1b-1b1b1b1b1b1j");

        liste_retour.add(classy);
        liste_retour.add(work);
        liste_retour.add(aero);

        return liste_retour;
    }

}