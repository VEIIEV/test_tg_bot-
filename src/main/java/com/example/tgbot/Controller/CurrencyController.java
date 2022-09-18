package com.example.tgbot.Controller;


import com.example.tgbot.DTO.ValuteCursOnDate;
import com.example.tgbot.service.CentralRussianBankService;
import com.example.tgbot.service.StatsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
@AllArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @PostMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();

    }

    @GetMapping("/savecurrency")
    public String getValuteCursOnDateToFile() throws Exception{


        final Path ProjectPath = Paths.get("C:\\\\Users\\\\world\\\\OneDrive\\\\Рабочий стол\\\\tgbot\\\\src\\\\stash\\\\file.xml");
        String result=centralRussianBankService.getCurrenciesFromCbr().stream().map(obj ->
                obj.toString()).collect(Collectors.joining("\n"));
        //Desktop
        try {
            Files.write(ProjectPath,  result.getBytes());
            System.out.println(" записан file.xml");
            Logger logger= LoggerFactory.getLogger("logger");
            logger.info("записан file.xml ");

            //System.out.println(Files.readString(ProjectPath));
        }
        catch (AccessDeniedException e)
        {
            Logger logger= LoggerFactory.getLogger("logger");
            logger.warn("путь к файлу записан неправильно ");
            logger.trace(e.toString());
            return "хуйня какая-то";
        }
        return "всё чики пики";
    }

    //получание количства пополнений которые превышают определенную сумму
    @GetMapping("/getStats")

    public int getStatsAboutIncomesThatGreater(@RequestParam(value= "amount") BigDecimal amount){
        return  statsService.getCountOfIncomesThatGreater(amount);
    }
}