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

	private static final LocationRepository locationRepository;
	private static final DateRepository dateRepository;

    static {
//        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
//        //if you don't have Mongo running locally on port 27017
   //     MongoDatabase mongo = new MongoClient().getDatabase("hackernews");
   //     linkRepository = new LinkRepository(mongo.getCollection("links"));
        
        
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
        locationRepository = new LocationRepository(c);
        dateRepository = new DateRepository();
        System.out.println("Opened database successfully");
    }
    
	
    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
    	SchemaParser.newParser();
    	SchemaParser.newParser().file("schema.graphqls");
    	SchemaParser.newParser().file("schema.graphqls").resolvers(new Query(dateRepository, locationRepository), new Mutation(dateRepository, locationRepository));
    	SchemaParser.newParser().file("schema.graphqls").resolvers(new Query(dateRepository, locationRepository), new Mutation(dateRepository, locationRepository)).build();
        
    	SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(new Query(dateRepository, locationRepository), new Mutation(dateRepository, locationRepository))
        .build()
        .makeExecutableSchema();
    	
    	return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(dateRepository, locationRepository), new Mutation(dateRepository, locationRepository))
                .build()
                .makeExecutableSchema();
    }
}