package com.howtographql.hackernews;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;

import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;
import graphql.servlet.SimpleGraphQLServlet;
import graphql.schema.GraphQLSchema;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	private static final LinkRepository linkRepository;
	private static final CarRepository carRepository;

    static {
//        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
//        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("hackernews");
        linkRepository = new LinkRepository(mongo.getCollection("links"));
        
        
    	Connection c = null;
        try {
           Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/TEST",
              "postgres", "post");
        } catch (Exception e) {
           e.printStackTrace();
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           System.exit(0);
        }
        carRepository = new CarRepository(c);
        System.out.println("Opened database successfully");
    }
    
	
    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository, carRepository), new Mutation(linkRepository,carRepository))
                .build()
                .makeExecutableSchema();
    }
}