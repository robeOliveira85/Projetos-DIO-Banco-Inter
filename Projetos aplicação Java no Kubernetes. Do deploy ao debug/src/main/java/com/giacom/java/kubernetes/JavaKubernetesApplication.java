package com.giacom.java.kubernetes;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giacom.java.kubernetes.domain.User;
import com.giacom.java.kubernetes.persistence.UserRepository;
import com.giacom.java.kubernetes.service.UserService;

@SpringBootApplication
public class JavaKubernetesApplication {

    @Autowired
    private UserService service; //Serviço do usuário

    @Autowired
    private UserRepository repository; //Serviço do repositório do usuário

    //Inicia a aplicação
    public static void main(String[] args) {
        SpringApplication.run(JavaKubernetesApplication.class, args);
    }

    @PostConstruct
    public void checkIfWorks() {
        //Deletar todos os registros
        repository.deleteAll();

        //Adiciona 2 usuários
        service.create(new User("Minikube",
                LocalDate.of(2006, 10, 01)));
        service.create(new User("Kubectl",
                LocalDate.of(1999, 05, 15)));

        //Lista todos os usuários do banco de dados no console
        List<User> findAll = service.findAll();
        for (User user : findAll) {
            System.out.println(user.getId() + ":" + user.getName());
        }

    }

}
