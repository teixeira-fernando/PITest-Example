package com.example.MyFirstSpringBootApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MutationTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void smallerThanOrEqualToFiftyMessage() throws Exception {
    this.mockMvc
        .perform(get("/compareToFifty/50")) // example of mutant: compare with 49
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Smaller than or equal to 50"));
  }

  @Test
  public void greaterThanFiftyMessage() throws Exception {
    this.mockMvc
        .perform(get("/compareToFifty/51"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("Greater than 50"));
  }

  @Test
  public void increment() throws Exception {
    this.mockMvc
        .perform(get("/increment/5"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("6")); // example of mutant: do not check if the value was incremented
  }
}
