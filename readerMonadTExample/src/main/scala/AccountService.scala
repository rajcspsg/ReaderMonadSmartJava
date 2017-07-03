import CoreTypes.Session
import ReaderTTypes.Action

import scalaz._
import Scalaz._

/**
  * Created by rajkumar on 7/2/17.
  */


object ReaderTTypes {
  type Action[A] = ReaderT[Option, Session, A]
}

trait AccountService {
  import ReaderTTypes._

  def getAccount(accountNumber: String): Action[Account]

  def getBalance(account: Account): Action[Amount]

  def withdraw(account: Account): Action[Amount]

  def getStatment(account: Account): Action[Statement]
}

object Accounts extends AccountService {

  override def getAccount(accountNumber: String): Action[Account] = ReaderT { (session: Session) =>
    session.doSomeThing()
    some(Account(accountNumber))
  }

  override def getBalance(account: Account): Action[Amount] = ReaderT { (session: Session) =>
    session.doSomeThing()
    some(Amount(10, "ETH"))
  }

  override def withdraw(account: Account): Action[Amount] = ReaderT { (session: Session) =>
    session.doSomeThing()
    some(Amount(5, "ETH"))
  }

  override def getStatment(account: Account): Action[Statement] = ReaderT { (session: Session) =>
    session.doSomeThing()
    some(Statement(account, Amount(5, "ETH")))
  }

}


