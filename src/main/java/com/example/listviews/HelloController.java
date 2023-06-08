package com.example.listviews;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController  implements Initializable {

    @FXML
    private TextField txtField;

    @FXML
    private Button btnInsert;

    @FXML
    private ListView<String> listView1;
    private ObservableList<String> ObservabeListViewOne;
    private ObservableList<String> ObservabeListViewTwo;

    @FXML
    private ListView<String> listView2;

    @FXML
    private Button SignleMove;

    @FXML
    private Button MultiMove;

    @FXML
    private Button singleBack;

    @FXML
    private Button multiBack;

    @FXML
    private Label count1;

    @FXML
    private Label count2;
    @FXML
    void InsertValue(ActionEvent event) {
        if(!txtField.getText().isEmpty()){
            listView1.getItems().add(txtField.getText());
            txtField.clear();
            getCountValues();
        }
    }
    @FXML
    void moveItem(ActionEvent event) {
        String selected = listView1.getSelectionModel().getSelectedItem();
        if(selected !=null){
            listView2.getItems().add(selected);
        }
        listView1.getItems().remove(selected);
        getCountValues();
    }
    @FXML
    void moveItems(ActionEvent event) {
        ObservabeListViewOne = listView1.getSelectionModel().getSelectedItems();
        listView2.getItems().addAll(ObservabeListViewOne);
        listView1.getItems().removeAll(ObservabeListViewOne);
        getCountValues();
    }
    @FXML
    void returnItems(ActionEvent event) {
        ObservabeListViewTwo = listView2.getSelectionModel().getSelectedItems();
        listView1.getItems().addAll(ObservabeListViewTwo);
        listView2.getItems().removeAll(ObservabeListViewTwo);
        getCountValues();
    }
    @FXML
    void returnitem(ActionEvent event) {

        String selected = listView2.getSelectionModel().getSelectedItem();
        if(selected != null){
            listView1.getItems().add(selected);
        }
        listView2.getItems().remove(selected);
        getCountValues();
    }
    void getCountValues(){
       count1.setText(String.valueOf(listView1.getItems().size()));
       count2.setText(String.valueOf(listView2.getItems().size()));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        getCountValues();
    }
}
