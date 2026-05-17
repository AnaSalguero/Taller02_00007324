package com.pdm0126.foodspot.Dummy

import com.pdm0126.foodspot.Model.Restaurant
import com.pdm0126.foodspot.Model.Dish

val sampleRestaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Place",
        description = "Las mejores pizzas artesanales de la ciudad",
        imageUrl = "https://images.unsplash.com/photo-1611915365928-565c527a0590?q=80&w=1025",
        categories = listOf("Italiana", "Pizzas","Fast Food"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Margarita",
                description = "Mozzarella, albahaca y tomate fresco",
                price = 12.50,
                imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=781"
            ),
            Dish(
                id = 2,
                name = "Pizza Pepperoni",
                description = "Pepperoni con queso mozzarella derretido",
                price = 14.00,
                imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1170"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger Town",
        description = "Hamburguesas gourmet y papas crujientes",
        imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?q=80&w=699",
        categories = listOf("Hamburguesas", "Fast Food"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Hamburguesa Clásica",
                description = "Carne de res, queso cheddar y vegetales",
                price = 9.99,
                imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Hamburguesa BBQ",
                description = "Hamburguesa con salsa BBQ y cebolla caramelizada",
                price = 11.50,
                imageUrl = "https://images.unsplash.com/photo-1571091718767-18b5b1457add?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Papas Supremas",
                description = "Papas con queso y tocino",
                price = 5.75,
                imageUrl = "https://images.unsplash.com/photo-1630384060421-cb20d0e0649d?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "Sushi House",
        description = "Auténtica comida japonesa",
        imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?q=80&w=687",
        categories = listOf("Japonesa", "Sushi"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Sushi Roll",
                description = "Rollo de salmón y aguacate",
                price = 13.00,
                imageUrl = "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Ramen Especial",
                description = "Caldo japonés con cerdo y huevo",
                price = 12.25,
                imageUrl = "https://images.unsplash.com/photo-1617093727343-374698b1b08d?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Pollo Teriyaki",
                description = "Pollo glaseado con salsa teriyaki y arroz",
                price = 15.50,
                imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 4,
        name = "Taco Fiesta",
        description = "Los mejores tacos mexicanos",
        imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85?q=80&w=687",
        categories = listOf("Mexicana"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Tacos al Pastor",
                description = "Tacos tradicionales con piña",
                price = 8.50,
                imageUrl = "https://images.unsplash.com/photo-1613514785940-daed07799d9b?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Tacos de Pollo",
                description = "Tacos rellenos de pollo sazonado",
                price = 7.00,
                imageUrl = "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Quesadilla Suprema",
                description = "Tortilla rellena de queso y carne",
                price = 9.75,
                imageUrl = "https://images.unsplash.com/photo-1618040996337-56904b7850b9?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 5,
        name = "Healthy Bowl",
        description = "Comida saludable y fresca",
        imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554?q=80&w=687",
        categories = listOf("Saludable", "Ensaladas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Bowl de Pollo",
                description = "Arroz integral, pollo y vegetales",
                price = 10.50,
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Ensalada César",
                description = "Lechuga, pollo y aderezo césar",
                price = 9.25,
                imageUrl = "https://images.unsplash.com/photo-1551248429-40975aa4de74?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Wrap Vegetariano",
                description = "Wrap con vegetales frescos",
                price = 8.99,
                imageUrl = "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 6,
        name = "Pasta Italia",
        description = "Pastas y recetas italianas",
        imageUrl = "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?q=80&w=687",
        categories = listOf("Italiana", "Pastas"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Lasagna",
                description = "Lasagna tradicional con carne",
                price = 14.50,
                imageUrl = "https://images.unsplash.com/photo-1619895092538-128341789043?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Pizza Cuatro Quesos",
                description = "Pizza con mezcla de quesos italianos",
                price = 15.00,
                imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Spaghetti Carbonara",
                description = "Pasta con salsa cremosa y tocino",
                price = 13.20,
                imageUrl = "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 7,
        name = "Coffee Corner",
        description = "Café, postres y desayunos",
        imageUrl = "https://images.unsplash.com/photo-1509042239860-f550ce710b93?q=80&w=687",
        categories = listOf("Café", "Postres"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Café Latte",
                description = "Café espresso con leche",
                price = 4.50,
                imageUrl = "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Cheesecake",
                description = "Pastel cremoso de queso",
                price = 6.00,
                imageUrl = "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Café Especial",
                description = "Café premium con canela y crema",
                price = 5.80,
                imageUrl = "https://images.unsplash.com/photo-1517701604599-bb29b565090c?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 8,
        name = "Seafood Market",
        description = "Mariscos frescos todos los días",
        imageUrl = "https://images.unsplash.com/photo-1559847844-5315695dadae?q=80&w=687",
        categories = listOf("Mariscos"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Camarones Empanizados",
                description = "Camarones crujientes con salsa tártara",
                price = 16.50,
                imageUrl = "https://images.unsplash.com/photo-1625943555419-56a2cb596640?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Pescado Frito",
                description = "Pescado fresco acompañado de arroz",
                price = 15.00,
                imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Paella Especial",
                description = "Arroz con mariscos frescos",
                price = 17.25,
                imageUrl = "https://images.unsplash.com/photo-1515443961218-a51367888e4b?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 9,
        name = "BBQ House",
        description = "Carnes ahumadas y parrilladas",
        imageUrl = "https://images.unsplash.com/photo-1529193591184-b1d58069ecdd?q=80&w=687",
        categories = listOf("Parrilla", "Carnes"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Costillas BBQ",
                description = "Costillas bañadas en salsa BBQ",
                price = 18.99,
                imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Pollo Ahumado",
                description = "Pollo cocinado lentamente al carbón",
                price = 14.75,
                imageUrl = "https://images.unsplash.com/photo-1527477396000-e27163b481c2?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Alitas Picantes",
                description = "Alitas bañadas en salsa picante",
                price = 11.50,
                imageUrl = "https://images.unsplash.com/photo-1567620832903-9fc6debc209f?q=80&w=687"
            )
        )
    ),
    Restaurant(
        id = 10,
        name = "Sweet Paradise",
        description = "Postres y helados irresistibles",
        imageUrl = "https://images.unsplash.com/photo-1488477181946-6428a0291777?q=80&w=687",
        categories = listOf("Postres", "Helados"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Brownie con Helado",
                description = "Brownie caliente con helado de vainilla",
                price = 7.50,
                imageUrl = "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?q=80&w=687"
            ),
            Dish(
                id = 2,
                name = "Malteada de Chocolate",
                description = "Malteada cremosa de chocolate",
                price = 5.25,
                imageUrl = "https://images.unsplash.com/photo-1572490122747-3968b75cc699?q=80&w=687"
            ),
            Dish(
                id = 3,
                name = "Cheesecake Especial",
                description = "Cheesecake con frutos rojos",
                price = 9.99,
                imageUrl = "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?q=80&w=687"
            )
        )
    )
)