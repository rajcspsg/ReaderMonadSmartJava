import CoreTypes.Session
import scalaz._
import Scalaz._

/**
  * Created by rajkumar on 7/2/17.
  */
object Main extends App {

  def withdrawWithReaderT(accountNumber: String):  ReaderT[Option, Session, Statement] = for {
    account <- Accounts.getAccount(accountNumber)
    balance <- Accounts.getBalance(account)
    _ <- Accounts.withdraw(account)
    statement <- Accounts.getStatment(account)
  } yield statement

  val result = withdrawWithReaderT("1234").run

  println(s"the result as kleisli is $result")
  println(s"the result is ${result(new Session()) }")
}
