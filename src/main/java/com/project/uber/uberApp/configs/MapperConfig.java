package com.project.uber.uberApp.configs;

import com.project.uber.uberApp.dto.PointDto;
import com.project.uber.uberApp.entities.RideRequest;
import com.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.project.uber.uberApp.strategies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.project.uber.uberApp.strategies.impl.DriverMatchingNearestDriverStrategy;
import com.project.uber.uberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
                    PointDto pointDto = context.getSource();
                    return GeometryUtil.createPoint(pointDto);
                });

        mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
            return new PointDto(coordinates);
        });
        return mapper;
    }
}
