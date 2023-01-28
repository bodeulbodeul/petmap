package project.petmap.accessingdatamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTableService {

	@Autowired
	private TestTableRepository repository;

	public String add(TestTable tt) {
		repository.save(tt);
		return "saved";

	}

	public List<TestTable> findAll() {	
		return repository.findAll();
	}

}
