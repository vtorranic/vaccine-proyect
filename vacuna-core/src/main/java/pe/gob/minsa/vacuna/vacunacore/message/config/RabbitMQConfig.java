package pe.gob.minsa.vacuna.vacunacore.message.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.gob.minsa.vacuna.vacunacore.message.listener.CitasMQListener;


@Configuration
public class RabbitMQConfig {

	@Value("${citas.rabbitmq.queue}")
	String queueName;
	

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory ) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		simpleMessageListenerContainer.setQueues(queue());
		simpleMessageListenerContainer.setMessageListener(new CitasMQListener());
		return simpleMessageListenerContainer;

	}
    
    
	
}
