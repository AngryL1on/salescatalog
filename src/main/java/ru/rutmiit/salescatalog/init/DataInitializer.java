package ru.rutmiit.salescatalog.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rutmiit.salescatalog.entity.enumeration.CategoryType;
import ru.rutmiit.salescatalog.entity.enumeration.EngineType;
import ru.rutmiit.salescatalog.entity.enumeration.RoleType;
import ru.rutmiit.salescatalog.entity.enumeration.TransmissionType;
import ru.rutmiit.salescatalog.services.*;
import ru.rutmiit.salescatalog.services.dtos.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final UserService userService;
    private final UserRoleService userRoleService;

    public DataInitializer(BrandService brandService, ModelService modelService, OfferService offerService, UserService userService, UserRoleService userRoleService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public void run(String... args){
        seedData();
    }

    private void seedData() {
        UserRoleDto role1 = new UserRoleDto(null, RoleType.ADMIN);
        UserRoleDto role2 = new UserRoleDto(null, RoleType.USER);
        role1 = userRoleService.addUserRole(role1);
        role2 = userRoleService.addUserRole(role2);

        LocalDateTime created1 = LocalDateTime.now();
        LocalDateTime created2 = LocalDateTime.now();
        LocalDateTime created3 = LocalDateTime.now();
        LocalDateTime modified1 = LocalDateTime.now();
        LocalDateTime modified2 = LocalDateTime.now();
        LocalDateTime modified3 = LocalDateTime.now();
        BrandDto brand1 = new BrandDto(null, "Mitsubishi", created1, modified1);
        BrandDto brand2 = new BrandDto(null, "Toyota", created2, modified2);
        BrandDto brand3 = new BrandDto(null, "Nissan", created3, modified3);
        brand1 = brandService.addBrand(brand1);
        brand2 = brandService.addBrand(brand2);
        brand3 = brandService.addBrand(brand3);

        ModelDto model1 = new ModelDto(null, brand1, "Lanser X", CategoryType.CAR, "http://fawjjekjaw",
                2018, 2023, created1, modified2);
        ModelDto model2 = new ModelDto(null, brand2, "MARK II", CategoryType.MOTORCYCLE, "http://djakwj",
                2008, 2014, created2, modified2);
        ModelDto model3 = new ModelDto(null, brand3, "Skyline R34", CategoryType.MOTORCYCLE, "http://fdsjbfjksd",
                2008, 2014, created2, modified2);
        model1 = modelService.addModel(model1);
        model2 = modelService.addModel(model2);
        model3 = modelService.addModel(model3);

        UserDto user1 = new UserDto(null, role1, "ReaperParadise", "123456789", "Egor",
                "Linyaev", true, "http://fbsehjfbks", created1, modified1);
        UserDto user2 = new UserDto(null, role1, "AngryL1on", "0987654321", "Vadim",
                "Lushin", true, "http://fgjhwegfj", created2, modified2);
        UserDto user3 = new UserDto(null, role2, "Toksin or ToksGaz", "987656789", "Nikita",
                "Lazarenko", true, "http://fhsehfkse", created3, modified3);
        user1 = userService.addUser(user1);
        user2 = userService.addUser(user2);
        user3 = userService.addUser(user3);

        BigDecimal price1 = new BigDecimal(24000000);
        BigDecimal price2 = new BigDecimal(3150000);
        BigDecimal price3 = new BigDecimal(10000000);

        OfferDto offer1 = new OfferDto(null, model1, user2, "Cool car", EngineType.GASOLINE,
                "http://uebubfueb", 20, price1, TransmissionType.AUTOMATIC, 2023, created1, modified2);
        OfferDto offer2 = new OfferDto(null, model2, user1, "Cool Motorcycle", EngineType.GASOLINE,
                "http://hewbfhbvehf", 2, price2, TransmissionType.AUTOMATIC, 2023, created2, modified2);
        OfferDto offer3 = new OfferDto(null, model3, user3, "Cool Motorcycle", EngineType.GASOLINE,
                "http://hcsjzkhckjz", 2, price3, TransmissionType.AUTOMATIC, 2023, created2, modified3);
        offerService.addOffer(offer1);
        offerService.addOffer(offer2);
        offerService.addOffer(offer3);
    }
}
