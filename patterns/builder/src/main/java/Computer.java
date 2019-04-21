public class Computer {
    private String display;
    private String OS;
    private String manipulators;
    private int age;

    public String getOS() {
        return OS;
    }

    public String getManipulators() {
        return manipulators;
    }

    public String getDisplay() {
        return display;
    }

    public int getAge() {
        return age;
    }


    public static class Builder {
        private Computer newComputer;

        public Builder() {
            newComputer = new Computer();
        }

        public Builder Display(String name) {
            newComputer.display = name;
            return this;
        }

        public Builder OS(String surname) {
            newComputer.OS = surname;
            return this;
        }

        public Builder Manipulators(String name) {
            newComputer.manipulators = name;
            return this;
        }

        public Builder Age(int age) {
            newComputer.age = age;
            return this;
        }

        public Computer build() {
            return newComputer;
        }
    }
}
