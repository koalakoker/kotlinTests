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
          private var window    : Stage?  = null
          private var scene     : Scene?  = null

    override fun start(stage: Stage) {
        val root : Parent = FXMLLoader.load(javaClass.getResource("kotGui.fxml"))
        //btn1.setOnAction { OnPushButton1() }
        //btn2.setOnAction { OnPushButton2() }

        scene = Scene(root)
        println("${scene}")
        stage.title = "JavaFX GUI demo"
        stage.scene = scene
        stage.show()
    }

    private fun myOnShown()
    {
        println ("${mainLayout}")
    }

    @FXML private fun onButtonClose(event : ActionEvent)
    {
        event.consume()
        println("${scene}")
        val window = mainLayout!!.getScene().getWindow() as Stage
        println("Window: ${window}")
        val stage = closeBtn!!.getScene().getWindow() as Stage
        //stage.close()
        println("Window: ${window}")
        println("FXML: ${stage}")
    }
}

fun main(args: Array<String>)
{
    launch(HelloWorld::class.java)
}
