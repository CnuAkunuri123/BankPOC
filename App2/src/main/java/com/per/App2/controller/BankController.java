package com.per.App2.controller;


import com.per.App2.domain.Bank;
import com.per.App2.domain.User;
import com.per.App2.service.BankService;
import com.per.App2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bank> getListOfBanks(@RequestHeader(value="bankId") String bankId,
                                     @RequestHeader(value="userName") String userName) {

        List<Bank> listOfBanks = new ArrayList<Bank>();
        if (userService.checkUsernameExists(userName)) {
            User user = userService.findByUsername(userName);

            listOfBanks = bankService.findAll().stream()
                    .filter(bank -> bank.getBankId().toString().equals(bankId))
                    .filter(bank -> bank.getUserId().toString().equals(user.getUserId().toString()))
                    .collect(Collectors.toList());

            return listOfBanks;
        }
        return listOfBanks;
    }


}

