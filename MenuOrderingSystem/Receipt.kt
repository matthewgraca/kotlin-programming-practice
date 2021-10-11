enum class PayMethod {
    CASH,
    DEBIT,
    CREDIT
}

class Receipt {
    var total = 0
    var payMethod: PayMethod
    var order: Order

    constructor(payMethod: PayMethod, order: Order) {
        this.payMethod = payMethod
        this.order = order
    }

    override fun toString(): String {
        var orderOutput = "Receipt:\nPayment Method: " + payMethod.name + "\n" + order.toString() + "\n Total: $" + order.calculateTotal()

        return orderOutput
    }
}
