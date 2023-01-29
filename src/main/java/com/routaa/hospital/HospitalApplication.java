package com.routaa.hospital;

import com.routaa.hospital.bl.expertise.repository.service.ExpertiseService;
import com.routaa.hospital.bl.hospital.repository.service.HospitalService;
import com.routaa.hospital.entity.DoctorEntity;
import com.routaa.hospital.entity.ExpertiseEntity;
import com.routaa.hospital.entity.HospitalEntity;
import com.routaa.hospital.entity.HospitalExpertiseEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication(scanBasePackages = "com.routaa.hospital")
@EnableTransactionManagement
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}

