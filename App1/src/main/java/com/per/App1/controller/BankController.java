package com.per.App1.controller;

import com.per.App1.domain.Bank;
import com.per.App1.domain.User;
import com.per.App1.service.BankService;
import com.per.App1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/listOfBanks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bank> getListOfBanks(@RequestHeader(value="userName") String userName) {

        List<Bank> listOfBanks = new ArrayList<Bank>();
        if (userService.checkUsernameExists(userName)) {

                listOfBanks = bankService.findBanksList();
                return listOfBanks;
        }
        return listOfBanks;

    }

    @RequestMapping(value = "/metadataOfBank", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String,String> getMetadataOfBanks(@RequestHeader(value="userName") String userName) {

        HashMap<String,String> metadata = new HashMap<>();
        if (userService.checkUsernameExists(userName)) {

            metadata.put("1","click on bank will redirect to respective bank home page");
            metadata.put("2","click on login button.");
            metadata.put("3","If already having login credentials, enter the user credentials and login");
            metadata.put("4","If don't have login credentials, click on 'Register NewUser'");
            metadata.put("5","provide the mandatory fields and click on register button.");
            metadata.put("6","On successful login user will redirect to login screen");
            return metadata;
        }
        return metadata;

    }

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAccounts(@RequestHeader(value="userName") String userName,
                              @RequestBody HashMap<String,String> app2Values
                              ) throws RestClientException, IOException {

        if (userService.checkUsernameExists(userName)) {
            String baseUrl = "http://localhost:8070/bank/getAccount";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response=null;
            try{
                response=restTemplate.exchange(baseUrl,HttpMethod.POST, getHeaders(app2Values.get("bankId"),app2Values.get("app2UserName"),app2Values.get("app2Password")),String.class);
            }catch (Exception ex)
            {
                System.out.println(ex);
            }
            return response.getBody();
        }
        return null;

    }

    private static HttpEntity<?> getHeaders(String bankId, String userName, String password) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("bankId", bankId);
        headers.set("userName", userName);
        String plainClientCredentials=userName+":"+password;
        String base64ClientCredentials = new String(Base64.getEncoder().encodeToString(plainClientCredentials.getBytes()));
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        return new HttpEntity<>(headers);
    }
}