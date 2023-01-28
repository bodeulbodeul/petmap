package project.petmap.accessingdatamysql;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TestTableRepository extends CrudRepository<TestTable, Integer>  {
	
	List<TestTable> findAll();

}
