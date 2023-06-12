
import _root_.requests.{Response, connectTimeout, readTimeout}

class ConsumingRestApi {

  def getContent(content : Response) = {
    content.text.substring(1, content.text.length - 1)
      .split(",")
      .map(_.split(":"))
      .map { case Array(k, v) => (k.substring(1, k.length-1), v.substring(1, v.length-1))}
      .toMap

  }


  def fetchApiContent(env : String): Unit = {
    val applicationProperties = ApplicationProperties(env)
    val url = applicationProperties.getUrl()
    try {
      val content : Response = requests.get(url, params = Map("format" -> "json") ,readTimeout = 1000000 , connectTimeout = 1000000)
      val result = getContent(content).getOrElse("ip","not found")
      println(result)

    } catch {
      case exc : Exception => println(s"Application failed with ${exc.getMessage}")
    }
  }
}




