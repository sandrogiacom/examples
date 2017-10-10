# sudo docker rm wildfly-jms
# sudo docker rmi wildfly/hellojms
# sudo docker build -t wildfly/hellojms . && sudo docker run --name wildfly-jms -p 8080:8080 wildfly/hellojms

FROM jboss/wildfly

ADD application-roles.properties /opt/jboss/wildfly/standalone/configuration
ADD application-users.properties /opt/jboss/wildfly/standalone/configuration
ADD mgmt-groups.properties /opt/jboss/wildfly/standalone/configuration
ADD mgmt-users.properties /opt/jboss/wildfly/standalone/configuration
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration
ADD wildfly-helloworld-jms-server-0.0.1-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/wildfly-helloworld-jms-server.jar
