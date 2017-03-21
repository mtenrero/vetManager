package es.urjc.etsii.mtenrero;

import es.urjc.etsii.mtenrero.Entities.Appointment;
import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Repositories.AppointmentRepository;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootApplication
public class VetmanagerApplication extends SpringBootServletInitializer {

	@Autowired
	static
	ClientRepository clientRepository;


    @Autowired
    static
    AppointmentRepository appointmentRepository;



    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VetmanagerApplication.class);
	}

	public static String appName = "VetManager";

	public static void main(String[] args) {
		SpringApplication.run(VetmanagerApplication.class, args);

		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
			    System.out.print("HOOOOLA");
				List<Appointment> appointments = 			    appointmentRepository.findAll();

				Comunication comunication = new Comunication();
                try {
                    comunication.send("","","asd");
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                for (Appointment appointment : appointments) {
//                    LocalDate dateBefore;
//                    LocalDate dateAfter appointment.g;
//                    long daysBetween = HOURS.between(dateBefore, dateAfter);
//                    //if (client.getHoursBeforeNotification())
//                }


            }
		}, 0, 1, TimeUnit.DAYS);
	}
}
