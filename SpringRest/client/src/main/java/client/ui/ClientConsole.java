package client.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import web.dto.ChocolateDto;
import web.dto.ProductionLotDto;
import web.dto.ProductionLotsDto;
import web.dto.ChocolatesDto;

import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.exit;

@Component
public class ClientConsole {
    private final String chocolateURL = "http://localhost:8080/test/api/chocolates";

    private final String urlProdLot = "http://localhost:8080/test/api/productionLots";

    @Autowired
    private RestTemplate restTemplate;

    public void runConsole() {
        mainMenu();
    }

    private void mainMenu(){
        System.out.println("Menu:");
        System.out.println("1. Operations on employee repository!");
        System.out.println("2. Operations on chocolate repository!");
        System.out.println("3. Operations on production lot repository!");
        System.out.println("4. Operations on registry repository!");
        System.out.println("0. Exit.");

        optionMainMenu();
    }


    private static int getUserOption(){
        try {
            System.out.println("\nGive an option:");
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            return option;
        }
        catch (InputMismatchException exception){
            System.out.println("Please give a valid option!");
        }
        return getUserOption();
    }

    private void optionMainMenu(){
        try {
            int option = getUserOption();
            switch (option){
                case 0:
                    System.out.println("Bye!");
                    exit(0);
                    return;
                case 1:
                    //employeeMenu();
                    break;
                case 2:
                    chocolateMenu();
                    break;
                case 3:
                    productionLotMenu();
                    break;
                case 4:
                    //registryMenu();
                    break;
                default:
                    System.out.println("No such option! Try again!");
            }
            optionMainMenu();
        }
        catch (Exception exception){
            System.out.println("Something went wrong here: " + exception);
        }
    }

    private void chocolateMenu(){
        System.out.println("\nOperations on chocolate repository:");
        System.out.println("\t1. Print all chocolates.");
        System.out.println("\t2. Add a chocolate.");
        System.out.println("\t3. Delete a chocolate.");
        System.out.println("\t4. Update a chocolate.");
        System.out.println("\t5. Find a chocolate by ID.");
        System.out.println("\t6. Filter chocolates by name.");
        System.out.println("\t7. Filter chocolates by weight.");
        System.out.println("\t8. Filter chocolates by price.");
        System.out.println("\t0. Back.");

        optionChocolateMenu();
    }

