package ru.strelchm.sbrackets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.strelchm.sbrackets.api.dto.CheckBracketsTextRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.strelchm.sbrackets.api.TextOperationsController.CHECK_BRACKETS_MAPPING_PATH;
import static ru.strelchm.sbrackets.api.TextOperationsController.ROOT_MAPPING_PATH;

@SpringBootTest
@AutoConfigureMockMvc
class TextOperationsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldIsCorrectIfTextHasCorrectBrackets() throws Exception {
        String requestJson = new ObjectMapper().writeValueAsString(new CheckBracketsTextRequest("(SDFDSF)"));

        mvc.perform(
                        post(ROOT_MAPPING_PATH + CHECK_BRACKETS_MAPPING_PATH)
                                .contentType(APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(true));
    }

    @Test
    void shouldNotIsCorrectIfTextHasUncorrectBrackets() throws Exception {
        String requestJson = new ObjectMapper().writeValueAsString(new CheckBracketsTextRequest("()"));

        mvc.perform(
                        post(ROOT_MAPPING_PATH + CHECK_BRACKETS_MAPPING_PATH)
                                .contentType(APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false));
    }

    @Test
    void shouldNotIsCorrectIfTextIsEmpty() throws Exception {
        String requestJson = new ObjectMapper().writeValueAsString(new CheckBracketsTextRequest(""));

        mvc.perform(
                        post(ROOT_MAPPING_PATH + CHECK_BRACKETS_MAPPING_PATH)
                                .contentType(APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false));
    }

    @Test
    void shouldNotIsCorrectIfTextIsNull() throws Exception {
        String requestJson = new ObjectMapper().writeValueAsString(new CheckBracketsTextRequest(null));

        mvc.perform(
                        post(ROOT_MAPPING_PATH + CHECK_BRACKETS_MAPPING_PATH)
                                .contentType(APPLICATION_JSON)
                                .content(requestJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false));
    }
}