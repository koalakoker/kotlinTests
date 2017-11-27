import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.stage.Modality
import javafx.stage.Stage

class confirmDialog(retValInit: Int = 0)
{
    @FXML private var btnYes : Button? = null
    @FXML private var btnNo  : Button? = null
    @FXML private var result : Label ? = null

    fun doModal(parentStage : Stage) : String?
    {
        val stage = Stage()

        val loader = FXMLLoader(javaClass.getResource("confirmDialog.fxml"))
        val root = loader.load<Any>() as Parent
        val controller = loader.getController<Any>() as confirmDialog
        //controller.setStageAndSetupListeners(stage) // or what you want to do

        //val root : Parent = FXMLLoader.load(javaClass.getResource("confirmDialog.fxml"))
        stage.initOwner(parentStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.title = "Closing app"
        stage.scene = Scene(root)
        stage.showAndWait()
        println(result?.text)
        return result?.text
    }

    @FXML private fun onBtnYes()
    {
        println("Yes")
        result?.text = "Yes"
        val stage = btnYes?.getScene()?.getWindow() as Stage
        //stage.close()
    }

    @FXML private fun onBtnNo()
    {
        println("No")
        result?.text = "No"
        val stage = btnNo?.getScene()?.getWindow() as Stage
        //stage.close()
    }

}