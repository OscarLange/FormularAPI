package JavaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGui extends Application {

    Stage window;
    Button acceptbutton;
    Button nextbutton;
    Scene mainscene, alertscene;


    public void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        QuestionsGui qdisplay = new QuestionsGui();

        window = stage;

        //first scene
        Label welcomelabel = new Label("Welcome to FormularAPI 1.0");

        acceptbutton = new Button();
        acceptbutton.setText("Starten");
        acceptbutton.setOnAction(e -> window.setScene(alertscene));

        VBox layout = new VBox(20);
        layout.getChildren().addAll(welcomelabel, acceptbutton);
        layout.setAlignment(Pos.CENTER);

        mainscene = new Scene(layout, 300, 250);

        //second scene
        Label warning = new Label("WARNUNG");
        nextbutton = new Button("Weiter");
        nextbutton.setOnAction(e ->{
            boolean result = qdisplay.display("Fragebogen", "Beantworten Sie bitte folgende Fragen!");
            System.out.println(result);
        });

        //Layout
        VBox alertlayout = new VBox(20);
        alertlayout.getChildren().addAll(warning, nextbutton);
        alertlayout.setAlignment(Pos.CENTER);

        alertscene = new Scene(alertlayout, 400, 200);

        window.setTitle("QuestionFormular");
        window.setScene(mainscene);
        window.show();
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
                }
        );
    }

    private void closeProgram(){
        System.out.println("Window closed");
        window.close();
    }

}
