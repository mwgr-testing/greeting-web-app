package net.mwgr.testing.github.greeting.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.mwgr.testing.github.greeting.lib.Greeter;

@RestController
public class GreetingController {

	@Autowired
	private Greeter greeter;

	@GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
	public String greetingAsTextPlain(@RequestParam(value = "name", required = false) String name) {
		return greeting(name);
	}

	@GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String greetingAsTextHtml(@RequestParam(value = "name", required = false) String name) {
		return "<h2>" + greeting(name) + "</h2>";
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public String greetingAsApplicationJson(@RequestParam(value = "name", required = false) String name) {
		return "{ \"greeting\" : \"" + greeting(name) + "\" }";
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
	public String greetingAsApplicationXml(@RequestParam(value = "name", required = false) String name) {
		return "<greeting>" + greeting(name) + "</greeting>";
	}

	private String greeting(String name) {
		return name == null ? greeter.greet() : greeter.greet(name);
	}

}
