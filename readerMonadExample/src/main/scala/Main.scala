import CoreTypes.Session

import scalaz._
import Scalaz._

/**
  * Created by rajkumar on 7/2/17.
  */
object Main extends App {

  def withdrawWithReader(accountNumber: String): Reader[Session, Statement] = {
    for {
      account <- Accounts.getAccount(accountNumber)
      balance <- account.fold(Reader((session: Session) => none[Amount])) ((ac) => Accounts.getBalance(ac))
      _ <- (account, balance) match {
            case (Some(acc), Some(bal)) => Accounts.withdraw(acc, bal)
            case _ => Reader((session: Session) => none[Amount])
          }
      statement <- account match {case Some(acc: Account) => Accounts.getStatement(acc)}
    } yield statement

  }

  val result = withdrawWithReader("1234").run(new Session())

  println(s" the result is $result")
}
