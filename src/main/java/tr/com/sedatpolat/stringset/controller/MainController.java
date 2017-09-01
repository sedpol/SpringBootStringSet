package tr.com.sedatpolat.stringset.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author sedpol
 *
 */
@RestController
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "it works!";
	}
}
