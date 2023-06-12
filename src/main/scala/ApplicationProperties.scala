case class ApplicationProperties (env : String){

  def getUrl(): String ={
    env match  {
      case "dev" => "https://api.ipify.org/"
      case "test" => ""
    }
  }

}
