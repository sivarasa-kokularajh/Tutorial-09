class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Deposit amount must be greater than zero.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else {
      println("Withdrawal amount must be greater than zero and less than or equal to balance.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      toAccount.deposit(amount)
      println(s"Transferred $amount to the destination account. New balance: $balance")
    } else {
      println("Transfer amount must be greater than zero and less than or equal to balance.")
    }
  }

  def getBalance: Double = balance
}

object AccountExample {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    account1.deposit(200.0)
    account1.withdraw(100.0)

    account1.transfer(150.0, account2)

    println(s"Account 1 balance: ${account1.getBalance}")
    println(s"Account 2 balance: ${account2.getBalance}")
  }
}
