package org.example;

import org.example.Package_Produit.Produit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProduitController {

    public Produit produit;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private ImageView imageprinci;

    @FXML
    private Label titlelabel;

    public void setData(Produit produit) {
        Image img = new Image(getClass().getResourceAsStream(produit.getImagesource()));
        imageprinci.setImage(img);
        titlelabel.setText(produit.getName());
        DescriptionLabel.setText(produit.getDescription());
        this.produit = produit;
    }

    public void sell() {
        produit.setNbItems(produit.getNbItems() - 1);
        produit.updateDescription();
        Produit.capital += produit.getSell_price();
        Produit.income += produit.getSell_price();
        Produit.updateFooter();
        DescriptionLabel.setText(produit.getDescription());
    }

    public void buy() {
        produit.setNbItems(produit.getNbItems() + 1);
        produit.updateDescription();
        Produit.capital -= produit.getPurchase_price();
        Produit.cost += produit.getPurchase_price();
        Produit.updateFooter();
        DescriptionLabel.setText(produit.getDescription());
    }
}
