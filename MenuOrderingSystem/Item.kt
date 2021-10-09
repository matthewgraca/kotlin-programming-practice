import kotlin.Enum as KotlinEnum

class Item {
    var name: String
    var cost: Int
    //val category: kotlin.Enum             --> Issue with Enum, not very sure how to implement this one as desired

    constructor(name: String, cost: Int, /*category: Any*/){
        this.name = name;
        this.cost = cost;
        //this.category = category
    }

    @JvmName("getCost1")
    fun getCost(): Int {
        return cost
    }

    @JvmName("getName1")
    fun getName(): String{
        return name
    }

    override fun toString(): String{
        return "$name: $$cost"
    }

    private fun setCost(nCost:Int): Boolean {
        cost = nCost
        return true;
    }

    private fun setName(nName: String): Boolean {
        name = nName;
        return true
    }

}