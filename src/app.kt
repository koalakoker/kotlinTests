import javafx.application.Application
import javafx.application.Application.launch
import javafx.geometry.Pos
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox

class HelloWorld : Application()
{
//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            launch(HelloWorld::class.java)
//        }
//    }

    private var btn = Button()
    private var textArea = TextArea("Empty")

    override fun start(stage: Stage) {
        stage.setTitle("Hello World!")

        btn.setText("Say 'Hello World'")
        btn.setOnAction { OnPushButton() }

        val vBox = VBox(textArea, btn)
        vBox.spacing = 15.0
        vBox.alignment = Pos.TOP_CENTER

        stage.setScene(Scene(vBox, 300.0, 250.0))
        stage.show()
    }

    private fun OnPushButton()
    {
        textArea.text = "Hello world!"
    }
}

fun main(args: Array<String>)
{
    val a = 10
    val b = 20
    val c = a + b

    println("Operation: ${a} + ${b} = ${c}")

    val array: Array<Int> = Array<Int>(5, {i -> i*2})

    array[0] = 1

    for ((index, i:Int) in array.withIndex()) {
        println(message = "index: ${index} -> ${i}")
    }
    launch(HelloWorld::class.java)
}
