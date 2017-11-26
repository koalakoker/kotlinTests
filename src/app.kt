import javafx.application.Application
import javafx.application.Application.launch
import javafx.geometry.Pos
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextArea
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class HelloWorld : Application()
{
//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            launch(HelloWorld::class.java)
//        }
//    }

    private var btn1 = Button()
    private var btn2 = Button()
    private var textArea = TextArea("Empty")

    override fun start(stage: Stage) {
        stage.setTitle("Hello World!")

        btn1.setText("Button1")
        btn1.setOnAction { OnPushButton1() }

        btn2.setText("Button2")
        btn2.setOnAction { OnPushButton2() }

        val hBox = HBox(btn1, btn2)
        hBox.spacing = 15.0

        val vBox = VBox(textArea, hBox)
        vBox.spacing = 15.0
        vBox.alignment = Pos.TOP_CENTER

        stage.setScene(Scene(vBox, 300.0, 250.0))
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
