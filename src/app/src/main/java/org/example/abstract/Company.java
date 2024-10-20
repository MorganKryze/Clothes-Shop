public class Company {
    private String name;
    private int capital;
    private int income;
    private int costs;

    public Company(String name, int capital) {
        try {
            if (name == null) {
                throw new IllegalArgumentException("Name cannot be null.");
            } else if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            } else if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank.");
            } else {
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(name.charAt(i))) {
                        throw new IllegalArgumentException("Name cannot contain digits.");
                    }
                }
            }
            this.name = name;

            if (capital < 0) {
                throw new IllegalArgumentException("Capital cannot be negative.");
            }
            this.capital = capital;

            this.income = 0;
            this.costs = 0;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        } else {
            for (int i = 0; i < name.length(); i++) {
                if (Character.isDigit(name.charAt(i))) {
                    throw new IllegalArgumentException("Name cannot contain digits.");
                }
            }
        }
        this.name = name;
    }

    public double getCapital() {
        return capital / 100.0;
    }

    public void setCapital(int capital) {
        if (capital < 0) {
            throw new IllegalArgumentException("Capital can't be negative");
        }
        this.capital = capital;

        // TODO : try and catch + repo
    }

    public double getIncome() {
        return income / 100.0;
    }

    public void updateIncome(double incomeToAdd) {
        this.income += incomeToAdd;

        // TODO : try and catch + repo
    }

    public double getCosts() {
        return costs / 100.0;
    }

    public void updateCosts(double costToAdd) {
        this.costs += costToAdd;

        // TODO : try and catch + repo
    }
}
