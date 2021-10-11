class Food : Item {
    val ingredients: Array<String>

    constructor(name:String, cost: Int, ingredients: Array<String>) : super(name, cost) {
        this.ingredients = ingredients
    }

}