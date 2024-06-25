module eus.ehu.concertappfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eus.ehu.concertappfx to javafx.fxml;
    exports eus.ehu.concertappfx;
}