package JavaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuestionsGui {

    boolean answer;

    public boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        Button truebutton = new Button("Yes");
        Button falsebutton = new Button("No");

        truebutton.setOnAction(e->{
            answer = true;
            window.close();
        });
        falsebutton.setOnAction(e->{
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, truebutton, falsebutton);
        layout.setAlignment(Pos.CENTER);

        Scene mainscene = new Scene(layout);

        window.setScene(mainscene);
        window.showAndWait();

        return answer;
    }

}
