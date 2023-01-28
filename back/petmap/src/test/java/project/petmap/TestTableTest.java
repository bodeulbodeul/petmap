package project.petmap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import project.petmap.accessingdatamysql.TestTable;
import project.petmap.accessingdatamysql.TestTableController;

@SpringBootTest
@AutoConfigureMockMvc
public class TestTableTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestTableController controller;

	// 설정 옵션1 테스트하려는 컨트롤러를 직접 가리키고 Spring MVC 인프라를 프로그래밍 방식으로 구성
	// 단위 테스트에 조금 더 가깝습니다. 한 번에 하나의 컨트롤러를 테스트
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	// 설정 옵션 2 보다 완전한 통합 테스트를 수행
//	@BeforeEach
//	void setup(WebApplicationContext wac) {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}

	final static String BASE_URI = "/testTable";

	@Test
	public void addNewData() throws Exception {

		String uri = BASE_URI.concat("/add");

		TestTable tt = TestTable.builder().name("이름").email("이메일").build();
		String om = new ObjectMapper().writeValueAsString(tt);
		
		mockMvc.perform(post(uri).content(om).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andReturn();		

	}

	@Test
	public void getAllTestTable() throws Exception {
		mockMvc.perform(get(BASE_URI.concat("/all"))).andDo(print()).andExpect(status().isOk());
	}

}
