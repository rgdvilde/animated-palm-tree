
## Getting Started

graphql\java_tests\grapqljava_postgres geeft een voorbeeld van het gebruik van graphql om databanken van verschillende soorten te linken. Hier wordt een mongodb samen met een postgres databank gebruikt.

graphql\java_tests\grapqljava_mogodb is een outdated versie met enkel mongodb

graphql\java_test\POQ wordt nog aan gewerkt


### Prerequisites

- Installeer Maven
- Installeer MONGOdb
- Installer POSTGRes
  - ofwel neem als ww 'post' of pas het ww aan in de graphqlendpoint.java file
  - Maak een database aan genaamd TEST, of pas naam ook aan
  - Maak een tabel aan genaamd wagen met 2 kolommen nml nummer (int) en naam(string)
  - populate
- Ga in cmd naar de folder graphql\java_tests\grapqljava_postgres\hackernews-graphql-java en run daar



```
mvn jetty:run
```

Als alles goed verloopt krijg je een website op http://localhost:8080/?graphql, daar kun je links Grahphql queries typen. Probeer volgende om te verifieren.

```
query{
  getCarWithNumber(nummer:xx){
    naam
  }
}
```

met xx een nr die je erin hebt gestoken en als repons moet je hebben

```
{
  "data": {
    "getCarWithNumber": {
      "naam": "test"
    }
  }
}
```

met "test" de naam van uw wagen. Indien dit werkt werkt de sql database

test voor mongodb

```
mutation{
  createLink(url:"link.com", description:"dit is een link")
}
```

voeg enkele links toe, doe dan 
```
query{
  allLinks{
    url
  }
}
```

Indien daar al uw links staan werkt mongodb










