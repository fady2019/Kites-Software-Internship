module com.clinic.clinicapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.clinic.clinicapp to javafx.fxml;
    exports com.clinic.clinicapp;
}