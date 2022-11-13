package gr2232.rest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import gr2232.core.Unit;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UnitListController.class)
public class UnitListControllerTest {


  @Autowired
  private MockMvc mvc;

  @MockBean
  private UnitListService service;

  @Autowired
  private ObjectMapper mapper;

  /**
   * Dispatches a POST request to add a Visit and tests if the request was successful.
   *
   * @throws Exception if something goes wrong with the MvcRequest.
   */
  @Test
  void addVisit() throws Exception {
    Unit v1 = new Unit('M', 6);
    String json = mapper.writeValueAsString(v1);
    MvcResult result = mvc.perform(MockMvcRequestBuilders
        .post("/unitlist")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andReturn();
    assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
  }



  
}
