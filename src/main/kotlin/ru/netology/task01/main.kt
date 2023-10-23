package ru.netology.task01

fun commissionCalculate(
    cardType: String = "VK Pay", pastTransfers: Double = 0.0, currentTransfer: Double
): Double {

    val dayLimit: Double
    val monthLimit: Double

    when (cardType) {
        "Mastercard", "Maestro", "Visa", "Мир" -> {
            dayLimit = 150_000.0; monthLimit = 600_000.0
        }

        else -> {
            dayLimit = 15_000.0; monthLimit = 40_000.0
        }
    }
    val checkLimits = (pastTransfers + currentTransfer <= monthLimit) && (currentTransfer <= dayLimit)


    return when (cardType) {
        "Mastercard", "Maestro" -> {
            if (checkLimits) {
                if (pastTransfers + currentTransfer <= 75_000.0) 0.0
                else currentTransfer * 0.006 + 20
            } else -1.0
        }

        "Visa", "Мир" -> {
            if (checkLimits) {
                val tax = currentTransfer * 0.0075
                if (currentTransfer >= 35.0) {
                    if (tax < 35.0) 35.0 else tax
                } else -1.0
            } else -1.0
        }

        else -> if (checkLimits) 0.0 else -1.0
    }
}

//fun main() {
//    val cards = arrayOf("Mastercard", "Visa", "VK Pay")
//    for (item in cards) println(
//        "Комиссия для $item составит: ${
//            String.format(
//                "%.2f", commissionCalculate(item, 499_999.0, 75_001.0)
//            )
//        } руб."
//    )
//}