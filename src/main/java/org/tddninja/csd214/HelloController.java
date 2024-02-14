package org.tddninja.csd214;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.hibernate.Session;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        Session session = DBConnUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User newUser = new User("John", "john@email.com");
        session.persist(newUser);
        session.getTransaction().commit();
        session.close();
    }
}