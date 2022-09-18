package com.example.tgbot;

import com.example.tgbot.repository.IncomeRepository;
import com.example.tgbot.repository.SpendRepository;
import com.example.tgbot.service.FinanceService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * �����-���� ��� ������������ FinanceService
 */
// ���������, ��� ���� ����� - ��������, ��� ����������� SpringBoot
@SpringBootTest
// ���������, ��� ������� ����� �������� �� ���� ����� (�.�. ��� ��������� ���� �������)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinanceServiceTests {

    // ���������� ������ ������� � ����������, ������� ��������� ������
    // � �������� �������� ������ ������������,
    // ��� ��� � ������ �� ��� ��������� ����������������, � ������ � �����
    @InjectMocks
    private FinanceService financeService;

    // ���������, ��� ���� ����� ���� ����������� (�� ������������ � FinanceService)
    @Mock
    private SpendRepository spendRepository;

    // ���������, ��� ���� ����� ���� ����������� (�� ������������ � FinanceService)
    @Mock
    private IncomeRepository incomeRepository;

    // ������� �����, ����� ������� ������ ����
    @BeforeEach
    public void beforeAll() {
        System.out.println(System.currentTimeMillis());
    }

    // ������� �����, ����� ���������� ������ ����
    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }

    // �������� ����� ��� ������� �����
    @DisplayName("ADD_INCOME_test")
    @Test
    public void addFinanceOperationAddIncomeTest() {
        // ���������� ������������ �������� ���������� ��� �������� � �����
        String price = "150.0";
        // ���������� � ������ � ������������� ����������� � ��������� ��������� � ����������
        String message = financeService.addFinanceOperation("/addincome", price, 500L);
        // ����������, ��� �������� ��������� ���������
        Assertions.assertEquals("����� � ������� " + price + " ��� ������� ��������", message);
    }

    // �������� ����� ��� ������� �����, �� ���������� �������, �� � ������� �����������
    @DisplayName("non_ADD_INCOME_test")
    @Test
    public void addFinanceOperationElseBranchTest() {
        // ����� ��� �������� ����������
        String price = "200";
        // ����� ���������� � ������ � ������� �����������
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        // ����������, ��� �������� ��������� ���������
        Assertions.assertEquals("������ � ������� " + price + " ��� ������� ��������", message);
    }
}