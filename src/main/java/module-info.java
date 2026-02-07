module org.example.singleton_0602_rpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.singleton_0602_rpg to javafx.fxml;
    exports org.example.singleton_0602_rpg;
}