import javafx.application.Application
import javafx.application.Application.launch
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.input.DataFormat.URL
import javafx.stage.Stage

class HelloWorld : Application()
{
    private var btn1 = Button()
    private var btn2 = Button()
    private var textArea = TextArea("Empty")

    override fun start(stage: Stage) {
        val root : Parent = FXMLLoader.load(javaClass.getResource("kotGui.fxml"))
        //btn1.setOnAction { OnPushButton1() }
        //btn2.setOnAction { OnPushButton2() }

        stage.setTitle("JavaFX GUI demo")
        stage.setScene(Scene(root))
        stage.show()
    }

    private fun OnPushButton1()
    {
        textArea.text = "Hello world!"
    }

    private fun OnPushButton2()
    {
        textArea.text = "Push button 2"
    }
}

fun main(args: Array<String>)
{
    launch(HelloWorld::class.java)
}
