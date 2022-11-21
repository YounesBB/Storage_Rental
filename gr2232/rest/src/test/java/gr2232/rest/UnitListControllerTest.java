package gr2232.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import gr2232.json.UnitListModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers; 

@ExtendWith(SpringExtension.class)
@WebMvcTest(UnitListController.class)
@ContextConfiguration(classes = { UnitListController.class, UnitListService.class, UnitListModule.class})
@WebAppConfiguration
class UnitListControllerTest {

  @Autowired
  private MockMvc mvc;


  @MockBean
  private UnitListService unitListService;

  @Autowired
  private ObjectMapper mapper;

  /**
   * Dispatches a GET request to get a VisitLog and tests if the request was successful.
   *
   * @throws Exception if something goes wrong with the MvcReqeusts.
   */
  
  @Test
  void getUnitList() throws Exception {
    given(unitListService.getUnitList()).willReturn(UnitListService.getUnitListTestJson());
    MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/unitlist/test"))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].isRented").value("true"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].customerName").value("Peter"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].location").value("0"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].size").value("L"))
        .andReturn();
    /** 
    UnitList u1 = new ObjectMapper().registerModule(new UnitListModule()).readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), UnitList.class);
    assertEquals(1, u1.getUnitListEntries().size()); 
    */
  }



  /**
   * Dispatches a POST request to add a Unit and tests if the request was successful.
   *
   * @throws Exception if something goes wrong with the MvcRequest.
   */
  @Test
  void addUnit() throws Exception {
    Unit u1 = new Unit('L', 17, true, "Tony");
    String json = mapper.writeValueAsString(u1);
    MvcResult result = mvc.perform(MockMvcRequestBuilders
        .post("/unitlist")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andReturn();
    assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
  }

  /**
   * Dispatches a PUT request to remove a tenant from a Unit by location.
   *
   * @throws Exception if something goes wrong with the MvcRequest
   */
  @Test
  void removeTenant() throws Exception {
    Integer location = 17;
    MvcResult result = mvc.perform(MockMvcRequestBuilders
        .put("/unitlist/removetenant/" + location))
        .andExpect(status().isOk())
        .andReturn();
    assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
  }

  /**
   * Dispatches a PUT request to add a tenant to a Unit by name of the tenant and location of the Unit. 
   *
   * @throws Exception if something goes wrong with the MvcRequest
   */
  @Test
  void addTenant() throws Exception {
    String tenantName = "Tony";
    Integer location = 17; 
    MvcResult result = mvc.perform(MockMvcRequestBuilders
        .put("/unitlist/addtenant/" + location + "/" + tenantName))
        .andExpect(status().isOk())
        .andReturn();
    assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
    //Hvis listen er tom så vil testen faile som IllegalstateExeption 
  }

  /**
   * Dispatches a DELETE request to delete a Unit with a given location and tests if the request was
   * successful.
   *
   * @throws Exception if something goes wrong with the MvcRequest
   */
  @Test
  void removeUnit() throws Exception {
    Integer location = 17;
    MvcResult result = mvc.perform(MockMvcRequestBuilders
        .delete("/unitlist/" + location))
        .andExpect(status().isOk())
        .andReturn();
    assertTrue(Boolean.parseBoolean(result.getResponse().getContentAsString()));
  }


}