
class OrderManager {
    var orderList: MutableList<Order>

    constructor(orderList: MutableList<Order>) {
        this.orderList = orderList
    }

    fun addOrder(order: Order):Boolean {
        orderList.add(order)
        return true
    }
    fun removeOrder(order: Order): Boolean {
        orderList.remove(order)
        return true
    }

}