class Menu {
    
    var name: String
    val itemList: Array<Item>

    constructor(itemList: Array<Item>){
        this.itemList = itemList
        this.name = name
    }

    fun selectItem(item: Item): Item? {
        if(itemList.contains(item))
            return item
        return null
    }

    fun printMenu():Boolean{
        if(itemList.isNotEmpty()){
            for(i in 0..itemList.size){
                var itemName: String = itemList[i].getName();
                var itemCost: Int = itemList[i].getCost();
                println("$itemName --- {'$'}$itemCost")
                return true
            }
        }
        return false
    }

    fun getItems(): Array<Item>{
        return itemList;
    }
    
    @JvmName("getName1")
    fun getName() : String {
        return name
    }

    fun setName(newName : String) :Boolean{
        this.name= newName;
        return true;
    }

    override fun toString() :String{
        var items :String
        items = "\nMenu: \n"
        if(itemList.size > 0) {
            for (i in 0..itemList.size-1) {
                val itemName = itemList[i].name
                val itemCost = itemList[i].cost

                items = items + ("$itemName: $$itemCost\n")
            }
        }
        return items
    }
}

