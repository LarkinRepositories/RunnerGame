package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextArea inputMessageArea;
    @FXML
    private TextFlow emojiList;
    @FXML
    private TextArea messageArea;
    @FXML
    private Button logoutButton;

    @FXML
    void emojiAction(ActionEvent event) {
        if(emojiList.isVisible()){

            emojiList.setVisible(false);
        }else {
            emojiList.setVisible(true);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Node text: emojiList.getChildren()) {
            text.setOnMouseClicked(event -> {
            inputMessageArea.setText(inputMessageArea.getText()+" "+((Text)text).getText());
            //emojiList.setVisible(false);
            });
        }
    }
    @FXML
    void sendMsg(ActionEvent e) {
        messageArea.appendText(inputMessageArea.getText()+"\n");
        inputMessageArea.clear();
        inputMessageArea.requestFocus();
    }
    @FXML
    void logout(ActionEvent e) {
        ((Stage)logoutButton.getScene().getWindow()).close();
    }
}
