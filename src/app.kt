import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage

class KotGui
{
    @FXML private var mainLayout: VBox?   = null
    @FXML private var closeBtn  : Button? = null
    @FXML private var textArea : TextArea? = null
    var parentStage : Stage? = null

    @FXML fun onBtnClose(event : ActionEvent) : Boolean
    {
        //val parentStage = closeBtn?.getScene()?.getWindow() as Stage

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
            parentStage?.close()
        }

        event.consume()
        return controller.result
    }

    @FXML fun onBtnCode(event : ActionEvent)
    {
        textArea?.text = javaClass.getResource("kotGui.fxml").readText()
        event.consume()
    }

    @FXML fun onBtnAbout(event : ActionEvent)
    {
        val loader = FXMLLoader(javaClass.getResource("about.fxml"))
        val root = loader.load<Any>() as Parent
        val scene = Scene(root)
        val stage = Stage()
        stage.scene = scene
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(parentStage);
        stage.showAndWait()
        event.consume()
    }
}

class HelloWorld : Application()
{
    override fun start(stage: Stage) {
        val loader = FXMLLoader(javaClass.getResource("kotGui.fxml"))
        val root = loader.load<Any>() as Parent
        val scene = Scene(root)

        stage.scene = scene
        stage.title = "JavaFX GUI demo"

        val controller = loader.getController<Any>() as KotGui
        controller.parentStage = stage

        stage.setOnCloseRequest({e ->
                    if (!controller.onBtnClose(ActionEvent()))
                    {
                        e.consume()
                    }
        })

        stage.show()
    }
}

fun main(args: Array<String>)
{
    launch(HelloWorld::class.java)
}
