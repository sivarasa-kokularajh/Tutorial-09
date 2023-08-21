class Account(val accountNumber: String, var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  override def toString: String = s"Account $accountNumber - Balance: $balance"
}

object Bank {
  def accountsWithNegativeBalance(accounts: List[Account]): List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def sumOfAllBalances(accounts: List[Account]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(accounts: List[Account]): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } else {
        account.withdraw(account.balance * 0.1)
      }
    }
  }
}

object BankExample {
  def main(args: Array[String]): Unit = {
    val account1 = new Account("A001", 1000.0)
    val account2 = new Account("A002", -500.0)
    val account3 = new Account("A003", 200.0)

    val accounts = List(account1, account2, account3)

    println("Accounts with negative balance:")
    Bank.accountsWithNegativeBalance(accounts).foreach(println)

    val totalBalance = Bank.sumOfAllBalances(accounts)
    println(s"Total balance of all accounts: $totalBalance")

    Bank.applyInterest(accounts)
    println("Final balances after applying interest:")
    accounts.foreach(println)
  }
}
