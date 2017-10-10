package com.giacom.jms.server;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@MessageDriven(name = JMSIntegrationQueueMDBBean.JNDI_REMOTE_NAME, mappedName = JMSIntegrationQueueMDBBean.JNDI_REMOTE_NAME, activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSIntegrationQueueMDBBean"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class JMSIntegrationQueueMDBBean implements MessageListener {

	public static final String JNDI_REMOTE_NAME = "jms/JMSIntegrationQueueMDBBean";

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void onMessage(Message message) {

		System.out.println("*** JMSIntegrationQueueMDBBean onMessage: \n");

		if (message instanceof ObjectMessage) {
			ObjectMessage objMessage = (ObjectMessage) message;
			try {
				System.out.println("ObjectMessage :" + objMessage.getObject().toString());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else if (message instanceof TextMessage) {
			TextMessage txtMessage = (TextMessage) message;
			try {
				System.out.println("TextMessage :" + txtMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}
}