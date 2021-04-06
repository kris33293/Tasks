package com.crud.tasks.controller;


import com.crud.tasks.trello.facade.TrelloFacade;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import java.util.List;

@SpringJUnitWebConfig
@WebMvcTest(TrelloController.class)
class TrelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrelloFacade trelloFacade;

//   @Test
//   void shouldFetchEmptyTrelloBoards() throws Exception {
//       // Given
//       when(trelloFacade.fetchTrelloBoards()).thenReturn(List.of());

//       //When & Then
//       mockMvc
//               .perform(MockMvcRequestBuilders
//                       .post("/v1/trello/getTrelloBoards")
//                       .contentType(MediaType.APPLICATION_JSON))
//                       .andExpect(MockMvcResultMatchers.status()).is(200) // or isOk()
//                       .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
//   }
}