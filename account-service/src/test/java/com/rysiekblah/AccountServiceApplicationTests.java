package com.rysiekblah;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceApplicationTests {

    @Autowired
    private Gson gson;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetUserNotExist() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/account/0")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isNotFound());
	}

    @Test
    public void testGetExistingDefaultUserById() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/account/1")
        ).andExpect(status().isOk()).andExpect(content().json(new Account(1l, "TESTUSER", "ADMIN").toJson()));
    }

    @Test
    public void testGetExistingDefaultUserByName() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/account/byName")
                        .param("name", "TEST")
        ).andExpect(status().isOk()).andExpect(content().json(gson.toJson(new Account[] {new Account(1l, "TESTUSER", "ADMIN")})));
    }

	@Test
	public void testInsertUserAndObtain() throws Exception {
		Account account = new Account(0l, "Tomek", AccountRoles.ADMIN.name());
		mvc.perform(
				MockMvcRequestBuilders
						.post("/account/add")
						.content(account.toJson())
						.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isCreated());

		mvc.perform(
				MockMvcRequestBuilders
						.get("/account/1")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andExpect(content().json(account.toJson()));
	}

}
