package workshop.pokerhands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HandController.class)
public class ControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void postHandsTest() throws Exception {
        Card card1=new Card(8, Suit.SPADE);
        Card card2=new Card(5, Suit.SPADE);
        Card card3=new Card(4, Suit.DIAMOND);
        Card card4=new Card(3, Suit.DIAMOND);
        Card card5=new Card(2, Suit.SPADE);
        Card[] cards1= {card1,card2,card3,card4,card5};
        Card card6=new Card(8, Suit.SPADE);
        Card card7=new Card(5, Suit.SPADE);
        Card card8=new Card(4, Suit.DIAMOND);
        Card card9=new Card(3, Suit.DIAMOND);
        Card card10=new Card(2, Suit.SPADE);
        Card[] cards2= {card6,card7,card8,card9,card10};

        Hand hand1=new Hand("P1", cards1);
        Hand hand2=new Hand("P2", cards2);
        Hand hands[]={hand1,hand2};
        ObjectMapper objectMapper=new ObjectMapper();

        String handDTO=objectMapper.writeValueAsString(hands);

        MockHttpServletRequestBuilder request = post("/hands").contentType(MediaType.APPLICATION_JSON).content(handDTO);
        mockMvc.perform(request)
                .andExpect(status().isOk()).andExpect(jsonPath("$").value("Draw"));
    }
}
