package it.beije.makemake.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.makemake.service.OrderService;

@RestController
@RequestMapping("api")
public class OrderRestController {
	@Autowired
	private OrderService orderService;

}
