package ru.rutmiit.salescatalog.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rutmiit.salescatalog.dtos.*;
import ru.rutmiit.salescatalog.entity.enumeration.CategoryType;
import ru.rutmiit.salescatalog.entity.enumeration.EngineType;
import ru.rutmiit.salescatalog.entity.enumeration.RoleType;
import ru.rutmiit.salescatalog.entity.enumeration.TransmissionType;
import ru.rutmiit.salescatalog.services.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class DataInitializer implements CommandLineRunner {
    @Override
    public void run(String... args){
        seedData();
    }

    @Autowired
    private UserRoleService roleService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private UserService usersService;
    @Autowired
    private OfferService offerService;

    private void seedData() {
        UserRoleDto role1 = new UserRoleDto(null, RoleType.ADMIN);
        UserRoleDto role2 = new UserRoleDto(null, RoleType.USER);
        role1 = roleService.register(role1);
        role2 = roleService.register(role2);

        Timestamp created1 = Timestamp.from(Instant.now());
        Timestamp created2 = Timestamp.from(Instant.now());
        Timestamp modified1 = Timestamp.from(Instant.now());
        Timestamp modified2 = Timestamp.from(Instant.now());
        BrandDto brand1 = new BrandDto(null, "BMW", created1, modified1);
        BrandDto brand2 = new BrandDto(null, "Mersedes", created2, modified2);
        brand1 = brandService.register(brand1);
        brand2 = brandService.register(brand2);

        ModelDto model1 = new ModelDto(null, brand2, "EQS", CategoryType.Car, "http://jbjefbwjbf",
                2018, 2023, created1, modified2);
        ModelDto model2 = new ModelDto(null, brand1, "S1000RR", CategoryType.Motorcycle, "http://hbehbfh",
                2008, 2014, created2, modified2);
        model1 = modelService.register(model1);
        model2 = modelService.register(model2);

        UserDto user1 = new UserDto(null, role1, "Viatly228", "123456789", "Vitaly",
                "Irvanev", true, "http://jjejfbejbf", created1, modified1);
        UserDto user2 = new UserDto(null, role2, "AngryL1on", "0987654321", "Vadim",
                "Lushin", true, "http://bebfebufbe", created2, modified2);
        user1 = usersService.register(user1);
        user2 = usersService.register(user2);

        BigDecimal price1 = new BigDecimal(24000000);
        BigDecimal price2 = new BigDecimal(3150000);

        OfferDto offer1 = new OfferDto(null, model1, user2, "Cool car", EngineType.ELECTRIC,
                "http://uebubfueb", 20, price1, TransmissionType.AUTOMATIC, 2022, created1, modified2);
        OfferDto offer2 = new OfferDto(null, model2, user1, "Cool Motorcycle", EngineType.GASOLINE,
                "http://hewbfhbvehf", 2, price2, TransmissionType.AUTOMATIC, 2022, created2, modified2);
        offerService.register(offer1);
        offerService.register(offer2);
    }
}
