import CoreTypes.Session
import MultiMonadReaderT._
import scala.concurrent.Future
import scalaz.{OptionT, ReaderT}

/**
  * Created by rajkumar on 7/2/17.
  */

object MultiMonadReaderT {
  type OptionTF[A] = OptionT[Future, A]
  type Action[A] = ReaderT[OptionTF, Session, A]
}

trait AccountService {

  def getAccount(accountNumber: String): Action[Account]

  def getBalance(account: Account): Action[Amount]

  def withdraw(account: Account): Action[Amount]

  def getStatement(account: Account): Action[Statement]

}

object Accounts extends  AccountService {

  override def getAccount(accountNumber: String): Action[Account] = ReaderT { (session: Session) =>
    session.doSomeThing()
    val res = Future.successful(Option(Account(accountNumber)))
    val asOptionTF:OptionTF[Account] = OptionT(res)
    asOptionTF
  }

  override def getBalance(account: Account): Action[Amount] = ReaderT { (session: Session) =>
    session.doSomeThing()
    val res = Future.successful(Option(Amount(10, "ETH")))
    val asOptionTF: OptionTF[Amount] = OptionT(res)
    asOptionTF
  }

  override def withdraw(account: Account): Action[Amount] = ReaderT { (session: Session) =>
    session.doSomeThing()
    val res = Future.successful(Option(Amount(5, "ETH")))
    val asOptionTF: OptionTF[Amount] = OptionT(res)
    asOptionTF
  }

  override def getStatement(account: Account): Action[Statement] = ReaderT { (session: Session) =>
    session.doSomeThing()
    val res = Future.successful(Option(Statement(account, Amount(5, "ETH"))))
    val asOptionTF: OptionTF[Statement] = OptionT(res)
    asOptionTF
  }
}
