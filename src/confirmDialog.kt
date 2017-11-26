import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Modality
import javafx.stage.Stage

class confirmDialog(retValInit: Int = 0)
{
    var retVal = retValInit

    var C_ID = "ID"

    @FXML private var btnYes : Button? = null
    @FXML private var btnNo  : Button? = null

    fun doModal(parentStage : Stage)
    {
        val root : Parent = FXMLLoader.load(javaClass.getResource("confirmDialog.fxml"))
        val stage = Stage()
        stage.initOwner(parentStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.title = "Closing app"
        stage.scene = Scene(root)
        stage.showAndWait()
        println("$retVal")
    }

    @FXML private fun onBtnYes()
    {
        println("Yes")
        execOnBtnYes()
        val stage = btnYes?.getScene()?.getWindow() as Stage
        //stage.close()
    }

    private fun execOnBtnYes()
    {
        println("$retVal")
        retVal = 1
        println("$retVal")
        C_ID = "Yes"
    }

    @FXML private fun onBtnNo()
    {
        println("No")
        execOnBtnNo()
        val stage = btnNo?.getScene()?.getWindow() as Stage
        //stage.close()
        C_ID = "No"
    }

    private fun execOnBtnNo()
    {
        println("$retVal")
        retVal = 2
        println("$retVal")
    }
}