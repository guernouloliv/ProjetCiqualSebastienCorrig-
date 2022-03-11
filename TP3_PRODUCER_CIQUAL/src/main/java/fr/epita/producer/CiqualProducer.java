package fr.epita.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class CiqualProducer {

	public void sendCiqualMessage(String message) {
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

		Connection connection;
		try {
			connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			TextMessage msg = session.createTextMessage(message);
			Destination queue = session.createQueue("queue_CIQUAL");
			MessageProducer producer = session.createProducer(queue);
			producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
