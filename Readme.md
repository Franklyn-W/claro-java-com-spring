Java RESTful API criada no bootcamp Claro - Java com Spring Boot

Criação de uma API Rest do zero usando Java 21 e Spring Boot, para persistencia dos dados, durante o desenvolvimento sera usado o sistema H2 e para "produção" será usado o SGBD Postgrees, ambos com o auxilio do Spring JPA. Para a geração de documentação será usado o Swagger.


## Modelo de abstração do dominio

```JSON
{
    "name": "Franklyn",
    "account": {
        "number": "123456789-0",
        "agency": "1234",
        "balance": 1234.65,
        "limit": 1000.0
    },
    "features": [
        {
            "icon": "URL",
            "description": "Descrição da feature"
        }
    ],
    "card": {
        "number": "xxxx-xxxx-xxxx-0000",
        "limit": 1000.0
    },
    "news": [
        {
            "icon": "URL",
            "description": "Descrição da novidade"
        }
    ]
}
```

### Diagrama de Classes


```` mermaid
classDiagram
    class User {
        +String name
        +Account account
        +Feature[] features
        +Card card
        +News[] news
    }

    class Account {
        +String number
        +String agency
        +float balance
        +float limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +float limit
    }

    class News {
        +String icon
        +String description
    }

    User "1" *-- "1" Account
    User "1" *-- "N" Feature
    User "1" *-- "1" Card
    User "1" *-- "N" News
```
