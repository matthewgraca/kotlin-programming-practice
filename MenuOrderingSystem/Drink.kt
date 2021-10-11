class Drink : Item{
    val size: Enum<Size>

    constructor(name: String, cost: Int, size: Enum<Size>): super(name, cost){
        this.size = size
    }
}

enum class Size {
    SMALL, MEDIUM, LARGE
}
