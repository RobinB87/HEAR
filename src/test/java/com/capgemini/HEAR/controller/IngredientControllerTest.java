package com.capgemini.HEAR.controller;


import com.capgemini.HEAR.model.Entities.Ingredient;
import com.capgemini.HEAR.repository.IIngredientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// for referall if you might remove the code above (if it happens this still remains)
/*
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 */


@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IngredientControllerTest {

    @InjectMocks
    private IngredientController ingredientController;

    @Mock
    private IIngredientRepository ingredientRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ingredientController).build();
    }

    @Test
    public void testCreateDrink() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setTitle("Beer");
        ObjectMapper mapper = new ObjectMapper();
        String ingredientAsString = mapper.writeValueAsString(ingredient);

        Mockito.when(this.ingredientRepository.save(any(Ingredient.class))).thenReturn(ingredient);

        this.mockMvc.perform(post("/api/ingredient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ingredientAsString)).andDo(print())
                .andExpect(jsonPath("$.id", is(Long.valueOf(ingredient.getId()).intValue())))
                .andExpect(jsonPath("$.title", is(ingredient.getTitle())))
                .andExpect(jsonPath("$.costPrice", is(ingredient.getCostPrice())))
                .andExpect(status().isOk()
                );

        Mockito.verify(this.ingredientRepository, Mockito.times(1)).save(ingredient);
    }

    @Test
    public void testGetDrink() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(2);
        ingredient.setTitle("Cola");
        ingredient.setCostPrice(2.0);
        ingredient.setSellingPrice(2.5);
        ObjectMapper mapper = new ObjectMapper();
        String ingredientAsString = mapper.writeValueAsString(ingredient);

        Mockito.when(this.ingredientRepository.findById(2)).thenReturn(Optional.of(ingredient));

        this.mockMvc.perform(get("/api/ingredient/get/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ingredientAsString)).andDo(print())
                .andExpect(jsonPath("$.id", is(Long.valueOf(ingredient.getId()).intValue())))
                .andExpect(jsonPath("$.title", is(ingredient.getTitle())))
                .andExpect(jsonPath("$.costPrice", is(ingredient.getCostPrice())))
                .andExpect(jsonPath("$.sellingPrice", is(ingredient.getSellingPrice())))
                .andExpect(status().isOk()
                );

        Mockito.verify(this.ingredientRepository, Mockito.times(1)).findById(2);
    }

    @Test
    public void testGetNonExistingIngredient() throws Exception {
        Mockito.when(this.ingredientRepository.findById(2)).thenReturn(Optional.ofNullable(null));

        this.mockMvc.perform(get("/api/ingredient/get/2") // be aware, this is a consious typo
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound()
                );

        Mockito.verify(this.ingredientRepository, Mockito.times(1)).findById(2);
    }
}