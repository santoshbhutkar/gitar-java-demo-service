package com.sonar.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  void ownerCanReadTheirOrder() throws Exception {
    mockMvc.perform(get("/orders/1001").header("X-User-Id", "alice"))
        .andExpect(status().isOk());
  }

  @Test
  void anotherUserCannotReadTheOrder() throws Exception {
    mockMvc.perform(get("/orders/1001").header("X-User-Id", "bob"))
        .andExpect(status().isForbidden());
  }
}
