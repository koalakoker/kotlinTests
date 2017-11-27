import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.stage.Stage

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
