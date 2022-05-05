package com.thanos.SecurityDemo.controller;

import static org.mockito.Mockito.when;

import com.thanos.SecurityDemo.entity.UserApp;
import com.thanos.SecurityDemo.service.DaoUserAppService;
import com.thanos.SecurityDemo.service.UserAppService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserAppController.class})
@ExtendWith(SpringExtension.class)
class UserAppControllerTest {
    @MockBean
    private DaoUserAppService daoUserAppService;

    @Autowired
    private UserAppController userAppController;

    @MockBean
    private UserAppService userAppService;

    /**
     * Method under test: {@link UserAppController#getUserAppTable()}
     */
    @Test
    void testGetUserAppTable() throws Exception {
        when(this.userAppService.getAllUserApp()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/allUser");
        MockMvcBuilders.standaloneSetup(this.userAppController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserAppController#getUserAppTable()}
     */
    @Test
    void testGetUserAppTable2() throws Exception {
        UserApp userApp = new UserApp();
        userApp.setEmail("jane.doe@example.org");
        userApp.setId(123L);
        userApp.setName("?");
        userApp.setPassword("iloveyou");
        userApp.setRole("?");

        ArrayList<UserApp> userAppList = new ArrayList<>();
        userAppList.add(userApp);
        when(this.userAppService.getAllUserApp()).thenReturn(userAppList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/allUser");
        MockMvcBuilders.standaloneSetup(this.userAppController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":123,\"name\":\"?\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"role\":\"?\"}]"));
    }

    /**
     * Method under test: {@link UserAppController#getUserAppTable()}
     */
    @Test
    void testGetUserAppTable3() throws Exception {
        when(this.userAppService.getAllUserApp()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/allUser");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.userAppController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserAppController#refreshToken(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     */
    @Test
    void testRefreshToken() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userAppController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}

