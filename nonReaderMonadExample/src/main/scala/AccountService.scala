/**
  * Created by rajkumar on 7/2/17.
  */
import CoreTypes._
trait AccountService {

  def getAccount(accountNumber : String, session: Session): Option[Account]

  def getBalance(account: Account, session: Session): Option[Amount]

  def withdraw(account: Account, session: Session): Amount

  def getStatement(account: Account, session: Session): Statement

}

object Accounts extends AccountService {

  override def getAccount(accountNumber: String, session: Session): Option[Account] = ???

  override def getBalance(account: Account, session: Session): Option[Amount] = ???

  override def withdraw(account: Account, session: Session): Amount = ???

  override def getStatement(account: Account, session: Session): Statement = ???

}
