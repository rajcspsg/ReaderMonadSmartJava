/**
  * Created by rajkumar on 7/2/17.
  */

object CoreTypes {

  case class Session() {
    def doSomeThing(): Unit = {
      println(s"printing something useless")
    }
  }

  object Session {


  }
}
