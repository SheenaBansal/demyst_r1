

object ConsumingRestApiMain {

  def main(args : Array[String]) :Unit ={
    val obj = new ConsumingRestApi()
    obj.fetchApiContent("dev")
  }



}
