package project.petmap.accessingdatamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/testTable")
public class TestTableController {

	@Autowired
	private TestTableService testTableService;
	
	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addUser(@RequestBody TestTable tt ) {
		return testTableService.add(tt);

	}

	@GetMapping(path = "/all")
	public List<TestTable> getAllUsers() {
		return testTableService.findAll();
	}

}
