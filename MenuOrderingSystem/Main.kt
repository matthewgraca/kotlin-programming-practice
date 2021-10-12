import java.awt.desktop.SystemEventListener
import java.lang.NumberFormatException

fun main() {

    val restaurant1: Restaurant = createRestaurant()
    enterRestaurant(restaurant1)

}

fun enterRestaurant(restaurant: Restaurant){
    var order = Order(mutableListOf<Item>())
    println("Welcome to ${restaurant.name}")
    while(true){
        println("1. Look at Menus\n" +
                "2. View Order\n" +
                "3. Place Order\n" +
                "4. Previous Orders\n" +
                "5. Stop Dining")
        val selection: Int = numInput() ?: continue
        when(selection){
            1 -> selectMenu(order, restaurant)
            2 -> println("Current Order:\n$order\nTotal: $${order.calculateTotal()}")
            3 -> {
                placeOrder(order, restaurant)
                order = Order(mutableListOf<Item>())
            }
            4 -> {
                println(restaurant.orderManager.orderList)
            }
            5 -> {
                if (!order.isEmpty()) placeOrder(order, restaurant)
                break
            }
            else -> {
                println("Please enter a number between 1-4 ")
            }
        }
    }
}

fun selectMenu(order: Order, restaurant: Restaurant){
    val m_manager = restaurant.menuManager
    while(true){
        printArray(m_manager.menuList as Array<Any>)

        val input: String = input() ?: break
        val menu = m_manager.selectMenu(input) ?: continue

        selectItem(order, menu)
    }
}

fun selectItem(order: Order, menu: Menu){
    while(true){
        menu.printMenu()

        val input: String = input() ?: break
        val item = menu.selectItem(input) ?: continue

        println("${item.getName()} has been added")
        order.addItem(item)
    }
}



fun placeOrder(order: Order, restaurant: Restaurant){
    restaurant.orderManager.addOrder(order)
    println("Order #${order.orderNumber} Placed")
    val receipt: Receipt = order.generateReceipt(100)
    println(receipt)
}


fun input(): String?{
    println("Back")
    val input: String = readLine() as String
    if (input == "Back") return null
    return input
}

fun numInput(): Int?{
    return try{
        readLine()!!.toInt()
    }
    catch(e: NumberFormatException){
        null
    }
}

fun printArray(array: Array<Any>) {
    for(i in array.indices) {
        if(array[i] is Menu)
            println("${i+1}: ${(array[i] as Menu ).getName()}")
        else
            println("${i+1}: ${array[i]}")
    }
}


fun createRestaurant(): Restaurant{
    //Breakfast items
    val pancakes = Item("Pancakes", 4)
    val waffles = Item("Waffles", 4)
    val eggs_ham_bacon = Item("Eggs Ham & Bacon", 4)

    //Lunch Items
    val c_burger = Item("Cheeseburger", 5)
    val sandwich = Item("Sandwich", 5)
    val pizza = Item("Pizza", 5)

    //Dinner Items
    val steak = Item("Steak", 16)
    val enchiladas = Item("Enchiladas", 10)
    val tacos = Item("Tacos", 9)
    val lasagna = Item("Lasagna", 10)

    //Sides/Appetizers
    val mac_cheese = Item("Mac & Cheese", 3)
    val salad = Item("Salad", 3)
    val onion_rings = Item("Onion Rings", 3)
    val fries = Item("Fries", 3)


    //Drinks
    val water: Item = Drink("Water", 0, Size.MEDIUM)
    val dr_pepper: Item = Drink("Dr Pepper", 3, Size.MEDIUM)
    val coca_cola: Item = Drink("Coca Cola", 3, Size.MEDIUM)
    var root_beer: Item = Drink("Root Beer", 3, Size.MEDIUM)
    val sprite: Item = Drink("Sprite", 3, Size.MEDIUM)


    val breakfast_items = arrayOf(pancakes, waffles, eggs_ham_bacon)
    val lunch_items = arrayOf(c_burger, sandwich, pizza)
    val dinner_items = arrayOf(steak, enchiladas, tacos, lasagna)
    val app_items = arrayOf(mac_cheese, salad, onion_rings, fries)
    val drink_items = arrayOf(water, dr_pepper, coca_cola, root_beer, sprite)


    val breakfast = Menu("Breakfast", breakfast_items)
    val lunch = Menu("Lunch", lunch_items)
    val dinner = Menu("Dinner", dinner_items)
    val appetizers = Menu("Appetizers", app_items)
    val drinks = Menu("Drinks", drink_items)


    val orders = mutableListOf<Order>()
    val menus = arrayOf(appetizers, breakfast, lunch, dinner)


    val m_manager = MenuManager(menus)
    m_manager.addMenu(drinks)
    val o_manager = OrderManager(orders)

    return Restaurant("Bob's Not Fancy Restaurant", o_manager, m_manager)

}