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
import javafx.stage.Stage

class SampleController
{
    @FXML private var result : Label? = null
    @FXML private var btnYes : Button? = null
    @FXML private var btnNo  : Button? = null

    fun setStageAndSetupListeners(stage: Stage)
    {
        println(btnYes);
    }

    @FXML private fun onBtnYes()
    {
        println("Yes")
        result?.text = "Yes"
        val stage = btnYes?.getScene()?.getWindow() as Stage
        stage.close()
    }

    @FXML private fun onBtnNo()
    {
        println("No")
        result?.text = "No"
        val stage = btnNo?.getScene()?.getWindow() as Stage
        stage.close()
    }
}

class HelloWorld : Application()
{
    @FXML private var mainLayout: VBox?   = null
    @FXML private var closeBtn  : Button? = null

    override fun start(stage: Stage) {
        val root : Parent = FXMLLoader.load(javaClass.getResource("kotGui.fxml"))
        //btn1.setOnAction { OnPushButton1() }
        //btn2.setOnAction { OnPushButton2() }

        stage.title = "JavaFX GUI demo"
        stage.scene = Scene(root)
        stage.show()

        val loader = FXMLLoader(javaClass.getResource("confirmDialog.fxml"))
        val root2 = loader.load<Any>() as Parent
        val scene2 = Scene(root2)
        val stage2 = Stage()
        stage2.scene = scene2
        stage2.show()

        val controller = loader.getController<Any>() as SampleController
        controller.setStageAndSetupListeners(stage)
    }

    @FXML private fun onButtonClose(event : ActionEvent)
    {
        val stage = closeBtn?.getScene()?.getWindow() as Stage
        val diag = confirmDialog()

        println(diag.doModal(stage))

        event.consume()
        //stage.close()
    }
}

fun main(args: Array<String>)
{
    launch(HelloWorld::class.java)
}
