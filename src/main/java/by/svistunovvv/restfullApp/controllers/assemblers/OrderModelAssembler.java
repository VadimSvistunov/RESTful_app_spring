package by.svistunovvv.restfullApp.controllers.assemblers;

import by.svistunovvv.restfullApp.controllers.EmployeeController;
import by.svistunovvv.restfullApp.controllers.OrderController;
import by.svistunovvv.restfullApp.domain.Employee;
import by.svistunovvv.restfullApp.domain.Order;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {
        return null;
    }
}
