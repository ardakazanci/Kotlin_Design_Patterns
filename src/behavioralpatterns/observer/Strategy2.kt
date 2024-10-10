interface PaymentStrategy {
    fun pay(amount: Double)
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("$amount USD paid with Credit Card. Card Holder: $cardHolderName, Card Number: $cardNumber")
    }
}

class GooglePayPayment(val googleAccount: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("$amount USD paid with Google Pay. Account: $googleAccount")
    }
}

class BankTransferPayment(val iban: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("$amount USD paid via Bank Transfer. IBAN: $iban")
    }
}

class PaymentContext(private var paymentStrategy: PaymentStrategy) {
    fun setPaymentStrategy(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy
    }

    fun processPayment(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

fun main() {
    val paymentContext = PaymentContext(CreditCardPayment("1234-5678-9012-3456", "John Doe"))

    // Pay with Credit Card
    paymentContext.processPayment(150.0)

    // Switch to Google Pay
    paymentContext.setPaymentStrategy(GooglePayPayment("john.doe@gmail.com"))
    paymentContext.processPayment(200.0)

    // Switch to Bank Transfer
    paymentContext.setPaymentStrategy(BankTransferPayment("US00 0000 0000 0000 1234 5678"))
    paymentContext.processPayment(300.0)
}