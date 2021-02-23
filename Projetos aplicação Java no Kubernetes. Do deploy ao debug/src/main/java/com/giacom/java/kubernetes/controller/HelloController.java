package com.giacom.java.kubernetes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/hello")
public class HelloController { //Controller do bem vindo
    @GetMapping
    //Frase do diretório inicial
    public String sayHello() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("Your current host/IP address : " + ip);
        return "Hello " + ip;
    }
}
