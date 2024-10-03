package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name")//exchange do tipo default: chave routing key
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDto(
                userModel.getUserId(),
                userModel.getEmail(),
                "Cadastro Realizado com Sucesso!",
                userModel.getEmail() + "seja bem vindo(a)! \n Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!"
        );

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }

}
