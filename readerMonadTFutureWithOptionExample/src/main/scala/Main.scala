import CoreTypes.Session
import MultiMonadReaderT._
import scala.concurrent._
import duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scalaz.ReaderT
import scalaz.std.scalaFuture._

/**
  * Created by rajkumar on 7/2/17.
  */
object Main extends App {

  def withdrawUsingMultiMonadReaderT(accountNumber: String): ReaderT[OptionTF, Session, Statement] = for {
    account <- Accounts.getAccount(accountNumber)
    balance <- Accounts.getBalance(account)
    _ <- Accounts.withdraw(account)
    statement <- Accounts.getStatement(account)
  } yield statement

  val res = withdrawUsingMultiMonadReaderT("1234").run(new Session)
  println(s"The result is ${res}")

  println(Await.result(res.run, 5 seconds))

}
