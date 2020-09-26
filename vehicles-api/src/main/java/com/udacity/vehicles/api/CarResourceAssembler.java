package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.car.Car;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * Maps the CarController to the Car class using HATEOAS
 */
@Component
public class CarResourceAssembler implements ResourceAssembler<Car, Resource<Car>> {

    @Override
    public Resource<Car> toResource(Car car) {
        return new Resource<>(car,
                linkTo(methodOn(CarController.class).get(car.getId())).withSelfRel(),
                linkTo(methodOn(CarController.class).list()).withRel("cars"));

    }
}
