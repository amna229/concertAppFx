module eus.ehu.concertappfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    //requires org.apache.logging.log4j;


    //opens eus.ehu.concertappfx to javafx.fxml;
    opens eus.ehu.concertappfx.domain to javafx.base, javafx.fxml, org.hibernate.orm.core;
    exports eus.ehu.concertappfx.domain;
    opens eus.ehu.concertappfx.ui to javafx.fxml;
    opens eus.ehu.concertappfx.uiControllers to javafx.fxml;
    exports eus.ehu.concertappfx.ui;
    exports eus.ehu.concertappfx.uiControllers;

}
