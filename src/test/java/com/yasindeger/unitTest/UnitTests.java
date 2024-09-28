package com.yasindeger.unitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UnitTests {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Unit Test : 5-3 should be 2")
    @Test
    public void testInfo() throws Exception {
        this.mockMvc.perform(get("/info"))
                .andExpect(status().is(200))
                .andExpect(content().string("DEVOPS INFO : "))
                .andReturn().getResponse().getContentAsString().contains("DEVOPS INFO : ");
    }

    @DisplayName("Unit Test : 2+3 should be 5")
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @DisplayName("Unit Test : 5-3 should be 2")
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum(5, 3);
        assertEquals(2, result);
    }




}
