package com.howtographql.hackernews;

import java.sql.SQLException;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Query implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;
    private final CarRepository carRepository;

    public Query(LinkRepository linkRepository, CarRepository carRepository) {
        this.linkRepository = linkRepository;
        this.carRepository = carRepository;
    }

    public List<Link> getAllLinks() {
        return linkRepository.getAllLinks();
    }
    
    public Car getCarWithNumber(int i) throws SQLException{
    	
    	Car c =  carRepository.getCarWithNumber(i);
    	System.out.println("CAR1:" + c.getNaam() + " " + c.getNummer());
    	return c;
    }
}