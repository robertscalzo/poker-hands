package workshop.pokerhands;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoolController.class)
public class ControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void doSomethingCool() throws Exception {

        MockHttpServletRequestBuilder request = get("/coolstuff");
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }
}
