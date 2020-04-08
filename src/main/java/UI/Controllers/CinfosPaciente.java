package UI.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class CinfosPaciente {
    public Button btnEntrar;
    public ListView DrugsList;
    private ObservableList observableList = FXCollections.observableArrayList();


    public void setListView(){

        observableList.setAll("List");
        DrugsList.setItems(observableList);

    }
    public void BtnEntrarClick(){

    }
}
