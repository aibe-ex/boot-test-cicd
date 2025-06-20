package org.example.boottestcicd.web;

import org.example.boottestcicd.controller.FishcakeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FishcakeController.class)
class FishcakeControllerTest {

    @Autowired // 의존성 주입
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /fishcake -> 200")
    void getFishcakeOK() throws Exception {
        mockMvc.perform(get("/fishcake")) // when
                .andExpect(status().isOk()) //then
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$[0].shape").exists())
        ;
    }

    @Test
    @DisplayName("GET /cake -> 404")
    void getCakeNotFound() throws Exception {
        mockMvc.perform(get("/cake")) // when
                .andExpect(status().isNotFound()); //then
    }
}