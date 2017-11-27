import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage

class HelloWorld : Application()
{
    @FXML private var mainLayout: VBox?   = null
    @FXML private var closeBtn  : Button? = null

    override fun start(stage: Stage) {
        val root : Parent = FXMLLoader.load(javaClass.getResource("kotGui.fxml"))
        stage.title = "JavaFX GUI demo"
        stage.scene = Scene(root)
        stage.show()
    }

    @FXML private fun onButtonClose(event : ActionEvent)
    {
        val parentStage = closeBtn?.getScene()?.getWindow() as Stage

        val loader = FXMLLoader(javaClass.getResource("confirmDialog.fxml"))
        val root = loader.load<Any>() as Parent
        val scene = Scene(root)
        val stage = Stage()
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(parentStage);

        val controller = loader.getController<Any>() as confirmDialog

        stage.showAndWait()

        if (controller.result)
        {
            parentStage.close()
        }

        event.consume()
    }
}

fun main(args: Array<String>)
{
    launch(HelloWorld::class.java)
}
