import java.util.UUID

import scalaz.Reader

/**
  * Created by rajkumar on 7/2/17.
  */
import CoreTypes._
import scalaz._
import Scalaz._
object ReaderMonadTypes {
  type Action[A] = Reader[Session, A]
}

import  ReaderMonadTypes._

trait AccountService {


  def getAccount(accountNumber: String): Action[Option[Account]]

  def getBalance(account: Account): Action[Option[Amount]]

  def withdraw(account: Account, amount: Amount): Action[Amount]

  def getStatement(account: Account): Action[Statement]

}

object Accounts extends AccountService {

  override def getAccount(accountNumber: String): Action[Option[Account]] = Reader { (session: Session) =>
    session.doSomeThing()
    some(Account(accountNumber))
  }

  override def getBalance(account: Account): Action[Option[Amount]] = Reader { (session: Session) =>
    session.doSomeThing()
    some(Amount(10, "Dollar"))
  }

  override def withdraw(account: Account, amount: Amount): Action[Amount] = Reader { (session: Session) =>
    session.doSomeThing()
    Amount(5, "Dollar")
  }

  override def getStatement(account: Account): Action[Statement] = Reader { (session: Session) =>
    session.doSomeThing()
    Statement(account, Amount(5L, "ETH"))
  }
}
