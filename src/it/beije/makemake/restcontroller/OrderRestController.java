package it.beije.makemake.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.entity.Order;
import it.beije.makemake.service.OrderService;

@RestController
@RequestMapping("api")
public class OrderRestController {
	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/{id}/ordini")
	public @ResponseBody List<Order> getOrders(@PathVariable(name="id") Integer userId) {
		return orderService.getOrders(userId);
	}
}
