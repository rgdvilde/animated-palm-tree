package com.howtographql.hackernews;
import java.sql.SQLException;

import com.coxautodev.graphql.tools.GraphQLRootResolver;


public class Mutation implements GraphQLRootResolver {
    
    private final LinkRepository linkRepository;
	private final CarRepository carRepository;

    public Mutation(LinkRepository linkRepository, CarRepository carRepository) {
        this.linkRepository = linkRepository;
        this.carRepository = carRepository;
    }
    
    public Link createLink(String url, String description) {
        Link newLink = new Link(url, description);
        linkRepository.saveLink(newLink);
        return newLink;
    }
    
    
    
    public Link deleteLink(String url) {
    	return linkRepository.deleteLink(url);
    }
    
    public Car createCar(int nummer, String naam) throws SQLException {
    	Car newCar = new Car(nummer, naam);
    	carRepository.saveCar(newCar);
    	return newCar;
    }
    
    public Car deleteCar(int nummer) {
    	return null;
    }
}
