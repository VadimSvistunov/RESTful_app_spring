package by.svistunovvv.restfullApp.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import by.svistunovvv.restfullApp.controllers.assemblers.OrderModelAssembler;
import by.svistunovvv.restfullApp.domain.Order;
import by.svistunovvv.restfullApp.domain.Status;
import by.svistunovvv.restfullApp.exceptions.OrderNotFoundException;
import by.svistunovvv.restfullApp.repository.OrderRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private final OrderRepository repository;
    private final OrderModelAssembler assembler;

    public OrderController(OrderRepository repository, OrderModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/orders")
    public CollectionModel<EntityModel<Order>> getAll() {
        List<EntityModel<Order>> orders = repository.findAll() //
                .stream().map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(orders,  //
                linkTo(methodOn(OrderController.class).getAll()).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    EntityModel<Order> getOrder(@PathVariable Long id) {
        Order order = repository.findById(id)  //
                .orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> newOrder(@RequestBody Order order) {
        order.setStatus(Status.IN_PROGRESS);

        Order newOrder = repository.save(order);

        return ResponseEntity //
                .created(linkTo(methodOn(OrderController.class).getOrder(newOrder.getId())).toUri())
                .body(assembler.toModel(newOrder));
    }
}
