package com.thanos.SecurityDemo.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.thanos.SecurityDemo.entity.UserApp;
import com.thanos.SecurityDemo.repository.UserAppRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserAppService.class})
@ExtendWith(SpringExtension.class)
class UserAppServiceTest {
    @MockBean
    private UserAppRepo userAppRepo;

    @Autowired
    private UserAppService userAppService;

    /**
     * Method under test: {@link UserAppService#getAllUserApp()}
     */
    @Test
    void testGetAllUserApp() {
        ArrayList<UserApp> userAppList = new ArrayList<>();
        when(this.userAppRepo.findAll()).thenReturn(userAppList);
        List<UserApp> actualAllUserApp = this.userAppService.getAllUserApp();
        assertSame(userAppList, actualAllUserApp);
        assertTrue(actualAllUserApp.isEmpty());
        verify(this.userAppRepo).findAll();
    }
}

