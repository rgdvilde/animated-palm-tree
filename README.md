# Project Title

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

-Installeer Maven
-Installeer MONGOdb
-Installer POSTGRes
--ofwel neem als ww 'post' of pas het ww aan in de graphqlendpoint.java file
--Maak een database aan genaamd TEST, of pas naam ook aan
--Maak een tabel aan genaamd wagen met 2 kolommen nml nummer (int) en naam(string)
--populate
-Ga in cmd naar de folder graphql\java_tests\grapqljava_postgres\hackernews-graphql-java en run daar

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

{
  allLinks(){
    url
   }
 }
```

Indien daar al uw links staan werkt mongodb










-------------------------------
### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
