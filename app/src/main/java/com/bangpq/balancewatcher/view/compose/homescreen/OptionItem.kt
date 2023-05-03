package com.bangpq.balancewatcher.view.compose.homescreen

import com.bangpq.balancewatcher.R

sealed class OptionItem(
    val action: String,
    val icon: Int,
    val displayName: String
) {
    object Send : OptionItem(
        action = "send",
        icon = R.drawable.ic_send,
        displayName = "Send"
    )

    object CardPayment : OptionItem(
        action = "card_payment",
        icon = R.drawable.ic_payment_card,
        displayName = "Card Payment"
    )

    object Scan : OptionItem(
        action = "scan",
        icon = R.drawable.ic_camera,
        displayName = "Scan"
    )

    object More : OptionItem(
        action = "more",
        icon = R.drawable.ic_more,
        displayName = "More"
    )
}
