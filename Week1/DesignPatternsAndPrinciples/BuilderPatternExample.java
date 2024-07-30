package DesignPatternsAndPrinciples;

public class BuilderPatternExample {
    public static void main(String[] args) {
        
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM(32)
            .setStorage(1000)
            .setGraphicsCard(true)
            .setBluetooth(true)
            .setWifi(true)
            .build();

        
        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM(16)
            .setStorage(500)
            .setGraphicsCard(false)
            .setBluetooth(false)
            .setWifi(true)
            .build();

        
        System.out.println("Gaming PC: CPU: " + gamingPC.getCPU() + ", RAM: " + gamingPC.getRAM() + "GB, Storage: " + gamingPC.getStorage() + "GB, Graphics Card: " + gamingPC.hasGraphicsCard() + ", Bluetooth: " + gamingPC.hasBluetooth() + ", WiFi: " + gamingPC.hasWifi());
        System.out.println("Office PC: CPU: " + officePC.getCPU() + ", RAM: " + officePC.getRAM() + "GB, Storage: " + officePC.getStorage() + "GB, Graphics Card: " + officePC.hasGraphicsCard() + ", Bluetooth: " + officePC.hasBluetooth() + ", WiFi: " + officePC.hasWifi());
    }
}

class Computer {
    
    private String CPU;
    private int RAM;
    private int storage;
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;
    private boolean hasWifi;

    
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    
    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }

    public boolean hasBluetooth() {
        return hasBluetooth;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;
        private boolean hasWifi;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder setWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}


