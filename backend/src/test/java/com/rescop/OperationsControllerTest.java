package com.rescop;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class OperationsControllerTest {
 @Autowired MockMvc mvc;
 @Test void summaryReturnsMetrics() throws Exception { mvc.perform(get("/api/operations/summary")).andExpect(status().isOk()).andExpect(jsonPath("$.totalOrders").value(7)); }
 @Test void ordersCanBeFiltered() throws Exception { mvc.perform(get("/api/operations/orders").param("status","DELAYED")).andExpect(status().isOk()).andExpect(jsonPath("$[0].status").value("DELAYED")); }
}
