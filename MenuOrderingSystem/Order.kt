class Order {
    var items: MutableList<Item>

    constructor(items: MutableList<Item>) {
        this.items = items
    }

    fun addItem(item: Item): Boolean {
        items.add(item)
        return true
    }

    fun removeItem(item: Item): Boolean {
        items.remove(item)
        return true
    }

    fun calculateTotal(): Int {
        var orderTotal = 0
        val iterator = items.listIterator();
        for (item in iterator) {
            orderTotal += item.cost //getCost?
        }
        return orderTotal
    }

    override fun toString(): String {
        var orderOutput: String
        orderOutput = "Order:\n"
        val iterator = items.listIterator();
        for (item in iterator) {
            orderOutput = orderOutput.plus(item.name).plus(": $").plus(item.cost).plus("\n") //getters not used
        }
        return orderOutput
    }
}
