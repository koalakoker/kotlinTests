import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Modality
import javafx.stage.Stage

class confirmDialog
{
    @FXML private var btnYes : Button? = null
    @FXML private var btnNo  : Button? = null
    var result : Boolean = false

    @FXML private fun onBtnYes()
    {
        result = true
        val stage = btnYes?.getScene()?.getWindow() as Stage
        stage.close()
    }

    @FXML private fun onBtnNo()
    {
        val stage = btnNo?.getScene()?.getWindow() as Stage
        stage.close()
    }
}