package com.example.tgbot;


import com.example.tgbot.repository.StatsRepository;
import com.example.tgbot.service.StatsService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class StatsServiceTests {

    @InjectMocks
    private StatsService statsService;

    @Mock
    StatsRepository statsRepository;


    // запишем время, когда начался каждый тест
    @BeforeEach
    public void beforeAll() {
        System.out.println(System.currentTimeMillis());
    }

    // запишем время, когда закончился каждый тест
    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    @DisplayName(value = "GET_COUNT_TEST")
    public void getCountOfIncomesThatGreaterTest(){

        int result = statsService.getCountOfIncomesThatGreater(BigDecimal.valueOf(10000));
        Assertions.assertEquals(0, result);

    }


}
