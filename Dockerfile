FROM java:8

MAINTAINER Marcos Tenrero <m.tenrero@alumnos.urjc.es>

WORKDIR /tmp

EXPOSE 8443

ADD target/vetmanager-0.0.1-SNAPSHOT.jar /tmp/app.jar
ADD keystore.p12 /tmp/keystore.p12
ADD za.store /tmp/za.store
RUN bash -c 'touch /tmp/app.jar'

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /tmp/app.jar" ]