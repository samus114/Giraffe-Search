package org.jointheleague.level7.giraffe.presentation;

import org.jointheleague.api.giraffe.Giraffe.Search.repository.dto.Result;
import org.jointheleague.level7.giraffe.service.LocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(LocController.class)
class LocControllerIntTest {

    private LocController locController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocService locService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        locController = new LocController(locService);
    }

    @Test
    public void givenGoodQuery_whenSearchForResults_thenIsOkAndReturnsResults() throws Exception {
        //given
        String name = "Java";
        String summary = "Java: A Drink, an Island, and a Programming Language";
        String subtitle = "AUTHOR";
        String link = "LINK";
        Result result = new Result();
        result.setName(name);
        result.setSummary(summary);
        result.setSubtitle(subtitle);
        List<Result> expectedResults = Collections.singletonList(result);

//        when(locService.getResults(query)).thenReturn(expectedResults);

        //when
        //then
//        MvcResult mvcResult = mockMvc.perform(get("/searchLocResults?q=" + query))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].title", is(index)))
//                .andExpect(jsonPath("$[0].authors[0]", is(author)))
//                .andExpect(jsonPath("$[0].link", is(link)))
//                .andReturn();

//        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

    @Test
    public void givenBadQuery_whenSearchForResults_thenIsNotFound() throws Exception {
        //given
        String query = "Java";

        //when
        //then
        mockMvc.perform(get("/searchLocResults?q=" + query))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}