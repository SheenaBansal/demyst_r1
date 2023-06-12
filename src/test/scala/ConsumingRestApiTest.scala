
import _root_.requests.Response
import org.scalatest.funsuite.AnyFunSuite
import geny.Bytes


class ConsumingRestApiTest extends AnyFunSuite {


 val ipaddr = Array[Byte](123,34, 105, 112, 34, 58, 34, 49, 49, 55, 46, 57, 57, 46, 49, 54, 52, 46 , 53, 34,125)

 val byteArray = Bytes(ipaddr)

 var res: Response = Response("", 200, "OK", byteArray,Map("application/content-type"->Seq("json")), None)

 test("dev env should return dev url") {
  val res = ApplicationProperties("dev").getUrl().equals("https://api.ipify.org/")
 }
 test("API response should fail with exception") {
  val res = new ConsumingRestApi().fetchApiContent("test")
 }

 test("API response should return correct IP address") {
  val content = new ConsumingRestApi().getContent(res)
  assert(content.getOrElse("ip","not found").equals("117.99.164.5"))  //will need some refactoring
 }



}
