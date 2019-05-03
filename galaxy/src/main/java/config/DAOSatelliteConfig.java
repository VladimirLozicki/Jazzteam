package config;

import DAO.DAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOSatelliteConfig {

    @Bean
    public DAO getDAO(){
        return new DAO();
    }
}
