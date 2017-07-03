/**
  * Created by rajkumar on 7/2/17.
  */

case class  Account (accountId: String) extends AnyVal
case class  Amount(asLong: Long, notation: String)
case class Statement(account: Account, amount: Amount)


