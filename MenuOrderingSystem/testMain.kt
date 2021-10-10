fun main() {

    var orders = mutableListOf<Order>()
    var testOm = OrderManager(orders)

    var testItems = mutableListOf<Item>()

    var testItem = Item("Pie", 5)

    var testOrder = Order(testItems)
    testOrder.addItem(testItem)

    print(testOrder.toString())
}