    private void optionChocolateMenu(){
        try {
            int option = getUserOption();
            switch (option){
                case 0:
                    mainMenu();
                    break;
                case 1:
                    printAllChocolates();
                    break;
                case 2:
                    addChocolate();
                    break;
                case 3:
                    deleteChocolate();
                    break;
                case 4:
                    updateChocolate();
                    break;
                case 5:
                   // findChocolateById();
                    break;
                case 6:
//                    filterChocolatesByName();
                    break;
                case 7:
//                    filterChocolatesByWeight();
                    break;
                case 8:
//                    filterChocolatesByPrice();
                    break;
                default:
                    System.out.println("No such option! Try again!");
            }
            chocolateMenu();
        }
        catch (Exception exception){
            System.out.println("Something went wrong yikes: " + exception);
        }
    }

//    private void findChocolateById() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//            CompletableFuture<Chocolate> future = factoryService.findChocolateById(id);
//            future.thenAccept(it -> {
//                if (it.getId().equals(id)) {
//                    System.out.println("Chocolate found" + it);
//                } else {
//                    System.out.println("Chocolate not found!");
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private void filterChocolatesByPrice() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nPrice: ");
//            double price = scan.nextDouble();
//            System.out.println("\nChocolates filtered by price:");
//            CompletableFuture<List<Chocolate>> futureChocolateList = factoryService.filterByPrice(price);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No chocolate matches the price provided");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void filterChocolatesByWeight() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nWeight: ");
//            double weight = scan.nextDouble();
//            System.out.println("\nChocolates filtered by weight:");
//            CompletableFuture<List<Chocolate>> futureChocolateList = factoryService.filterByWeight(weight);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No chocolate matches the weight provided");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void filterChocolatesByName() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nName: ");
//            String name = scan.next();
//            System.out.println("\nChocolates filtered by name:");
//            CompletableFuture<List<Chocolate>> futureChocolateList = factoryService.filterByName(name);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No chocolate matches the name provided");
//                }
//                else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    private void updateChocolate() {
        try {
            Scanner scan = new Scanner(System.in).useDelimiter("\\n");
            System.out.println("\nGive an ID: ");
            Long id = scan.nextLong();
            System.out.println("\nName: ");
            String name = scan.next();
            System.out.println("\nIngredients: ");
            String ingredients = scan.next();
            System.out.println("\nWeight: ");
            double weight = scan.nextDouble();
            System.out.println("\nPrice: ");
            double price = Double.parseDouble(scan.next());
            ChocolateDto chocolateDto = new ChocolateDto(name, ingredients, weight, price);
            chocolateDto.setId(id);
            restTemplate.put(chocolateURL + "/{id}", chocolateDto, chocolateDto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteChocolate() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nGive the ID:");
            Long id = scan.nextLong();
            restTemplate.delete(chocolateURL + "/{id}", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addChocolate() {
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("\nGive an ID: ");
        Long id = scan.nextLong();
        System.out.println("\nName: ");
        String name = scan.next();
        System.out.println("\nIngredients: ");
        String ingredients = scan.next();
        System.out.println("\nWeight: ");
        double weight = Double.parseDouble(scan.next());
        System.out.println("\nPrice: ");
        double price = Double.parseDouble(scan.next());
        ChocolateDto chocolateDto = new ChocolateDto(name, ingredients, weight, price);
        chocolateDto.setId(id);
        ChocolateDto savedChocolate = restTemplate.postForObject(chocolateURL, chocolateDto, ChocolateDto.class);
        System.out.println(savedChocolate);
    }

    private void printAllChocolates() {
        System.out.println(restTemplate.getForObject(chocolateURL, ChocolatesDto.class));
    }

//    //employee
//    private void employeeMenu() {
//        System.out.println("\nOperations on employee repository:");
//        System.out.println("\t1. Print all employees.");
//        System.out.println("\t2. Add an employee.");
//        System.out.println("\t3. Delete an employee.");
//        System.out.println("\t4. Update an employee.");
//        System.out.println("\t5. Find an employee by ID.");
//        System.out.println("\t6. Filter employees by name.");
//        System.out.println("\t7. Filter employees by birth date.");
//        System.out.println("\t8. Filter employees by salary.");
//        System.out.println("\t9. Get employees with biggest salary.");
//        System.out.println("\t0. Back.");
//
//        optionEmployeeMenu();
//    }
//
//    private void optionEmployeeMenu(){
//        try {
//            int option = getUserOption();
//            switch (option){
//                case 0:
//                    mainMenu();
//                    break;
//                case 1:
//                    printAllEmployees();
//                    break;
//                case 2:
//                    addEmployee();
//                    break;
//                case 3:
//                    deleteEmployee();
//                    break;
//                case 4:
//                    updateEmployee();
//                    break;
//                case 5:
//                    findEmployeeByID();
//                    break;
//                case 6:
//                    filterEmployeesByName();
//                    break;
//                case 7:
//                    filterEmployeesByBirthDate();
//                    break;
//                case 8:
//                    filterEmployeesBySalary();
//                    break;
//                case 9:
//                    getEmployeeBiggestSalary();
//                    break;
//                default:
//                    System.out.println("No such option! Try again!");
//            }
//            sleep(20);
//            employeeMenu();
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void printAllEmployees() {
//        try {
//            CompletableFuture<List<Employee>> futureChocolateList = factoryService.getAllEmployees();
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No employee in the database!");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void addEmployee() {
//        try {
//            Scanner scan = new Scanner(System.in).useDelimiter("\\n");
//            System.out.println("\nGive an ID:");
//            Long id = scan.nextLong();
//            System.out.println("\nGive the name:");
//            String name = scan.next();
//            System.out.println("\nGive the date (dd/mm/yyyy):");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            String dateS = scan.next();
//            LocalDate date = LocalDate.parse(dateS, formatter);
//            System.out.println("\nGive the salary:");
//            Integer salary = scan.nextInt();
//            Employee employee = new Employee(name, date, salary);
//            employee.setId(id);
//
//            CompletableFuture<Employee> future = factoryService.addEmployee(employee);
//            future.thenAccept(it -> {
//                if (it.equals(employee)) {
//                    System.out.println("The employee was added!");
//                } else {
//                    System.out.println("Employee not added!");
//                }
//            });
//        } catch (ChocolateFactoryException e) {
//            System.out.println("Something went wrong: " + e);
//        }
//    }
//
//    private void deleteEmployee() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//
//            CompletableFuture<String> future = factoryService.deleteEmployee(id);
//            future.thenAccept(it -> {
//                if (it.equals("Employee not deleted!")) {
//                    System.out.println("The employee was not deleted!");
//                } else {
//                    System.out.println("Employee deleted!");
//                }
//            });
//
//        } catch (Exception e) {
//            System.out.println("Something went wrong: " + e);
//        }
//    }
//
//    private void updateEmployee() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//            System.out.println("\nGive the name:");
//            String name = scan.next();
//            System.out.println("\nGive the date (dd/mm/yyyy):");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            String dateS = scan.next();
//            LocalDate date = LocalDate.parse(dateS, formatter);
//            System.out.println("\nGive the salary:");
//            Integer salary = scan.nextInt();
//            Employee employee = new Employee(name, date, salary);
//            employee.setId(id);
//
//            CompletableFuture<Employee> future = factoryService.updateEmployee(employee);
//            future.thenAccept(it -> {
//                if (it.equals(employee)) {
//                    System.out.println("The employee was updated!");
//                } else {
//                    System.out.println("Employee not updated!");
//                }
//            });
//        } catch (Exception e) {
//            System.out.println("Something went wrong: " + e);
//        }
//    }
//
//    private void findEmployeeByID() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//
//            CompletableFuture<Employee> futureChocolateList = factoryService.findOneEmployee(id);
//            futureChocolateList.thenAccept(it -> {
//                if (it.getId().equals(id)) {
//                    System.out.println("Employee with id " + id + " found!");
//                } else {
//                    System.out.println("Employee with id " + id + " not found!");
//                }
//            });
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void filterEmployeesByName() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the name:");
//            String name = scan.next();
//
//            CompletableFuture<List<Employee>> futureChocolateList = factoryService.filterEmployeesByName(name);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No employee matches the name provided!");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void filterEmployeesByBirthDate() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the date (dd/mm/yyyy):");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            String dateS = scan.next();
//            LocalDate date = LocalDate.parse(dateS, formatter);
//
//            CompletableFuture<List<Employee>> futureChocolateList = factoryService.filterEmployeesByBirthDate(date);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No employee matches the birth date provided!");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void filterEmployeesBySalary() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the salary:");
//            Integer salary = scan.nextInt();
//
//            CompletableFuture<List<Employee>> futureChocolateList = factoryService.filterEmployeesBySalary(salary);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No employee matches the salary provided!");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    private void getEmployeeBiggestSalary() {
//        try {
//            CompletableFuture<List<Employee>> futureChocolateList = factoryService.getEmployeeBiggestSalary();
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No employee in the database!");
//                } else {
//                    it.forEach(System.out::println);
//                }
//            });
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong: " + exception);
//        }
//    }
//
//    // REGISTRY
//
//    private void registryMenu(){
//        System.out.println("\nOperations on registry repository:");
//        System.out.println("\t1. Print all registries.");
//        System.out.println("\t2. Add a registry.");
//        System.out.println("\t3. Delete a registry.");
//        System.out.println("\t4. Update a registry.");
//        System.out.println("\t5. Find a registry by ID.");
//        System.out.println("\t6. Filter registry by productionLotID.");
//        System.out.println("\t7. Filter registry by employeeID.");
//        System.out.println("\t8. Filter registry by date.");
//        System.out.println("\t0. Back.");
//
//        optionRegistryMenu();
//    }
//
//    private void optionRegistryMenu(){
//        try {
//            int option = getUserOption();
//            switch (option){
//                case 0:
//                    mainMenu();
//                    break;
//                case 1:
//                    printAllRegistries();
//                    break;
//                case 2:
//                    addRegistry();
//                    break;
//                case 3:
//                    deleteRegistry();
//                    break;
//                case 4:
//                    updateRegistry();
//                    break;
//                case 5:
//                    findRegistryByID();
//                    break;
//                case 6:
//                    filterRegistryByProductionLotID();
//                    break;
//                case 7:
//                    filterRegistryByEmployeeID();
//                    break;
//                case 8:
//                    filterRegistryByDate();
//                    break;
//                default:
//                    System.out.println("No such option! Try again!");
//            }
//            registryMenu();
//        }
//        catch (Exception exception){
//            System.out.println("Something went wrong yikes: " + exception);
//        }
//    }
//
//    private void findRegistryByID() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//            CompletableFuture<Registry> future = factoryService.findOneRegistry(id);
//            future.thenAccept(it -> {
//                if (it.getId().equals(id)) {
//                    System.out.println("Registry found" + it);
//                } else {
//                    System.out.println("Registry not found!");
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void filterRegistryByDate() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nDate: ");
//            String date = scan.next();
//            System.out.println("\nRegistry filtered by date:");
//            CompletableFuture<List<Registry>> futureChocolateList = factoryService.filterRegistryByDate(date);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No registry matches the date provided");
//                }
//                else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void filterRegistryByEmployeeID() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nEmployeeID: ");
//            int employeeID = scan.nextInt();
//            System.out.println("\nRegistry filtered by employeeID:");
//            CompletableFuture<List<Registry>> futureChocolateList = factoryService.filterRegistryByEmployeeID(employeeID);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No registry matches the employeeID provided");
//                }
//                else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void filterRegistryByProductionLotID() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nProductionLotID: ");
//            int productionLotID = scan.nextInt();
//            System.out.println("\nRegistry filtered by productionLotID:");
//            CompletableFuture<List<Registry>> futureChocolateList = factoryService.filterRegistryByProductionLotID(productionLotID);
//            futureChocolateList.thenAccept(it -> {
//                if (it.isEmpty()) {
//                    System.out.println("No registry matches the productionLotID provided");
//                }
//                else {
//                    it.forEach(System.out::println);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void updateRegistry() {
//        try {
//            Scanner scan = new Scanner(System.in).useDelimiter("\\n");
//            System.out.println("\nGive an ID: ");
//            Long id = scan.nextLong();
//            System.out.println("\nProductionLotID: ");
//            int productionLotID = scan.nextInt();
//            System.out.println("\nEmployeeID: ");
//            int employeeID = scan.nextInt();
//            System.out.println("\nDate: ");
//            String date = scan.next();
//            Registry c = new Registry(productionLotID, employeeID, date);
//            c.setId(id);
//            CompletableFuture<Registry> future = factoryService.updateRegistry(c);
//            future.thenAccept(it -> {
//                if (it.equals(c)) {
//                    System.out.println("The registry was not updated");
//                } else {
//                    System.out.println("Registry updated");
//                }
//            });
//        } catch (ChocolateFactoryException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void deleteRegistry() {
//        try {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("\nGive the ID:");
//            Long id = scan.nextLong();
//            CompletableFuture<String> future = factoryService.deleteRegistry(id);
//            future.thenAccept(it -> {
//                if (it.equals("Registry not deleted!")) {
//                    System.out.println("Registry was not deleted");
//                } else {
//                    System.out.println("Registry deleted");
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void addRegistry() {
//        try {
//            Scanner scan = new Scanner(System.in).useDelimiter("\\n");
//            System.out.println("\nGive an ID: ");
//            Long id = scan.nextLong();
//            System.out.println("\nProductionLotID: ");
//            int productionLotID = scan.nextInt();
//            System.out.println("\nEmployeeID: ");
//            int employeeID = scan.nextInt();
//            System.out.println("\nDate: ");
//            String date = scan.next();
//            Registry c = new Registry(productionLotID, employeeID, date);
//            c.setId(id);
//
//
//            CompletableFuture<Registry> future = factoryService.addRegistry(c);
//
//            future.thenAccept(it -> {
//                if (it.equals(c)) {
//                    System.out.println("Registry added");
//                } else {
//                    System.out.println("The registry was not added, already in repo");
//                }
//            });
//        } catch (Exception e) {
//            System.out.println("The registry introduced is already in the repo" + e);
//        }
//    }
//
//    private void printAllRegistries() throws InterruptedException {
//        System.out.println(factoryService.getAllRegistries());
//    }
//
//
//
    private void productionLotMenu(){
        System.out.println("\nOperations on production lot repository:");
        System.out.println("\t1. Print all production lots.");
        System.out.println("\t2. Add production lot.");
        System.out.println("\t3. Delete production lot.");
        System.out.println("\t4. Update production lot.");
        System.out.println("\t5. Find production lot by ID .");
        System.out.println("\t6. Filter production lots by chocolateID.");
        System.out.println("\t7. Filter production lots by quantity.");
        System.out.println("\t8. Filter production lots by productionDate.");
        System.out.println("\t9. Filter production lots by expirationDate.");
        System.out.println("\t0. Back.");

        optionProductionLotMenu();
    }

    private void optionProductionLotMenu(){
        try {
            int option = getUserOption();
            switch (option){
                case 0:
                    mainMenu();
                    break;
                case 1:
                    printAllProductionLots();
                    break;
                case 2:
                    addProductionLot();
                    break;
                case 3:
                    deleteProductionLot();
                    break;
                case 4:
                    updateProductionLot();
                    break;
                case 5:
                    findProductionLotByID();
                    break;
                case 6:
                    filterProductionLotByChocolateID();
                    break;
                case 7:
                    filterProductionLotByQuantity();
                    break;
                case 8:
                    filterProductionLotByProductionDate();
                    break;
                case 9:
                    filterProductionLotByExpirationDate();
                    break;
                default:
                    System.out.println("No such option! Try again!");
            }
            productionLotMenu();
        }
        catch (Exception exception){
            System.out.println("Something went wrong: " + exception);
        }
    }

    private void printAllProductionLots() {
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void filterProductionLotByChocolateID() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChocolateID: ");
        int id = scan.nextInt();
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot + "/filterByChocoID/" + id, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void filterProductionLotByQuantity() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nQuantity: ");
        int quantity = scan.nextInt();
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot + "/filterByQuantity/" + quantity, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void filterProductionLotByProductionDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nProduction Date: ");
        String productionDate = scan.next();
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot + "/filterByProductionDate/" + productionDate, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void filterProductionLotByExpirationDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nExpiration Date: ");
        String expirationDate = scan.next();
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot + "/filterByExpirationDate/" + expirationDate, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void findProductionLotByID() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nID: ");
        Long id = scan.nextLong();
        ProductionLotsDto productionLotsDto = restTemplate.getForObject(urlProdLot + "/findOne/" + id, ProductionLotsDto.class);
        System.out.println(PINK_BRIGHT + productionLotsDto);
    }

    private void updateProductionLot() {
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("\nGive an ID: ");
        Long id = scan.nextLong();
        System.out.println("\nChocolate ID: ");
        int chocoID = Integer.parseInt(scan.next());
        System.out.println("\nQuantity: ");
        int quantity = Integer.parseInt(scan.next());
        System.out.println("\nProduction date: ");
        String productionDate = scan.next();
        System.out.println("\nExpiration date: ");
        String expirationDate = scan.next();
        ProductionLotDto dto = new ProductionLotDto(chocoID, quantity, productionDate, expirationDate);
        restTemplate.put(urlProdLot + "/{id}", dto, dto.getId());
        System.out.println(PINK_BRIGHT + "updated production lot");
    }

    private void deleteProductionLot() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nGive the ID:");
        Long id = scan.nextLong();
        restTemplate.delete(urlProdLot+"/{id}", id);
        System.out.println(PINK_BRIGHT + "deleted production lot");
    }

    public static final String PINK_BRIGHT = "\033[0;95m";   // PINK

    private void addProductionLot() {
        Scanner scan = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("\nGive an ID: ");
        Long id = scan.nextLong();
        System.out.println("\nChocolate ID: ");
        int chocoID = Integer.parseInt(scan.next());
        System.out.println("\nQuantity: ");
        int quantity = Integer.parseInt(scan.next());
        System.out.println("\nProduction date(dd/mm/yyyy): ");
        String productionDate = scan.next();
        System.out.println("\nExpiration date(dd/mm/yyyy): ");
        String expirationDate = scan.next();
        ProductionLotDto dto = new ProductionLotDto(chocoID, quantity, productionDate, expirationDate);
        dto.setId(id);
        restTemplate.postForObject(urlProdLot, dto, ProductionLotDto.class);
        System.out.println(PINK_BRIGHT + "saved production lot");
    }
}
