package com.example.atl_unec2

import com.example.atl_unec2.uicomponents.quiz_task.Customer

object TestSingleton {

    const val name1: String = "Ahmad"


    /**
     * Kotlinle bagli
     * OOP əsaslarını class lardan əvvəl keçirilməli
     * Genericlər və type casting mövzuları əlavə olunmalıdır.
     *
     *
     * Uİ componentlərlə bağlı
     * Date picker və TimePicker dialoglarla bağlı keçirilə bilər
     * VCS və ya git haqqında ui dərslərinin əvvələrində izah olunmalı və bu mövzunu önə çəkmək lazımdır. Tələbə tasklarını VCS/github üzərindən aparması məncə daha uyğun olar
     * Compose Uİ la bağlı ən azı bir mövzu ola bilər
     * Android Architecture viewModel dərslərindən sonra keçirilsə daha yaxşı olar
     *
     *
     */

    val customerList = arrayListOf(
        Customer(
            id = 1,
            name = "Orkhan",
            address = "Azerbaijan/Baku/Yasamal",
            imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",
            isActive = true
        ),
        Customer(
            id = 2,
            name = "Lisa",
            address = "Poland/Warsaw",
            imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",
            isActive = true
        ),
        Customer(
            id = 3,
            name = "Alex",
            address = "England/London",
            imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",
            isActive = false
        ),
        Customer(
            id = 4,
            name = "Ahmad",
            address = "Azerbaijan/Guba",
            imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",
            isActive = true
        ),
        Customer(
            id = 5,
            name = "Mariana",
            address = "Ukraine/Kiev",
            imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",
            isActive = false
        ),
        Customer(
            id = 6,
            name = "Alex",
            address = "England/London",
            imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",
            isActive = true
        ),
        Customer(
            id = 7,
            name = "Ahmad",
            address = "Azerbaijan/Guba",
            imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",
            isActive = false
        ),
        Customer(
            id = 8,
            name = "Susan",
            address = "USA/New York",
            imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",
            isActive = true
        ),
        Customer(
            id = 9,
            name = "Mustafa",
            address = "Turkey/Ankara",
            imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",
            isActive = false
        ),
    )


}