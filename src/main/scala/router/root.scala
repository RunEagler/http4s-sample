package router

import java.time.{LocalDate, Year}

import cats.effect._

import scala.util.Try

// import cats.effect._

import org.http4s._
import org.http4s.dsl.io._
// import org.http4s._
// import cats.effect._

object LocalDateVar {
  def unapply(str: String): Option[LocalDate] = {
    if (!str.isEmpty)
      Try(LocalDate.parse(str)).toOption
    else
      None
  }
}

object Route{
  implicit val yearQueryParamDecoder: QueryParamDecoder[Year] =
    QueryParamDecoder[Int].map(Year.of)
  // yearQueryParamDecoder: org.http4s.QueryParamDecoder[java.time.Year] = org.http4s.QueryParamDecoder$$anon$8@1baec273

  object YearQueryParamMatcher extends ValidatingQueryParamDecoderMatcher[Year]("year")

  def getAverageTemperatureForYear(y: Year): IO[String] = ???

  def getUserID(userID :Int):String ={
    return s"Get userID=$userID"
  }
  def getTemperatureForecast(date: LocalDate): IO[Double] = IO(42.23)

  val service = HttpService[IO] {

    /*
    case GET -> Root / "temperature" :? YearQueryParamMatcher(yearValidated) =>
      yearValidated.fold(
        parseFailures => BadRequest("unable to parse argument year"),
        year => Ok(year)
      )*/
    case GET -> Root / "weather" / "temperature" / LocalDateVar(localDate) =>
      Ok(getTemperatureForecast(localDate).map(s"The temperature on $localDate will be: " + _))
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
    case GET -> Root/"users"/IntVar(userID) =>{
      Ok(getUserID(userID))
    }
    case _ =>
      IO(Response(Status.Ok))
  }
}


