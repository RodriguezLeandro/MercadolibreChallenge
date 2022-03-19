package com.meli.MercadolibreChallenge.Test.Presentation.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.MercadolibreChallenge.Domain.Entities.Dna;
import com.meli.MercadolibreChallenge.Infrastructure.Configuration.DynamoDbConfig;
import com.meli.MercadolibreChallenge.MercadolibreChallengeApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.match.JsonPathRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DynamoDbConfig.class, Dna.class, MercadolibreChallengeApplication.class})
@WebAppConfiguration
public class DnaControllerTests extends AbstractJUnit4SpringContextTests
{

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesDnaController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webApplicationContext.getBean("dnaController"));
    }

    @Test
    public void Test001ControllerStatisticGetRequestSucceeds() throws Exception {
        MvcResult mvcResult = null;
        try {
            mvcResult = this.mockMvc.perform(get("/stats"))
                    .andDo(print()).andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.count_human_dna").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.count_mutant_dna").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.ratio").exists())
                    .andReturn();
        Assert.assertEquals("application/json",
                mvcResult.getResponse().getContentType());

        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of get request");
        }
    }

    @Test
    public void Test002ControllerMutantPostRequestReturnsForbidden403ErrorWhenHumanSubmitted() throws Exception {
        try
        {
            ObjectMapper mapper=new ObjectMapper();
            String jsonString = mapper.writeValueAsString(mapper.readValue("{\"dna\" : [\"123\" , \"456\"]}", Object.class));
            var params = post("/mutant").content(jsonString).contentType("application/json;charset=UTF-8");
            MvcResult mvcResult = this.mockMvc.perform(params).andDo(print())
                    .andExpect(status().is4xxClientError()).andReturn();

            assertEquals(403, mvcResult.getResponse().getStatus());
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of post request");
        }
    }

    @Test
    public void Test003ControllerMutantPostRequestReturnsOk200WhenMutantSubmitted() throws Exception {
        try{
            ObjectMapper mapper=new ObjectMapper();
            String jsonString = mapper.writeValueAsString(mapper.readValue("{\"dna\" : [\"AAAA\" , \"GGGG\",  \"TTTT\",  \"CCCC\"]}", Object.class));
            var params = post("/mutant").content(jsonString).contentType("application/json;charset=UTF-8");
            MvcResult mvcResult = this.mockMvc.perform(params).andDo(print())
                    .andExpect(status().isOk()).andReturn();

            assertEquals(200, mvcResult.getResponse().getStatus());
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of post request");
        }
    }

    @Test
    public void Test004ControllerMutantGetRequestReturns403ForbiddenError() throws Exception {
        MvcResult mvcResult = null;
        try
        {
            mvcResult = this.mockMvc.perform(get("/mutant"))
                    .andDo(print()).andExpect(status().is4xxClientError())
                    .andReturn();
            Assert.assertEquals(403,
                    mvcResult.getResponse().getStatus());
        }catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of get request");
        }
    }

    @Test
    public void Test005ControllerStatisticsPostRequestReturns403ForbiddenError() throws Exception {
        MvcResult mvcResult = null;
        try
        {
            ObjectMapper mapper=new ObjectMapper();
            String jsonString = mapper.writeValueAsString(mapper.readValue("{\"dna\" : [\"AAAA\" , \"GGGG\",  \"TTTT\",  \"CCCC\"]}", Object.class));
            var params = post("/stats").content(jsonString).contentType("application/json;charset=UTF-8");
            mvcResult = this.mockMvc.perform(params).andDo(print())
                    .andExpect(status().is4xxClientError()).andReturn();

            assertEquals(403, mvcResult.getResponse().getStatus());
        }catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of post request");
        }
    }

    @Test
    public void Test006ControllerReturns403WhenErrorRedirectionOccurs() throws Exception {
        MvcResult mvcResult = null;
        try
        {
            mvcResult = this.mockMvc.perform(get("/error"))
                    .andDo(print()).andExpect(status().is4xxClientError())
                    .andReturn();
            Assert.assertEquals(403,
                    mvcResult.getResponse().getStatus());
        }catch(Exception ex)
        {
            logger.error(ex.getMessage());
            throw new Exception("Failed execution of get request");
        }
    }
}
