package konstantin.stepanyan.coursework;
import java.time.LocalDate; //импорт класса LocalDate, который предоставляет методы для работы с датой и временем.
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Класс Персональный Компьютер
public class PC {
    private String cpu;
    private int ram;
    private String ramType;
    private int storage;
    private String operatingSystem;
    private String gpu;

    //геттеры и сеттеры свойств ↓
    public String getCpu(){return this.cpu;}
    public void setCpu(String newCpu){this.cpu = newCpu;}
    public int getRam(){return this.ram;}
    public void setRam(int newRam){this.ram = newRam;}
    public String getRamType(){return this.ramType;}
    public void setRamType(String newRamType){this.ramType = newRamType;}
    public int getStorage(){return this.storage;}
    public void setStorage(int newStorage){this.storage = newStorage;}
    public String getOperatingSystem(){return this.operatingSystem;}
    public void setOperatingSystem(String newOperatingSystem){this.operatingSystem = newOperatingSystem;}
    public String getGpu(){return this.gpu;}
    public void setGpu(String newGpu){this.gpu = newGpu;}

    // конструктор класса ПК
    public PC(String cpu, int ram, String ramType, int storage, String operatingSystem, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.ramType = ramType;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = gpu;
    }

    //Конструктор класса ПК без видеокарты
    public PC(String cpu, int ram, String ramType, int storage, String operatingSystem) {
        this.cpu = cpu;
        this.ram = ram;
        this.ramType = ramType;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = "Интегрированная графика";
    }

    //Метод обновления конфигурации ↓
    public void updateConfiguration(String newCpu, int newRam, String newRamType, int newStorage, String newOperatingSystem, String newGpu) {
        this.setCpu(newCpu);
        this.setRam(newRam);
        this.setRamType(newRamType);
        this.setStorage(newStorage);
        this.setOperatingSystem(newOperatingSystem);
        this.setGpu(newGpu);
        System.out.println("Конфигурация обновлена: " + LocalDate.now());
    }

    //Метод печати конфигурации ↓
    public void printConfiguration() {
        System.out.println("Процессор: " + this.getCpu());
        System.out.println("Оперативная память: " + this.getRam() + " ГБ " + this.getRamType());
        System.out.println("Жёсткий диск: " + this.getStorage() + " ГБ");
        System.out.println("Операционная система: " + this.getOperatingSystem());
        System.out.println("Видеокарта: " + this.getGpu());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Конфигурация составлена: " + formattedDateTime);
    }


    public boolean matchesCriteria(String searchCriteria) {
        // Пример сравнения названия процессора без учета регистра:
        if (cpu != null && cpu.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Пример сравнения названия операционной системы без учета регистра:
        if (operatingSystem != null && operatingSystem.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Пример сравнения названия видеокарты без учета регистра:
        if (gpu != null && gpu.toLowerCase().contains(searchCriteria.toLowerCase())) {
            return true;
        }
        // Если ни один из критериев не соответствует, вернуть false.
        return false;
    }

}