package org.example;

import org.example.products.Accessories;
import org.example.products.Clothes;
import org.example.products.Company;
import org.example.products.Shoes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductController {

    public Clothes clothes;
    public Accessories accessories;
    public Shoes shoes;

    @FXML
    private Label DescriptionLabel;

    @FXML
    private ImageView imageprinci;

    @FXML
    private Label titlelabel;

    @FXML
    private Label foot;

    private Company company;

    public void setData(Clothes produit, Label foot, Company company) {
        Image img = new Image(getClass().getResourceAsStream(produit.getIconPath()));
        imageprinci.setImage(img);
        titlelabel.setText(produit.getName());
        DescriptionLabel.setText(produit.toString());
        this.clothes = produit;
        this.foot = foot;
        this.company = company;
    }

    public void setData(Accessories produit, Label foot, Company company) {
        Image img = new Image(getClass().getResourceAsStream(produit.getIconPath()));
        imageprinci.setImage(img);
        titlelabel.setText(produit.getName());
        DescriptionLabel.setText(produit.toString());
        this.accessories = produit;
        this.foot = foot;
        this.company = company;
    }

    public void setData(Shoes produit, Label foot, Company company) {
        Image img = new Image(getClass().getResourceAsStream(produit.getIconPath()));
        imageprinci.setImage(img);
        titlelabel.setText(produit.getName());
        DescriptionLabel.setText(produit.toString());
        this.shoes = produit;
        this.foot = foot;
        this.company = company;
    }

    public void sell() {
        if (clothes != null) {
            clothes.sell(1);
            DescriptionLabel.setText(clothes.toString());
            foot.setText(company.toString());
        } else if (accessories != null) {
            accessories.sell(1);
            DescriptionLabel.setText(accessories.toString());
            foot.setText(company.toString());
        } else if (shoes != null) {
            shoes.sell(1);
            DescriptionLabel.setText(shoes.toString());
        }
    }

    public void buy() {
        if (clothes != null) {
            clothes.purchase(1);
            DescriptionLabel.setText(clothes.toString());
            foot.setText(company.toString());
        } else if (accessories != null) {
            accessories.purchase(1);
            DescriptionLabel.setText(accessories.toString());
            foot.setText(company.toString());
        } else if (shoes != null) {
            shoes.purchase(1);
            DescriptionLabel.setText(shoes.toString());
            foot.setText(company.toString());
        }
    }
}
